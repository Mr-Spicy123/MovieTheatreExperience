import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class pacmanStartingWindow extends JFrame {

    public pacmanStartingWindow() {

        // Set up the window
        super("Pacman Window"); // Set the window title
        setSize(800, 600); // Set window size

        // Create the background image
        ImageIcon bg = new ImageIcon("Res/BackgroundImage.jpg");
        JLabel background = new JLabel(bg); // Create label to hold background image
        background.setLayout(new BorderLayout()); // Set layout to BorderLayout

        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(120, 40));
        backButton.setBackground(new Color(255, 158, 212));


        JButton startButton = new JButton("Start");
        startButton.setPreferredSize(new Dimension(120, 40));
        startButton.setBackground(new Color(58, 86, 237));


        // Create panel to hold the buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false);
        buttonPanel.add(backButton);
        buttonPanel.add(startButton);


        // Add back button panel to the frames south position
        add(buttonPanel, BorderLayout.SOUTH);

         // Set preferred size
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // When clicked close current window and open pacmanWindow
                dispose();
                new pacmanWindow();
            }
        });

        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //code to ArcadeWindow
                setVisible(false); // Make window visible
            }
        });
        background.add(buttonPanel, BorderLayout.SOUTH);
        setContentPane(background); // Set background as content pane
        setVisible(true); // Make window visible


    }
}

