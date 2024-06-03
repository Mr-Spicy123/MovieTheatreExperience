import GUI.MainFrame;
import javafx.application.Platform;

public class TheMovieExperience {
    public static void main(String[] args) {
        Platform.setImplicitExit(false);
        System.out.println("Launching The Movie Experience...");

        new MainFrame(); // Starting Andrew's GUI
    }
}