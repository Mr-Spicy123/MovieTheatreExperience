import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyFrame implements ActionListener, MouseListener {
    JFrame frame;
    JPanel panel;
    JButton movieButton, foodButton, arcadeButton;
    public MyFrame() {
        frame = new JFrame("Movie Theatre");
        frame.setSize(1280, 800);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        panel = new JPanel(null);
        panel.setBackground(Color.BLACK);
        frame.add(panel);
        foodButton = new JButton("Popcorn and stuff");
        foodButton.setBackground(Color.RED);
        foodButton.setBounds(30, 30, 300, 100);
        foodButton.addActionListener(this);
        foodButton.addMouseListener(this);
        panel.add(foodButton);

        movieButton = new JButton("Movies");
        movieButton.setBackground(Color.RED);
        movieButton.setBounds(930, 30, 300, 100);
        movieButton.addActionListener(this);
        movieButton.addMouseListener(this);
        panel.add(movieButton);

        arcadeButton = new JButton("Arcade");
        arcadeButton.setBackground(Color.RED);
        arcadeButton.setBounds(480, 30, 300, 100);
        arcadeButton.addActionListener(this);
        panel.add(arcadeButton);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton){
            JButton clickedButton = (JButton) e.getSource();
            String textButton = clickedButton.getText();
            switch (textButton){
                case "Popcorn and stuff":
                    frame.add(new FoodPanel());
                    break;
                case "Movies":
                    new MoviePanel();
                case "Arcade":
                    break;
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        movieButton.setBackground(Color.GREEN);
        foodButton.setBackground(Color.green);
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent evt) {
        movieButton.setBackground(Color.RED);
    }
}
