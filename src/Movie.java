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
    public enum Genres {Action, Horror, Animation, UNKNOWN}

    // Instance variables
    private String name; // The name of the movie
    private float cost; // The cost of the movie tickets
    private int releaseYear; // The year of release
    private float movieDurationMinutes; // The length of the movie (in minutes)
    private Genres genre; // The genre of the movie (choose from enum class Genres above)
    private String trailerFilePath; // The path of the trailer to be played (should be from content root)
    private String coverFilePath; // The path of the cover to display (should be from content root)
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
                "",
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
        // Chaining constructor
        this(
                n,
                c,
                release,
                duration,
                g,
                path,
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
    public Movie(String n, float c, int release, float duration, Genres g, String path, String cover) {
        // Initiating/Instantiating instance variables to their corresponding parameter
        name = n;
        cost = c;
        releaseYear = release;
        movieDurationMinutes = duration;
        genre = g;
        trailerFilePath = path;
        coverFilePath = cover;
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
     * Get the genre of the movie
     * @return The genre of the movie (see {@link Movie.Genres})
     */
    public Genres getGenre() {
        return genre;
    }

    /**
     * Set the genre of the movie
     * @param g The new genre of the movie (see {@link Movie.Genres})
     */
    public void setGenre(Genres g) {
        genre = g;
    }

    /**
     * Get the path of the local trailer media file.
     * @return {@code String} The file path (from content root)
     */
    public String getTrailerFilePath() {
        return trailerFilePath;
    }

    /**
     * Set the path of the local trailer media file.
     * @param path {@code String} The new file path (from content root)
     */
    public void setTrailerFilePath(String path) {
        trailerFilePath = path;
    }

    /**
     * Get the path of the local cover media file.
     * @return {@code String} The file path (from content root)
     */
    public String getCoverFilePath() {
        return coverFilePath;
    }

    /**
     * Set the path of the local cover media file.
     * @param cover {@code String} The new file path (from content root)
     */
    public void setCoverFilePath(String cover) {
        coverFilePath = cover;
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

    /**
     * Get the description of the Movie object.
     * @return A description set by the developer using the {@code setDescription(String d)} method.
     * If no such description exists, returns a programmatically generated description.
     */
    @Override
    public String toString() {
        if (description == null) {
            // Generate a movie description using instance variables
            return name + " (released in " + releaseYear + ")" + " is a " +
                    String.valueOf(genre).toLowerCase() + " movie. " +
                    "It lasts " + movieDurationMinutes + " minutes, and tickets cost $" +
                    cost + ". ";
        } else {
            return description; // Return developer-set description if it exists,
        }
    }

    /**
     * Check if two objects share the same properties
     * @param o The object to compare
     * @return {@code true} if object o is an instance of {@link Movie}, and shares the same properties of this Movie object.
     * {@code false} if either of the conditions doesn't apply.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Movie m) { // Checking if o is an instance of Movie, and parsing to Movie object
            return (this.getName().equals(m.getName()) && // Check if the name is the same
                    this.getCost() == m.getCost() && // Check if cost is the same
                    this.getReleaseYear() == m.getReleaseYear() && // Check if release year is the same
                    this.getMovieDurationMinutes() == m.getMovieDurationMinutes() && // Check if the movie duration is the same
                    this.getGenre() == m.getGenre() && // Check fi the genre is the same
                    this.getTrailerFilePath().equals(m.getTrailerFilePath()) && // Check if the trailer is the same
                    this.getCoverFilePath().equals(m.getCoverFilePath()) && // Check if the cover is the same
                    this.getDescription().equals(m.getDescription()) // Check if the description is the same (even if it's null)
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
    private final JLabel timeLabel, statusLabel;

    private MediaPlayer player;
    private JFXPanel vidPanel;

    private boolean paused;
    private boolean ready;

    public TrailerPlayer() {
        this(new Movie());
    }

    public TrailerPlayer(Movie m) {
        movie = m;
        paused = true;
        ready = false;

        // Creating components
        view = new JPanel();
        bottomBar = new JPanel();
        pauseButton = new JButton();
        slideBar = new JSlider();
        timeLabel = new JLabel();
        statusLabel = new JLabel();

        // Config components
        init();
    }

    /**
     * Build the UI
     */
    public void init() {
        // Configure JPanel
        setBackground(Color.BLACK);
        setName("TrailerPlayer (" + movie.getName() + ")");
        setLayout(new BorderLayout());
        setBackground(new Color(0, 0, 0));
        setBorder(BorderFactory.createLineBorder(Color.WHITE));
        setFocusable(false);

        // Configure view
        view.setName("View");
        view.setLayout(new GridLayout(1, 1)); // Only one component allowed, which is video
        view.setBackground(new Color(0, 255, 0, 0));
        view.setBorder(null);
        view.setFocusable(false);

        // Configure bottom bar
        bottomBar.setName("Bottom");
        bottomBar.setLayout(new GridBagLayout());
        bottomBar.setBackground(Color.BLACK);
        bottomBar.setBorder(null);
        bottomBar.setFocusable(false);
        bottomBar.setPreferredSize(new Dimension(0, 50));
        bottomBar.setVisible(false);

        GridBagConstraints bottomConstraints = new GridBagConstraints();
        bottomConstraints.fill = GridBagConstraints.BOTH;
        bottomConstraints.anchor = GridBagConstraints.CENTER;
        bottomConstraints.weighty = 1.0;
        bottomConstraints.insets = new Insets(0, 3, 3, 3);

        // Configure status label
        statusLabel.setName("statusLabel");
        statusLabel.setText("Loading...");
        statusLabel.setFocusable(false);
        statusLabel.setBackground(Color.BLACK);
        statusLabel.setForeground(Color.WHITE);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        statusLabel.setVisible(true);

        // Configure video player
        vidPanel = new JFXPanel();
        vidPanel.setVisible(false);

        player = new MediaPlayer(
                new Media(new File(movie.getTrailerFilePath()).toURI().toString())
        );
        player.setOnError(() -> { // Run the following anytime an error occurs
            // Display and print the error for debugging
            statusLabel.setText("An error occurred while playing your video: " + player.getError().getMessage());
            System.out.println("An error occurred while playing the video: " + player.getError().getMessage());
        });
        if (player.getStatus() == MediaPlayer.Status.READY) { // Check if media already loaded
            initPlayer(); // Start the video player
        } else { // If not loaded yet
            player.setOnReady(() -> { // Wait for media to load. Once loaded, run the following
                initPlayer(); // Start the video player
                // Repaint + revalidate to fix any errors or bugs
                repaint();
                revalidate();
            });
        }

        // Configuring vidPanel properties
        vidPanel.setName("Video Panel");
        vidPanel.setBackground(new Color(0, 0, 0));
        vidPanel.setFocusable(false);
        vidPanel.setBorder(null);

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

        // Configure pause button
        pauseButton.setText(PLAY_TEXT);
        pauseButton.setFocusable(false);
        pauseButton.addActionListener(this);
        pauseButton.setBorder(null);
        pauseButton.setBackground(Color.BLACK);
        pauseButton.setForeground(Color.WHITE);
        pauseButton.setFont(new Font("Arial", Font.BOLD, 25));
        pauseButton.setPreferredSize(new Dimension(100, 0));

        // Configure slider bar
        slideBar.setName("Slider");
        slideBar.setFocusable(false);
        slideBar.setMajorTickSpacing(1);
        slideBar.setPaintTicks(false);
        slideBar.setBackground(Color.BLACK);
        slideBar.addChangeListener(a -> { // Run the following anytime the slide bar changes
            if (paused) { // If paused, constantly update the video layer and the time label to the va;ie pf the slide bar
                int millis = slideBarValueToMillis(slideBar.getValue());
                player.seek(Duration.millis(millis)); // Setting the video player position
                timeLabel.setText(millisToTime(millis)); // Updating the text of the time label
            }
            // Repaint + revalidate the bottomBar to fix any errors or bugs
            bottomBar.repaint();
            bottomBar.revalidate();
        });

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
        add(statusLabel, BorderLayout.NORTH);
    }

    /**
     * Starts the media player and adds the required listeners to the required components.
     */
    private void initPlayer() {
        slideBar.setMinimum(0);
        slideBar.setMaximum(millisToSlideBarValue((int) player.getTotalDuration().toMillis()));
        slideBar.setValue(0);

        statusLabel.setVisible(false);
        vidPanel.setVisible(true);
        bottomBar.setVisible(true);

        player.currentTimeProperty().addListener((a, duration, b) -> { // Run the following each time the player frame updates
            if (!paused) { // Check if isn't paused
                // Overwrite the slide bar value and the time label text to the current time of the player
                slideBar.setValue(millisToSlideBarValue((int) duration.toMillis()));
                timeLabel.setText(millisToTime((int) duration.toMillis()));
            }
        });

        player.setOnEndOfMedia(() -> {
            player.seek(Duration.ZERO);
        }); // Restart the video

        ready = true; // Flag the TrailerPlayer as ready-to-play
    }

    /**
     * Programmatically pause the video
     */
    public void pause() {
        paused = true;
        pauseButton.setText(PLAY_TEXT);
        slideBar.setEnabled(true);
        player.pause();
    }

    /**
     * Programmatically play the video
     */
    public void play() {
        paused = false;
        pauseButton.setText(PAUSE_TEXT);
        slideBar.setEnabled(false);
        player.play();
    }

    /**
     * Programmatically stop the video
     */
    public void stop() {
        pause();
        slideBar.setValue(0);
        player.seek(Duration.ZERO);
    }

    /**
     * Programmatically close the video
     */
    public void close() {
        setVisible(false);
        player.dispose();
    }

    /**
     * Convert milliseconds to slide bar value
     * @param millis The milliseconds to convert
     * @return Slide bar value
     */
    public int millisToSlideBarValue(int millis) {
        return (millis/100);
    }

    /**
     * Convert slide bar value into milliseconds
     * @param slideBarValue The value to convert
     * @return Milliseconds
     */
    public int slideBarValueToMillis(int slideBarValue) {
        return (slideBarValue*100);
    }

    public String millisToTime(int millis) { // Convert milliseconds to minutes:seconds format
        int min = millis/60000; // Minutes to display
        int sec = (millis/1000) % 60; // Seconds under a minute to display

        String strMin, strSec; // String version of the above integers
        // If minute is below 10, concatenate a zero in front of it (this way it shows as "03" instead of just "3").
        if (min < 10) {
            strMin = 0 + String.valueOf(min);
        } else {
            strMin = String.valueOf(min);
        }

        // Repeat the above for seconds
        if (sec < 10) {
            strSec = 0 + String.valueOf(sec);
        } else {
            strSec = String.valueOf(sec);
        }

        // Return string minutes : string seconds
        return strMin + ":" + strSec;
    }

    @Override
    public void paint(Graphics g) {
        // [Experimental] trying to smoothen the rendering
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        super.paint(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(pauseButton)) { // Pause button is clicked
            if (ready) { // Check if UI is loaded
                if (paused) {
                    play(); // If currently pause, play.
                } else {
                    pause(); // If currently playing, pause.
                }
            }
            repaint(); // Repaint to fix any rendering issues
        }
    }
}