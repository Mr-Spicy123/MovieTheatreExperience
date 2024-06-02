import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class arcadeWindow extends JFrame implements ActionListener{

    public arcadeWindow() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(MainFrame.frameSize);
        setLocationRelativeTo(null);
        this.setVisible(true);

        ImageIcon bg = new ImageIcon("Arcade.png");
        JLabel background = new JLabel(bg);

        // Top panel for the back button
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setOpaque(false);

        // Creating back button
        JButton backButton = createButton("Back");
        backButton.setBackground(new Color(0x131345));
        topPanel.add(backButton);

        // Center panel for game buttons
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setOpaque(false);

        // Creating game buttons
        JButton pacman = createButton("Pacman");
        pacman.setBackground(new Color(0xFFCE5D));

        JButton spaceInvader = createButton("Space Invaders");
        spaceInvader.setBackground(new Color(0x9A35FF));

        JButton snakeButton = createButton("Snake Game");
        snakeButton.setBackground(new Color(0x59D93A));

        // Adding game buttons to the center panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Adding insets for spacing
        centerPanel.add(pacman, gbc);

        gbc.gridy = 1;
        centerPanel.add(spaceInvader, gbc);

        gbc.gridy = 2;
        centerPanel.add(snakeButton, gbc);

        // adding button to the background
        background.setLayout(new BorderLayout());
        background.add(topPanel, BorderLayout.NORTH);
        background.add(centerPanel, BorderLayout.CENTER);

        backButton.addActionListener(this) ;
        pacman.addActionListener(this) ;
        spaceInvader.addActionListener(this) ;
        snakeButton.addActionListener(this) ;



        setContentPane(background);
        setVisible(true);
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
            switch (text){
                case "Movies":
                    new MoviePanel();
                    break;
                case "Food and drinks":
                    new FoodCourtGUI();
                    break;
                case "Arcade":
                    new arcadeWindow();
                    break;
                case "Exit":
                    System.exit(0);
                    break;
            }
        }
    }
}













