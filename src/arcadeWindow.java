import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class arcadeWindow extends JFrame implements ActionListener {

    private JButton backButton;
    private JButton pacMan;
    private JButton snakeButton;
    private JButton spaceInvader;

    public arcadeWindow() {


        setSize(MainFrame.frameSize);
        setLocationRelativeTo(null);
        this.setVisible(true);

        JLabel bGlabel = new JLabel(new ImageIcon("Res/image_2024-6-2_220264876.png.jpg"));
        bGlabel.setBounds(0, 0, 1280, 800);
        this.add(bGlabel);



        // initializes the buttons
        initButtons();

        // Center panel for game buttons
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setOpaque(false);


        // Adding game buttons to the center panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Adding insets for spacing

        centerPanel.add(pacMan, gbc);

        gbc.gridy = 1;
        centerPanel.add(spaceInvader, gbc);

        gbc.gridy = 2;
        centerPanel.add(snakeButton, gbc);

        gbc.gridy = 3;
        centerPanel.add(backButton, gbc);

        // adding button to the background
        bGlabel.setLayout(new BorderLayout());
        bGlabel.add(centerPanel, BorderLayout.CENTER);


        setContentPane(bGlabel);
        setVisible(true);
    }
    private void initButtons(){
        // Creating back button
        backButton = createButton("Back");
        backButton.setBackground(new Color(0x131345));

        // Creating game buttons
        pacMan = createButton("Pacman");
        pacMan.setBackground(new Color(0xFFCE5D));

        spaceInvader = createButton("Space Invaders");
        spaceInvader.setBackground(new Color(0x9A35FF));

        snakeButton = createButton("Snake Game");
        snakeButton.setBackground(new Color(0x59D93A));

        backButton.addActionListener(this) ;
        pacMan.addActionListener(this) ;
        spaceInvader.addActionListener(this) ;
        snakeButton.addActionListener(this) ;

    }
    // Method to create buttons
    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(150, 40)); // Set bigger preferred size
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton){
            JButton clickedButton = (JButton) e.getSource();
            String text = clickedButton.getText();
            System.out.println(text);
            switch (text){
                case "Pacman":
                    new pacmanStartingWindow();
                    break;
                case "Space Invader":

                    break;
                case "Snake Game":
                    new snakeGUI();
                    break;
                case "Back":
                    System.out.println("yes");
                    this.dispose();
                    break;
            }
        }
    }
}













