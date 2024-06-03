package GUI.Arcade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class pacmanWindow {

    public pacmanWindow() {
        // Create new JFrame
        JFrame frame = new JFrame("Pacman Game");

        // Set the size of JFrame
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create instance of Model class
        pacmanGame gamePanel = new pacmanGame();
        gamePanel.setPreferredSize(new Dimension(gamePanel.SCREEN_SIZE, gamePanel.SCREEN_SIZE + 40)); // Add space for the score display

        // Create container panel with GridBagLayout to center the game panel
        JPanel containerPanel = new JPanel(new GridBagLayout());
        containerPanel.setBackground(Color.BLACK); // Set the background color of the container panel
        containerPanel.add(gamePanel);

        // Create a back button
        JButton backButton = new JButton();
        backButton.setText("Back");
        backButton.setPreferredSize(new Dimension(120, 40));
        backButton.setBackground(new Color(255, 158, 212));

        // Create panel to hold the back button
        JPanel button = new JPanel();
        button.setBackground(Color.BLACK);
        button.add(backButton);

        // Add back button panel to the frame's south position
        frame.add(button, BorderLayout.SOUTH);

        // ActionListener for the back button to return to the starting menu
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Close the current frame
                frame.dispose();
                // Open the starting menu
                new pacmanStartingWindow();
                // Stop the game sound
                gamePanel.stopSound();
            }
        });

        // Add the container panel to frames centre position
        frame.add(containerPanel, BorderLayout.CENTER);


        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}











