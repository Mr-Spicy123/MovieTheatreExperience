import javafx.embed.swing.JFXPanel;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;

public class TrailerPlayerTest {
    public static void main(String[] args) {
        new JFXPanel();

        // Creating JFrame
        JFrame frame = new JFrame("Movie test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setVisible(true);

        // Getting the trailer file
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setName("File chooser");
        fileChooser.setToolTipText("Select a trailer");
        fileChooser.setApproveButtonText("Choose trailer");
        fileChooser.setApproveButtonToolTipText("Open the selected trailer in the video player.");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(".mp4 (H.264)", "mp4"));

        String filePath = "";

        while (!filePath.endsWith(".mp4")) {
            int returnVal = fileChooser.showOpenDialog(frame);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                filePath = file.getPath();
            } else {
                System.out.println("User chose to exit.");
                System.exit(0);
            }
        }

        // Creating the movie object
        Movie movie1 = new Movie("Twisters", 40f, 2024, 100f, Movie.Genres.Action, filePath);

        // Creating & adding the trailer video player
        frame.add(movie1.createTrailerPlayer(), BorderLayout.CENTER);

        // Repaint & revalidate to fix any rendering errors
        frame.repaint();
        frame.revalidate();
    }
}
