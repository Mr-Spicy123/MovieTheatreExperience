// Unfinished

import javax.sound.sampled.Clip;
import javax.swing.*;

public class TrailerPlayer extends JPanel {
    private Movie movie;
    private Clip audioClip;
    private boolean paused;

    public TrailerPlayer(Movie m) {
        movie = m;

    }

    public TrailerPlayer() {

    }
}
