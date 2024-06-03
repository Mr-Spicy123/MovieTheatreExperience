package GUI.Arcade;

//import statements
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;

public class pacmanGame extends JPanel implements ActionListener {

    //variables

    //audio clip
    private Clip clip;

    //dimensions of window
    private Dimension d;
    private final Font smallFont = new Font("Arial", Font.BOLD, 14);

    //indicating whether the game is currently in progress or if Pacman is dying.
    private boolean inGame = false;
    private boolean dying = false;

    //constatnts

    //size of block in the maze
    private final int BLOCK_SIZE = 24;

    //number of blocks in maze
    private final int N_BLOCKS = 15;

    //size of game window
    public final int SCREEN_SIZE = N_BLOCKS * BLOCK_SIZE;

    //max number of ghosts
    private final int MAX_GHOSTS = 12;

    //pacman speed
    private final int PACMAN_SPEED = 4;

    //number of ghosts
    private int N_GHOSTS = 8;

    //num of lives remaining
    private int lives, score;

    //arrays for pacman and ghost positions, directions, and speeds
    private int[] dx, dy;
    private int[] ghost_x, ghost_y, ghost_dx, ghost_dy, ghostSpeed;

    //images
    private Image heart, ghost;
    private Image up, down, left, right;

    //coordinates of pacman
    private int pacman_x, pacman_y, pacmand_x, pacmand_y;

    //requested direction of pacman by user
    private int req_dx, req_dy;

    //structure of maze
    private final short levelData[] = {
            19, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 22,
            17, 16, 16, 16, 16, 24, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            25, 24, 24, 24, 28, 0, 17, 16, 16, 16, 16, 16, 16, 16, 20,
            0,  0,  0,  0,  0,  0, 17, 16, 16, 16, 16, 16, 16, 16, 20,
            19, 18, 18, 18, 18, 18, 16, 16, 16, 16, 24, 24, 24, 24, 20,
            17, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
            17, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
            17, 16, 16, 16, 24, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
            17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 18, 18, 18, 18, 20,
            17, 24, 24, 28, 0, 25, 24, 24, 16, 16, 16, 16, 16, 16, 20,
            21, 0,  0,  0,  0,  0,  0,   0, 17, 16, 16, 16, 16, 16, 20,
            17, 18, 18, 22, 0, 19, 18, 18, 16, 16, 16, 16, 16, 16, 20,
            17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            25, 24, 24, 24, 26, 24, 24, 24, 24, 24, 24, 24, 24, 24, 28
    };

    //valid ghostspeeds
    private final int validSpeeds[] = {1, 2, 3, 4, 6, 8};

    //highest speed for ghost
    private final int maxSpeed = 6;
    private int currentSpeed = 3;

    //state of maze
    private short[] screenData;

    //updates game stats at intervals
    private Timer timer;

    //constructor for game
    public pacmanGame() {

        loadImages();
        initVariables();
        addKeyListener(new TAdapter());
        setFocusable(true);
        initGame();
        playSound("pacmanTheme.wav");
    }


    //loads images for pacman, ghosts, and hearts
    private void loadImages() {
        down = new ImageIcon("down.gif").getImage();
        up = new ImageIcon("up.gif").getImage();
        left = new ImageIcon("ArcadeResources/left.gif").getImage();
        right = new ImageIcon("right.gif").getImage();
        ghost = new ImageIcon("ghost.gif").getImage();
        heart = new ImageIcon(".png").getImage();

    }

    //method initializes many variables in game. stes up initial state of game. sets up timer
    private void initVariables() {

        screenData = new short[N_BLOCKS * N_BLOCKS];
        d = new Dimension(400, 400);
        ghost_x = new int[MAX_GHOSTS];
        ghost_dx = new int[MAX_GHOSTS];
        ghost_y = new int[MAX_GHOSTS];
        ghost_dy = new int[MAX_GHOSTS];
        ghostSpeed = new int[MAX_GHOSTS];
        dx = new int[4];
        dy = new int[4];

        timer = new Timer(40, this);
        timer.start();
    }

    //main game loop. if pacmans not dying, pacman moves. if dying triggers death method
    private void playGame(Graphics2D g2d) {

        if (dying) {

            death();

        } else {

            movePacman();
            drawPacman(g2d);
            moveGhosts(g2d);
            checkMaze();
        }
    }

    //shows message for players to click 'Space'
    private void showIntroScreen(Graphics2D g2d) {

        String start = "Press SPACE to start";
        g2d.setColor(Color.yellow);
        g2d.drawString(start, (SCREEN_SIZE)/4, 150);
    }
    //displays users score
    private void drawScore(Graphics2D g) {
        g.setFont(smallFont);
        g.setColor(new Color(228, 45, 76));

        //creates string that contains the text 'score' + players score
        String s = "Score: " + score;

        //draws score string on screen. location calculated based on screen size
        g.drawString(s, SCREEN_SIZE / 2 + 96, SCREEN_SIZE + 16);

        //loop iterates over number of lives remaining
        for (int i = 0; i < lives; i++) {

            //draws a heart for ecah remaining life. i*28+8 calculates horizontal pos of heart.
            g.drawImage(heart, i * 28 + 8, SCREEN_SIZE + 1, this);
        }
    }

    //checks if all dots on maze are eaten
    private void checkMaze() {

        //used to iterate through screenData array
        int i = 0;
        boolean finished = true;

        //loop iterates over each block of maze as long as i is less than total number of blocks
        while (i < N_BLOCKS * N_BLOCKS && finished) {

            //checks if current block has any dot - if so sets boolean finished to false
            if ((screenData[i]) != 0) {
                finished = false;
            }

            //increases index to check next box
            i++;
        }

        if (finished) {

            //if game is finished adds 50 to score
            score += 50;

            //increases num of ghost until max
            if (N_GHOSTS < MAX_GHOSTS) {
                N_GHOSTS++;
            }

            //increases speed until max speed
            if (currentSpeed < maxSpeed) {
                currentSpeed++;
            }

            //method to ste up next game level
            initLevel();
        }
    }

    //handles when pacman bumps into ghost
    private void death() {

        // decreases number of lives
        lives--;

        //if no more lives left sets inGame boolean to false
        if (lives == 0) {
            inGame = false;
        }

        //if there are still lives,continue game
        continueLevel();

    }

    //method to control movement of ghosts
    private void moveGhosts(Graphics2D g2d) {

        //current pos of ghosts in screendata array
        int pos;

        //num of directions ghost can move in
        int count;

        //loop iterates through each ghost
        for (int i = 0; i < N_GHOSTS; i++) {

            //checks if ghost is at exact block position - they can only change directions at these points
            if (ghost_x[i] % BLOCK_SIZE == 0 && ghost_y[i] % BLOCK_SIZE == 0) {

                //calculates ghosts position in screenData
                pos = ghost_x[i] / BLOCK_SIZE + N_BLOCKS * (int) (ghost_y[i] / BLOCK_SIZE);

                //set count of possible directiosn to 0
                count = 0;

                /*these conditions check if there are no walls in the way and if ghost is not moving in opposite direction
                if direction is available, added to dx and dy arrays and count is increased*/

                if ((screenData[pos] & 1) == 0 && ghost_dx[i] != 1) {
                    dx[count] = -1;
                    dy[count] = 0;
                    count++;
                }

                if ((screenData[pos] & 2) == 0 && ghost_dy[i] != 1) {
                    dx[count] = 0;
                    dy[count] = -1;
                    count++;
                }

                if ((screenData[pos] & 4) == 0 && ghost_dx[i] != -1) {
                    dx[count] = 1;
                    dy[count] = 0;
                    count++;
                }

                if ((screenData[pos] & 8) == 0 && ghost_dy[i] != -1) {
                    dx[count] = 0;
                    dy[count] = 1;
                    count++;
                }

                //if no directions available - check if ghost is at dead end
                if (count == 0) {

                    //if so, stop ghost or change direction
                    if ((screenData[pos] & 15) == 15) {
                        ghost_dx[i] = 0;
                        ghost_dy[i] = 0;
                    } else {
                        ghost_dx[i] = -ghost_dx[i];
                        ghost_dy[i] = -ghost_dy[i];
                    }

                    //if other directions available, randomly choose from dx and dy arrays
                } else {

                    count = (int) (Math.random() * count);

                    if (count > 3) {
                        count = 3;
                    }

                    ghost_dx[i] = dx[count];
                    ghost_dy[i] = dy[count];
                }

            }

            //moving the ghost, update ghost pos and speed and draw ghost at this ne position
            ghost_x[i] = ghost_x[i] + (ghost_dx[i] * ghostSpeed[i]);
            ghost_y[i] = ghost_y[i] + (ghost_dy[i] * ghostSpeed[i]);
            drawGhost(g2d, ghost_x[i] + 1, ghost_y[i] + 1);

            //check if pacman hits the ghost, if so than pacman dies
            if (pacman_x > (ghost_x[i] - 12) && pacman_x < (ghost_x[i] + 12)
                    && pacman_y > (ghost_y[i] - 12) && pacman_y < (ghost_y[i] + 12)
                    && inGame) {

                dying = true;
            }
        }
    }

    //createes ghost at certain poistion on screen
    private void drawGhost(Graphics2D g2d, int x, int y) {
        g2d.drawImage(ghost, x, y, this);
    }

    //movement of pacman
    private void movePacman() {

        // position of Pacman in the screenData array
        int pos;

        // value of the cell in screenData where Pacman is currently located
        short ch;

        // Check if pacman is aligned with the grid
        if (pacman_x % BLOCK_SIZE == 0 && pacman_y % BLOCK_SIZE == 0) {

            // Calculate pacmans position index in the screenData array
            pos = pacman_x / BLOCK_SIZE + N_BLOCKS * (int) (pacman_y / BLOCK_SIZE);

            // get the value of the cell at pacmans current position
            ch = screenData[pos];

            // Check if the current cell contains a dot
            if ((ch & 16) != 0) {

                // Clear the dot from the cell
                screenData[pos] = (short) (ch & 15);

                // increase the score as Pacman eats the dot
                score++;
            }

            // Check if there is a new direction requested by the player
            if (req_dx != 0 || req_dy != 0) {

                // make sure that requested direction does not lead Pacman into a wall
                // Check each direction and see if there's a wall in the way

                if (!((req_dx == -1 && req_dy == 0 && (ch & 1) != 0)  // Left
                        || (req_dx == 1 && req_dy == 0 && (ch & 4) != 0)   // Right
                        || (req_dx == 0 && req_dy == -1 && (ch & 2) != 0)  // Up
                        || (req_dx == 0 && req_dy == 1 && (ch & 8) != 0))) // Down
                {
                    // If the requested direction is valid, update pacmans direction
                    pacmand_x = req_dx;
                    pacmand_y = req_dy;
                }
            }

            // Check if pacmans current direction leads into a wall
            // If there's a wall in the current direction, stop pacmans movement
            if ((pacmand_x == -1 && pacmand_y == 0 && (ch & 1) != 0)  // Left
                    || (pacmand_x == 1 && pacmand_y == 0 && (ch & 4) != 0)   // Right
                    || (pacmand_x == 0 && pacmand_y == -1 && (ch & 2) != 0)  // Up
                    || (pacmand_x == 0 && pacmand_y == 1 && (ch & 8) != 0))  // Down
            {
                // Set Pacman's direction to 0
                pacmand_x = 0;
                pacmand_y = 0;
            }
        }

        // update pacmans position by adding the current direction multiplied by speed
        pacman_x = pacman_x + PACMAN_SPEED * pacmand_x;
        pacman_y = pacman_y + PACMAN_SPEED * pacmand_y;
    }

    //drawing pacman graphic
    private void drawPacman(Graphics2D g2d) {

        if (req_dx == -1) {
            g2d.drawImage(left, pacman_x + 1, pacman_y + 1, this);
        } else if (req_dx == 1) {
            g2d.drawImage(right, pacman_x + 1, pacman_y + 1, this);
        } else if (req_dy == -1) {
            g2d.drawImage(up, pacman_x + 1, pacman_y + 1, this);
        } else {
            g2d.drawImage(down, pacman_x + 1, pacman_y + 1, this);
        }
    }

    //draw maze, layout and walls
    private void drawMaze(Graphics2D g2d) {

        // index to iterate through levelData and screenData arrays
        short i = 0;

        //variables for x and y coordinates
        int x, y;

        // Loop through entire screen height in steps of BLOCK_SIZE
        for (y = 0; y < SCREEN_SIZE; y += BLOCK_SIZE) {

            // Loop through entire screen width in steps of BLOCK_SIZE
            for (x = 0; x < SCREEN_SIZE; x += BLOCK_SIZE) {

                //drawing color for walls and empty spaces
                g2d.setColor(new Color(255, 158, 212));

                //stroke width for drawing lines
                g2d.setStroke(new BasicStroke(5));

                // Check if the current cell is an empty space in levelData
                if ((levelData[i] == 0)) {

                    //Fill current block with the specified color to show an empty space
                    g2d.fillRect(x, y, BLOCK_SIZE, BLOCK_SIZE);
                }

                // Draw left border if the current cell has the 1st bit set
                if ((screenData[i] & 1) != 0) {
                    g2d.drawLine(x, y, x, y + BLOCK_SIZE - 1);
                }

                //top border if the current cell has the 2nd bit set (top wall)
                if ((screenData[i] & 2) != 0) {
                    g2d.drawLine(x, y, x + BLOCK_SIZE - 1, y);
                }

                //right border if the current cell has the 3rd bit set (right wall)
                if ((screenData[i] & 4) != 0) {
                    g2d.drawLine(x + BLOCK_SIZE - 1, y, x + BLOCK_SIZE - 1, y + BLOCK_SIZE - 1);
                }

                //bottom border if the current cell has the 4th bit set (bottom wall)
                if ((screenData[i] & 8) != 0) {
                    g2d.drawLine(x, y + BLOCK_SIZE - 1, x + BLOCK_SIZE - 1, y + BLOCK_SIZE - 1);
                }

                //dot if the current cell has the 5th bit set (dot present)
                if ((screenData[i] & 16) != 0) {

                    // Set the color for the dot
                    g2d.setColor(new Color(255, 255, 255));

                    // Draw the dot as a small oval in center of the block
                    g2d.fillOval(x + 10, y + 10, 6, 6);
                }

                // move to the next cell in levelData and screenData arrays
                i++;
            }
        }
    }

    //sets game up at start
    private void initGame() {

        // set number of lives for the player to 3
        lives = 3;

        // set player's score to 0
        score = 0;

        // set level by calling the initLevel method
        initLevel();

        // set number of ghosts in the game to 6
        N_GHOSTS = 6;

        //set initial speed of the game to 3
        currentSpeed = 3;
    }

    //stes current level by copying level data and setting up ghost and pacman starting positions.
    private void initLevel() {

        // Loop through all the blocks in the level
        for (int i = 0; i < N_BLOCKS * N_BLOCKS; i++) {

            // Copy the level data into the screen data array
            screenData[i] = levelData[i];
        }

        // Continue the level
        continueLevel();
    }

    //continues current level by setting ghost positions, directions, and speeds.
    private void continueLevel() {

            // set ghost direction
            int dx = 1;
            int random;

            // Loop through all ghosts
            for (int i = 0; i < N_GHOSTS; i++) {

                // Set starting position of the ghost
                ghost_y[i] = 4 * BLOCK_SIZE; // start position
                ghost_x[i] = 4 * BLOCK_SIZE;

                // Set initial direction of the ghost
                ghost_dy[i] = 0;
                ghost_dx[i] = dx;

                // opposite direction for the next ghost
                dx = -dx;

                // random speed for the ghost
                random = (int) (Math.random() * (currentSpeed + 1));

                // makes sure random speed is not greater than the current speed
                if (random > currentSpeed) {
                    random = currentSpeed;
                }

                // gives a valid speed to the ghost
                ghostSpeed[i] = validSpeeds[random];
            }

            // Set the starting position of pacman
            pacman_x = 7 * BLOCK_SIZE;
            pacman_y = 11 * BLOCK_SIZE;

            // Reset pacman's direction of movement
            pacmand_x = 0;
            pacmand_y = 0;

            // reset requested direction controls
            req_dx = 0;
            req_dy = 0;

            // pacman isnt dying
            dying = false;
        }

    //Draws maze, Pacman, ghosts, score, and intro screen depending on the game state.
    public void paintComponent(Graphics g) {
        super.paintComponents(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, d.width, d.height);

        drawMaze(g2d);
        drawScore(g2d);

        if (inGame) {
            playGame(g2d);
        } else {
            showIntroScreen(g2d);
        }

        Toolkit.getDefaultToolkit().sync();
        g2d.dispose();
    }

    //controls
    class TAdapter extends KeyAdapter {

        //key event for controlling pacmans movement and starting the game.
        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if (inGame) {
                if (key == KeyEvent.VK_LEFT) {
                    req_dx = -1;
                    req_dy = 0;
                } else if (key == KeyEvent.VK_RIGHT) {
                    req_dx = 1;
                    req_dy = 0;
                } else if (key == KeyEvent.VK_UP) {
                    req_dx = 0;
                    req_dy = -1;
                } else if (key == KeyEvent.VK_DOWN) {
                    req_dx = 0;
                    req_dy = 1;
                } else if (key == KeyEvent.VK_ESCAPE && timer.isRunning()) {
                    inGame = false;
                }
            } else {
                if (key == KeyEvent.VK_SPACE && !inGame) {
                    inGame = true;
                    initGame();
                }
            }
        }
    }

    //method to play auido
    public void playSound(String filePath) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("pacmanTheme.wav"));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY); // Loop the sound
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    //methdo to stop audio when needed
    public void stopSound() {
        if (clip != null && clip.isRunning()) {

            clip.close();
        }
    }

    //repainst panel to updtae game graphics
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

}







