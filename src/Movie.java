import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Screen;
import javafx.util.Duration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * The movie class. Holds information such as the name, genre, length, file path, etc.
 */
public class Movie {
    /**
     * {@code enum} containing the movie genre options. Access using {@code dot-operator}. Example: {@code Movie.Genres.Action}
     */
    public enum Genres {Action, Horror, UNKNOWN}

    // Instance variables
    private String name; // The name of the movie
    private float cost; // The cost of the movie tickets
    private int releaseYear; // The year of release
    private float movieDurationMinutes; // The length of the movie (in minutes)
    private Genres genre; // The genre of the movie (choose from enum class Genres above)
    private String trailerFilePath; // The path of the trailer to be played
    private String description; // The developer-set description

    /**
     * Creates a new Movie object with default values.
     */
    public Movie() {
        // Chain constructor
        this(
                "UNKNOWN",
                0f,
                0,
                0f,
                Genres.UNKNOWN
        );
    }

    /**
     * Creates a new Movie object.
     * @param n The name
     * @param c The cost of the movie ticket
     * @param release The release year
     * @param duration The duration in minutes
     * @param g The genre of the movie (see {@link Movie.Genres} for selections)
     */
    public Movie(String n, float c, int release, float duration, Genres g) {
        // Chaining constructor
        this(
                n,
                c,
                release,
                duration,
                g,
                ""
        );
    }

    /**
     * Creates a new Movie object.
     * @param n The name
     * @param c The cost of the movie ticket
     * @param release The release year
     * @param duration The duration in minutes
     * @param g The genre of the movie (see {@link Movie.Genres} for selections)
     * @param path The path of the trailer video file
     */
    public Movie(String n, float c, int release, float duration, Genres g, String path) {
        // Initiating/Instantiating instance variables to their corresponding parameter
        name = n;
        cost = c;
        releaseYear = release;
        movieDurationMinutes = duration;
        genre = g;
        trailerFilePath = path;
    }

    /**
     * Get the name of the movie
     * @return {@code String} representing the new name of the movie.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the movie
     * @param n {@code String} representing the new name of the movie.
     */
    public void setName(String n) {
        name = n;
    }

    /**
     * Get the cost of the movie tickets
     * @return {@code float} Cost of each movie ticket in dollars
     */
    public float getCost() {
        return cost;
    }

    /**
     * Set the cost of the movie tickets
     * @param c {@code float} New cost of each movie ticket in dollars
     */
    public void setCost(float c) {
        cost = c;
    }

    /**
     * Get the release year of the movie
     * @return {@code int} representing the release year of the movie
     */
    public int getReleaseYear() {
        return releaseYear;
    }

    /**
     * Set the release year of the movie
     * @param release {@code int} representing the new release year of the movie
     */
    public void setReleaseYear(int release) {
        releaseYear = release;
    }

    /**
     * Get the duration of the movie in minutes
     * @return {@code float} representing the duration of the movie
     */
    public float getMovieDurationMinutes() {
        return movieDurationMinutes;
    }

    /**
     * Set the duration of the movie in minutes
     * @param duration {@code float} The new duration of the movie
     */
    public void setMovieDurationMinutes(float duration) {
        movieDurationMinutes = duration;
    }

    /**
     * Set the genre of the movie
     * @param g The new genre of the movie (see {@link Movie.Genres})
     */
    public void setGenre(Genres g) {
        genre = g;
    }

    /**
     * Get the genre of the movie
     * @return The genre of the movie (see {@link Movie.Genres})
     */
    public Genres getGenre() {
        return genre;
    }

    /**
     * Set the path of the local trailer media file.
     * @param path {@code String} The new file path
     */
    public void setTrailerFilePath(String path) {
        trailerFilePath = path;
    }

    /**
     * Get the path of the local trailer media file.
     * @return {@code String} The file path
     */
    public String getTrailerFilePath() {
        return trailerFilePath;
    }

    /**
     * Create a swing GUI tab equipped with everything required for this movie.
     * @return {@code JPanel} The JPanel tab
     */
    public JPanel createTrailerPlayer() {
        return new TrailerPlayer(this);
    }

    /**
     * Create a swing GUI tab equipped with everything required for a movie.
     * @param m {@code Movie} Movie object
     * @return {@code JPanel} The JPanel tab
     */
    public static JPanel createTrailerPlayer(Movie m) {
        return new TrailerPlayer(m);
    }

    /**
     * Set the description of the movie. This is also what returns when {@code toString()} is called.
     * @param d {@code String} Movie description
     */
    public void setDescription(String d) {
        description = d;
    }

    /**
     * Get the description of the movie. This is also what returns when {@code toString()} is called.
     * @return {@code String} Movie description
     */
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        if (description == null) {
            // Generate a movie description using concatenation
            return name + " (released in " + releaseYear + ")" + " is a " +
                    String.valueOf(genre).toLowerCase() + " movie. " +
                    "It lasts " + movieDurationMinutes + " minutes, and tickets cost $" +
                    cost + ". ";
        } else {
            return  description; // Return developer-set description if it exists,
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Movie m) { // Checking if o is a instance of Movie, and parsing to Movie object
            return (this.getName().equals(m.getName()) &&
                    this.getCost() == m.getCost() &&
                    this.getReleaseYear() == m.getReleaseYear() &&
                    this.getMovieDurationMinutes() == m.getMovieDurationMinutes() &&
                    this.getGenre() == m.getGenre() &&
                    this.getTrailerFilePath().equals(m.getTrailerFilePath()) &&
                    this.getDescription().equals(m.getDescription())
                    );
        }
        return false; // Return false by default if o isn't a movie.
    }
}

class TrailerPlayer extends JPanel implements ActionListener {
    public static final String PAUSE_TEXT = "||";
    public static final String PLAY_TEXT =  ">";

    private final Movie movie;
    private final JPanel view, bottomBar;
    private final JButton pauseButton;
    private final JSlider slideBar;
    private final JLabel timeLabel;

    private final MediaPlayer player;

    private final Timer timer;

    private boolean paused;

    public TrailerPlayer() {
        this(new Movie());
    }

    public TrailerPlayer(Movie m) {
        movie = m;
        paused = true;

        timer = new Timer(1, this);

        // Creating components
        view = new JPanel();
        bottomBar = new JPanel();
        pauseButton = new JButton();
        slideBar = new JSlider();
        timeLabel = new JLabel();
        player = new MediaPlayer(
                new Media(new File(m.getTrailerFilePath()).toURI().toString())
        );

        // Config components
        init();

        // Start timer
        timer.start();
    }

    public void init() {
        // Configure JPanel
        setBackground(Color.BLACK);
        setName("TrailerPlayer (" + movie.getName() + ")");
        setLayout(new BorderLayout());
        setBackground(new Color(0, 0, 0));
        setBorder(null);
        setFocusable(false);

        // Configure view
        view.setName("View");
        view.setLayout(new GridLayout(1, 1)); // Only one component allowed, which is video
        view.setBackground(new Color(0, 255, 0, 0));
        view.setBorder(null);
        view.setFocusable(false);

        // Configure video player
        JFXPanel vidPanel = new JFXPanel();

        vidPanel.setName("Video Panel");
        vidPanel.setBackground(new Color(0, 0, 0));
        vidPanel.setFocusable(false);

        MediaView vidViewer = new MediaView(player);
        vidViewer.setFocusTraversable(false);

        Rectangle2D screen = Screen.getPrimary().getVisualBounds();
        vidViewer.setX((screen.getWidth() - view.getWidth()) / 2);
        vidViewer.setY((screen.getHeight() - view.getHeight()) / 2);

        DoubleProperty width = vidViewer.fitWidthProperty();
        DoubleProperty height = vidViewer.fitHeightProperty();
        width.bind(Bindings.selectDouble(vidViewer.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(vidViewer.sceneProperty(), "height"));
        vidViewer.setPreserveRatio(true); // Keep the aspect ratio

        StackPane layout = new StackPane();
        layout.setStyle("-fx-background-color: black"); // Setting a background for space that isn't taken up by the video (it's a little weird, it takes in a String, not a Color obj)
        layout.setFocusTraversable(false);

        Scene scene = new Scene(layout);

        layout.getChildren().add(vidViewer);

        vidPanel.setScene(scene);

        // Configure bottom bar
        bottomBar.setName("Bottom");
        bottomBar.setLayout(new GridBagLayout());
        bottomBar.setBackground(new Color(255, 0, 0, 0));
        bottomBar.setBorder(null);
        bottomBar.setFocusable(false);
        bottomBar.setPreferredSize(new Dimension(0, 50));

        GridBagConstraints bottomConstraints = new GridBagConstraints();
        bottomConstraints.fill = GridBagConstraints.BOTH;
        bottomConstraints.anchor = GridBagConstraints.CENTER;
        bottomConstraints.weighty = 1.0;
        bottomConstraints.insets = new Insets(0, 3, 3, 3);

        // Configure pause button
        pauseButton.setText(PLAY_TEXT);
        pauseButton.setFocusable(false);
        pauseButton.addActionListener(this);
        pauseButton.setBorder(null);
        pauseButton.setContentAreaFilled(false);
        pauseButton.setBackground(Color.BLACK);
        pauseButton.setForeground(Color.WHITE);
        pauseButton.setFont(new Font("Arial", Font.BOLD, 25));
        pauseButton.setPreferredSize(new Dimension(100, 0));

        // Configure slider bar
        slideBar.setName("Slider");
        slideBar.setFocusable(false);
        slideBar.setMinimum(0);
        slideBar.setMaximum((int) player.getTotalDuration().toMillis()/2);
        slideBar.setMajorTickSpacing(1);
        slideBar.setPaintTicks(false);
        slideBar.setBackground(Color.BLACK);
        slideBar.setValue(0);

        // Configure time label
        timeLabel.setName("TimeLabel");
        timeLabel.setFocusable(false);
        timeLabel.setText("0:00");
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 15));

        // Adding components
        bottomConstraints.gridx = 0;
        bottomConstraints.gridy = 0;
        bottomConstraints.gridwidth = 1;
        bottomConstraints.gridheight = 1;
        bottomConstraints.weightx = 0.02;
        bottomBar.add(pauseButton, bottomConstraints);

        bottomConstraints.gridx = 1;
        bottomConstraints.gridy = 0;
        bottomConstraints.gridwidth = 1;
        bottomConstraints.gridheight = 1;
        bottomConstraints.weightx = 0.88;
        bottomBar.add(slideBar, bottomConstraints);

        bottomConstraints.gridx = 2;
        bottomConstraints.gridy = 0;
        bottomConstraints.gridwidth = 1;
        bottomConstraints.gridheight = 1;
        bottomConstraints.weightx = 0.1;
        bottomBar.add(timeLabel, bottomConstraints);

        view.add(vidPanel);
        add(view, BorderLayout.CENTER);
        add(bottomBar, BorderLayout.SOUTH);
    }

    public void pause() {
        paused = true;
        pauseButton.setText(PLAY_TEXT);
        slideBar.setEnabled(true);
        player.pause();
    }

    public void play() {
        paused = false;
        pauseButton.setText(PAUSE_TEXT);
        slideBar.setEnabled(false);
        player.play();
    }

    public void stop() {
        pause();
        slideBar.setValue(0);
        player.seek(Duration.ZERO);
    }

    public String millisToMinutes(int millis) {
        int min = millis/60000;
        int sec = (millis/1000) % 60;

        String strMin, strSec;
        if (min < 10) {
            strMin = 0 + String.valueOf(min);
        } else {
            strMin = String.valueOf(min);
        }

        if (sec < 10) {
            strSec = 0 + String.valueOf(sec);
        } else {
            strSec = String.valueOf(sec);
        }

        return strMin + ":" + strSec;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        super.paint(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(pauseButton)) {
            if (paused) {
                play();
            } else {
                pause();
            }
        } else if (e.getSource().equals(timer)) {
            if (paused) {
                player.seek(Duration.millis(slideBar.getValue()*2));
            } else {
                slideBar.setValue((int) player.getCurrentTime().toMillis()/2);
                if (player.getCurrentTime().equals(player.getTotalDuration())) {
                    stop();
                }
            }
            timeLabel.setText(millisToMinutes((int) player.getCurrentTime().toMillis()));
        }

        repaint();
    }
}