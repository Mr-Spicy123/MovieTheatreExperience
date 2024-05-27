import javax.swing.*;
import java.awt.*;

public class MoviePanel extends JPanel {
    JFrame frame;
    public MoviePanel(){
        frame = new JFrame();
        frame.setSize(1280,800);
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel(null);
        panel.setBackground(Color.MAGENTA);
        frame.add(panel);
        JLabel label = new JLabel("Review");
        JLabel label2 = new JLabel("Movies");
        label2.setForeground(Color.blue);
        label.setForeground(Color.blue);
        label.setBounds(30,30,300, 30);
        label2.setBounds(930,30,300, 30);
        panel.add(label2);
        panel.add(label);
        frame.setVisible(true);

    }
}
