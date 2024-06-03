import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

public class Main {
    public static void main(String[] args){
        // Work around some weird bug with JavaFX
        Platform.setImplicitExit(false);
        new JFXPanel();

        // Starting the actual program
        new MainFrame();
    }
}