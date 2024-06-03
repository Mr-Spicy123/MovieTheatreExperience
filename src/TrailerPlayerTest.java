import javafx.embed.swing.JFXPanel;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;

public class TrailerPlayerTest {
    public TrailerPlayerTest() {
        new JFXPanel();

        // Creating JFrame
        JFrame frame = new JFrame("Movie test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setVisible(true);

        // Getting the trailer file
        JFileChooser fileChooser = new JFileChooser(); // Create a new File Chooser
        fileChooser.setName("File chooser");
        fileChooser.setDialogTitle("Choose a trailer to play.");
        fileChooser.setCurrentDirectory(new File("src\\..\\")); // Set the current directory to the project directory
        fileChooser.setToolTipText("Select a trailer");
        fileChooser.setApproveButtonText("Choose trailer");
        fileChooser.setApproveButtonToolTipText("Open the selected trailer in the video player.");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(".mp4 (H.264)", "mp4"));

        String filePath = ""; // Variable used to store the file path

        // Repeatedly prompt a file path until the received path possesses the suffix ".mp4"
        while (!filePath.endsWith(".mp4")) {
            int returnVal = fileChooser.showOpenDialog(frame); // Prompt file chooser

            if (returnVal == JFileChooser.APPROVE_OPTION) { // If user clicked on the choose button
                File file = fileChooser.getSelectedFile(); // Get the selected file
                filePath = file.getPath(); // Set filePath to the selected path for the loop condition
            } else { // User clicked on a different button (ex: close button or cancel button)
                System.exit(0); // Exit the program.
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
