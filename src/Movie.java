import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * The movie class. Holds information such as the name, genre, length, file path, etc.
 */
public class Movie {
    public enum Genres {Action, Horror}

    // Instance variables
    private String name; // The name of the movie
    private int releaseYear; // The year of release
    private float movieDurationMinutes; // The length of the movie (in minutes)
    private Genres genre; // The genre of the movie (choose from enum class Genres above)
    private String[] actors; // String array containing different actors
    private String trailerFilePath; // The path of the trailer to be played

    /**
     * Creates a new Movie object.
     * @param n The name
     * @param release The release year
     * @param duration The duration in minutes
     * @param g The genre of the movie (see {@link Movie.Genres} for selections)
     * @param a A array of the starring actors
     * @param path The path of the trailer video file
     */
    public Movie(String n, int release, float duration, Genres g, String[] a, String path) {
        // Initiating/Instantiating instance variables to their corresponding parameter
        name = n;
        releaseYear = release;
        movieDurationMinutes = duration;
        genre = g;
        actors = a;
        trailerFilePath = path;
    }
}