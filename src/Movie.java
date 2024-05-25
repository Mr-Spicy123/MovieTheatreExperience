import javax.swing.*;
import java.awt.*;

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
            return this.toString().equals(m.toString());
        }
        return false;
    }
}

class TrailerPlayer extends JPanel {
    private Movie m;

    public TrailerPlayer() {
        this(new Movie());
    }

    public TrailerPlayer(Movie m) {

    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        super.paint(g);
    }
}