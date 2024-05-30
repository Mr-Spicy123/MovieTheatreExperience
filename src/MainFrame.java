import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainFrame implements ActionListener, MouseListener {
    public MainFrame(){
        JFrame frame = new JFrame();
        frame.setSize(1280, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("WELCOME TO LANDMARK CINEMAS", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
        frame.add(titleLabel, BorderLayout.NORTH);
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                int width = getWidth();
                int height = getHeight();
                Color startColor = Color.MAGENTA;
                Color endColor = Color.GREEN;
                GradientPaint gradient = new GradientPaint(0, 0, startColor, width, height, endColor);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, width, height);
            }
        };
        mainPanel.setLayout(null);
        frame.add(mainPanel, BorderLayout.CENTER);

        JButton moviesButton = new JButton("Movies");
        JButton foodAndDrinksButton = new JButton("Food and drinks");
        JButton arcadeButton = new JButton("Arcade");
        JButton exit = new JButton("Exit");

        moviesButton.setBounds(69, 150, 335, 200);
        foodAndDrinksButton.setBounds(473, 150, 335, 200);
        arcadeButton.setBounds(877, 150, 335, 200);
        exit.setBounds(565, 650, 150, 30);

        moviesButton.setBackground(Color.WHITE);
        foodAndDrinksButton.setBackground(Color.WHITE);
        arcadeButton.setBackground(Color.WHITE);
        exit.setBackground(Color.RED);

        moviesButton.addActionListener(this);
        foodAndDrinksButton.addActionListener(this);
        arcadeButton.addActionListener(this);
        exit.addActionListener(this);

        moviesButton.addMouseListener(this);
        foodAndDrinksButton.addMouseListener(this);
        arcadeButton.addMouseListener(this);

        mainPanel.add(moviesButton);
        mainPanel.add(foodAndDrinksButton);
        mainPanel.add(arcadeButton);
        mainPanel.add(exit);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton){
            JButton clickedButton = (JButton) e.getSource();
            String text = clickedButton.getText();
            switch (text){
                case "Movies":
                    new MoviePanel();
                    break;
                case "Food and drinks":
                    break;
                case "Arcade":
                    break;
                case "Exit":
                    System.exit(0);
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
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() instanceof JButton){
            JButton button = (JButton) e.getSource();
            button.setBackground(new Color(12, 80, 236));
        }
    }
    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() instanceof JButton){
            JButton button = (JButton) e.getSource();
            button.setBackground(Color.WHITE);
        }
    }
}
