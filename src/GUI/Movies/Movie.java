package GUI.Movies;

/**
 * The movie class. Holds information such as the name, genre, length, file path, etc.
 */
public class Movie {
    /**
     * {@code enum} containing the movie genre options. Access using {@code dot-operator}. Example: {@code GUI.Movies.Movie.Genres.Action}
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
     * Creates a new GUI.Movies.Movie object with default values.
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
     * Creates a new GUI.Movies.Movie object.
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
     * Creates a new GUI.Movies.Movie object.
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
     * Creates a new GUI.Movies.Movie object.
     * @param n The name
     * @param c The cost of the movie ticket
     * @param release The release year
     * @param duration The duration in minutes
     * @param g The genre of the movie (see {@link Movie.Genres} for selections)
     * @param path The path of the trailer video file
     * @param desc The description
     */
    public Movie(String n, float c, int release, float duration, Genres g, String path, String desc) {
        // Initiating/Instantiating instance variables to their corresponding parameter
        name = n;
        cost = c;
        releaseYear = release;
        movieDurationMinutes = duration;
        genre = g;
        trailerFilePath = path;
        description = desc;
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
    public TrailerPlayer createTrailerPlayer() {
        return new TrailerPlayer(this);
    }

    /**
     * Create a swing GUI tab equipped with everything required for a movie.
     * @param m {@code GUI.Movies.Movie} GUI.Movies.Movie object
     * @return {@code JPanel} The JPanel tab
     */
    public static TrailerPlayer createTrailerPlayer(Movie m) {
        return new TrailerPlayer(m);
    }

    /**
     * Set the description of the movie. This is also what returns when {@code toString()} is called.
     * @param d {@code String} GUI.Movies.Movie description
     */
    public void setDescription(String d) {
        description = d;
    }

    /**
     * Get the description of the movie. This is also what returns when {@code toString()} is called.
     * @return {@code String} GUI.Movies.Movie description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get the description of the GUI.Movies.Movie object.
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
     * @return {@code true} if object o is an instance of {@link Movie}, and shares the same properties of this GUI.Movies.Movie object.
     * {@code false} if either of the conditions doesn't apply.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Movie m) { // Checking if o is an instance of GUI.Movies.Movie, and parsing to GUI.Movies.Movie object
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