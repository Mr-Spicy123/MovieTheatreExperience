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

        ImageIcon bgimageicon = new ImageIcon("Res/image_2024-06-02_220648276.png.jpg");
        Image bgimage = bgimageicon.getImage();

        int width = 1920; // New width for the scaled image
        int height = 1080; // New height for the scaled image
        Image scaledImage = bgimage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel label = new JLabel(scaledIcon); // Create a JLabel to display the scaled image
        this.add(label); // Add the JLabel to the component




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


        centerPanel.add(snakeButton, gbc);

        gbc.gridy = 2;
        centerPanel.add(pacMan, gbc);

        gbc.gridy = 3;
        centerPanel.add(backButton, gbc);

        // adding button to the background
        label.setLayout(new BorderLayout());
        label.add(centerPanel, BorderLayout.CENTER);


        setContentPane(label);
        setVisible(true);
    }
    private void initButtons(){
        // Creating back button
        backButton = createButton("Back");
        backButton.setBackground(new Color(0xE75252));

        // Creating game buttons
        pacMan = createButton("Pacman");
        pacMan.setBackground(new Color(0xFFCE5D));


        snakeButton = createButton("Snake Game");
        snakeButton.setBackground(new Color(0x59D93A));

        backButton.addActionListener(this) ;
        pacMan.addActionListener(this) ;
        snakeButton.addActionListener(this) ;

    }
    // Method to create buttons
    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(230, 70)); // Set bigger preferred size
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
                case "Back":
                    System.out.println("yes");
                    this.dispose();
                    break;
            }
        }
    }
}













