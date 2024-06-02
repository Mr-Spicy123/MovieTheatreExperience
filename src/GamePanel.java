import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.awt.*;
import javax.swing.*;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener{
	
	Timer timer;
	Random random;
	JLayeredPane killScreen;
	JLabel scoreResult;
	JLabel timeElapsed;
	JButton restart;

	
	static final int PANEL_WIDTH = 600;
	static final int PANEL_LENGTH = 600;
	static final int UNIT_SIZES = 25;
	static final int GAME_UNITS = (PANEL_WIDTH*PANEL_LENGTH)/UNIT_SIZES;
	static final int DELAY = 100;
	final int x[] = new int [GAME_UNITS];
	final int y[] = new int [GAME_UNITS];
	static int score;
	
	
	
	
	int bodyparts = 4;
	int applesEaten;
	int appleXPos;
	int appleYPos;
	boolean isRunning = false;
	char direction = 'D';
	
			
	
	
	
	public GamePanel() {
		
		
		random = new Random();
		
		
		this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_LENGTH));
		this.setBackground(new Color(0, 0, 0));
		this.addKeyListener(new KeyAdapterr());
		this.setFocusable(true);
		gameStart();
		
		
	}
	
	
	public void gameStart() {
		
		spawnApple();
		isRunning = true;
		timer = new Timer(DELAY,this);
		timer.start();
		
	}
	public void paint(Graphics g) {
		
		super.paintComponent(g);
		draw(g);
		
		
	}
	
	
	
	public void draw(Graphics g) {// Lines on grid
		
		for (int i = 0; i < PANEL_WIDTH/UNIT_SIZES; i++) {
			
			g.drawLine(i*UNIT_SIZES, 0, i*UNIT_SIZES, PANEL_LENGTH);
			g.drawLine(0, i*UNIT_SIZES, PANEL_WIDTH, i*UNIT_SIZES);
			g.setColor(new Color(64, 4, 27));
		}
		
		g.setColor(new Color(164, 80, 212)); //apple
		g.fillOval(appleXPos, appleYPos, UNIT_SIZES, UNIT_SIZES);
		
		for(int j = 0; j<bodyparts; j++) {
			
			if (j==0) {// Snake body
				
				g.setColor(new Color(119, 127, 209)); 
				g.fillOval(x[j], y[j],UNIT_SIZES , UNIT_SIZES);
			}else {
				
				g.setColor(new Color(102, 129, 1));
				g.fillRect(x[j],  y[j], UNIT_SIZES,  UNIT_SIZES);
			}
		}
		
		if(isRunning == false) {
			killScreen(g);
		}
	}
	public void move() {
		
		for(int i = bodyparts; i>0; i--) {
			x[i]= x[i-1];
			y[i]= y[i-1];
			
			
		}
		
		switch(direction) {
		
		case 'U':
			y[0]= y[0] - UNIT_SIZES;
		break;
		case 'D':
			y[0] = y[0] + UNIT_SIZES;
		break;
		case 'L':
			x[0] = x[0] -UNIT_SIZES;
		break;
		case 'R':
			x[0] = x[0] + UNIT_SIZES;
		
		}
	}
	
	public void checkCollisions() {
		
		for (int i = 1; i< bodyparts; i++) {
			if(x[0]==x[i]&&y[0]==y[i]) {
				
				isRunning = false;
			}
			
		if(x[0]<0) { 
			isRunning = false;
		}else if (x[0]>PANEL_WIDTH) {
			
			isRunning = false;
		}else if(y[0]<0) {
			isRunning = false;
		}else if(y[0]>PANEL_LENGTH) {
			isRunning = false;
		}
			
			
		}
	}
	
	
	public void spawnApple() {
		
		appleXPos = random.nextInt((int)(PANEL_WIDTH/UNIT_SIZES))*UNIT_SIZES;
		appleYPos = random.nextInt((int)(PANEL_LENGTH/UNIT_SIZES))*UNIT_SIZES;
		
	}
	public void checkApple() {
		
		if(appleXPos == x[0] && appleYPos == y[0]) {
			
			spawnApple();
			score ++;
			bodyparts++;
			
		}
		
	}
	
	public void killScreen(Graphics g) {
		
	g.setColor(new Color(0,0,0,90));
	g.fillRect(0, 0, PANEL_WIDTH, PANEL_LENGTH);
	g.setColor(Color.RED);
	g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
	g.drawString("Score: " + score, 250, 300);
	g.setColor(Color.RED);
	g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
	g.drawString("GAME OVER", 150, 200);
	
		
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(isRunning) {
			move();
			checkApple();
			checkCollisions();
			
			
		}else if(isRunning ==false) {
			
			System.out.println("Game Over!");
			
			
			
		}
		repaint();
	}
	
	public class KeyAdapterr extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			
			switch (e.getKeyCode()) {
			
			case KeyEvent.VK_LEFT:
				if(direction != 'R') {	
					direction = 'L';
			}
			break;
			case KeyEvent.VK_RIGHT:
				if(direction != 'L') {
					direction = 'R';
				}
			break;
			case KeyEvent.VK_UP:
				if(direction!='D') {
					direction = 'U';
				}
			break;
			case KeyEvent.VK_DOWN:
				if(direction != 'U') {
					direction = 'D';
				}
			
			
			
			}
			
			
		}
		
		
		
	}

}
