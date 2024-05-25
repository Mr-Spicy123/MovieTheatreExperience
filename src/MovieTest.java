import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class MovieTest {
    public static void main(String[] args) {
        Movie movie1 = new Movie("Lego Movie 1", 40f, 2014, 100f, Movie.Genres.Action);
        Movie movie2 = new Movie("Lego Movie 2", 45f, 2019, 107f, Movie.Genres.Action);
        
        JFrame frame = new JFrame("Movie test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setLayout(new BorderLayout());
        
        JPanel movieTab = movie1.createTrailerPlayer();
        
        frame.add(movieTab, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
