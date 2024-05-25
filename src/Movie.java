/**
 * The movie class. Holds information such as the name, genre, length, file path, etc.
 */
public class Movie {
    public enum Genres {Action, Horror, UNKNOWN}

    // Instance variables
    private String name; // The name of the movie
    private float cost; // The cost of the movie tickets
    private int releaseYear; // The year of release
    private float movieDurationMinutes; // The length of the movie (in minutes)
    private Genres genre; // The genre of the movie (choose from enum class Genres above)
    private String trailerFilePath; // The path of the trailer to be played

    /**
     * Creates a new Movie object.
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

    @Override
    public String toString() {
        // Concatenating strings and variables to compose an english description of the movie.
        return name + " (released in " + releaseYear + ")" + " is a " +
                String.valueOf(genre).toLowerCase() + " movie. " +
                "It lasts " + movieDurationMinutes + " minutes, and tickets cost $" +
                cost + ". ";
    }
}