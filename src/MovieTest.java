import javafx.embed.swing.JFXPanel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class MovieTest {
    public static void main(String[] args) {
        new JFXPanel();
        Movie movie1 = new Movie("Twisters", 40f, 2024, 100f, Movie.Genres.Action, "src\\TwistersTrailer.mp4");
        
        JFrame frame = new JFrame("Movie test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setLayout(new GridLayout(2,2));

        frame.add(movie1.createTrailerPlayer());
        frame.add(movie1.createTrailerPlayer());
        frame.add(movie1.createTrailerPlayer());
        frame.add(movie1.createTrailerPlayer());

        frame.setVisible(true);
        frame.repaint();
    }
}
