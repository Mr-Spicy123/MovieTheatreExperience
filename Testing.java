import javafx.embed.swing.JFXPanel;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;


public class Testing extends TrailerPlayer{

    public static void main(String[]args){



        //I don't think we need the
        int cost = 10;
        Movie YourName = new Movie("Your Name", cost, 2016, 107, Movie.Genres.Animation, "D:\\github program\\MovieTheatreExperience\\src\\Trailers\\YourName (2).mp4", "Unknown");
        YourName.setDescription("Two teenagers share a profound, magical connection upon discovering they are swapping bodies. Things manage to become even more complicated when the boy and girl decide to meet in person.\n" +
                "\n");

        Movie MIB = new Movie("Mission impossible: fall out", cost, 2018, 147, Movie.Genres.Action, "D:\\github program\\MovieTheatreExperience\\src\\Trailers\\Mission_ Impossible - Fallout (2018) - Official Trailer - Paramount Pictures.mp4", "Unknown");
        MIB.setDescription("A group of terrorists plans to detonate three plutonium cores for a simultaneous nuclear attack on different cities. Ethan Hunt, along with his IMF team, sets out to stop the carnage.\n" +
                "\n");

        Movie StarWars = new Movie("Star Wars: Revenge of the Sith", cost, 2005, 140, Movie.Genres.Action, "D:\\github program\\MovieTheatreExperience\\src\\Trailers\\Star Wars_ Episode III - Revenge of the Sith (2005) Trailer #1 _ Movieclips Classic Trailers.mp4", "Unknown");
        StarWars.setDescription("Three years into the Clone Wars, Obi-Wan Kenobi pursues a new threat, while Anakin Skywalker is lured by Chancellor Palpatine into a sinister plot to rule the galaxy. Nearly three years have passed since the beginning of the Clone Wars. The Republic, with the help of the Jedi, takes on Count Dooku and the Separatists.\n" +
                "\n");

        Movie EndGame = new Movie("Avengers: End Game", cost, 2019, 182, Movie.Genres.Action, "D:\\github program\\MovieTheatreExperience\\src\\Trailers\\Marvel Studios' Avengers - Official Trailer.mp4", "Unknown");
        EndGame.setDescription("The grave course of events set in motion by Thanos, that wiped out half the universe and fractured the Avengers ranks, compels the remaining Avengers to take one final stand in Marvel Studios' grand conclusion to twenty-two films\n" +
                "\n");

        Movie IT = new Movie("It", cost, 2017, 135, Movie.Genres.Horror, "D:\\github program\\MovieTheatreExperience\\src\\Trailers\\It Trailer #1 (2017) _ Movieclips Trailers.mp4", "Unknown");
        IT.setDescription("Seven young outcasts in Derry, Maine, are about to face their worst nightmare -- an ancient, shape-shifting evil that emerges from the sewer every 27 years to prey on the town's children. Banding together over the course of one horrifying summer, the friends must overcome their own personal fears to battle the murderous, bloodthirsty clown known as Pennywise.\n" +
                "\n");

        Movie AQP = new Movie("A Quiet Place", cost, 2018, 90, Movie.Genres.Horror, "D:\\github program\\MovieTheatreExperience\\src\\Trailers\\A QUIET PLACE _ Official Trailer _ Paramount Movies.mp4", "Unknown");
        AQP.setDescription("If they hear you, they hunt you. A family must live in silence to avoid mysterious creatures that hunt by sound. Knowing that even the slightest whisper or footstep can bring death, Evelyn and Lee are determined to find a way to protect their children while desperately searching for a way to fight back.\n" +
                "\n");

        Movie Shining = new Movie("The Shining", cost, 1980, 136, Movie.Genres.Horror, "D:\\github program\\MovieTheatreExperience\\src\\Trailers\\shining.mp4", "Unknown");
        Shining.setDescription("Jack Torrance (Jack Nicholson) becomes winter caretaker at the isolated Overlook Hotel in Colorado, hoping to cure his writer's block. He settles in along with his wife, Wendy (Shelley Duvall), and his son, Danny (Danny Lloyd), who is plagued by psychic premonitions. As Jack's writing goes nowhere and Danny's visions become more disturbing, Jack discovers the hotel's dark secrets and begins to unravel into a homicidal maniac hell-bent on terrorizing his family.\n" +
                "\n");

        Movie FSN = new Movie("Fate/stay night: Heaven's Feel I. presage flow", cost, 2017, 120, Movie.Genres.Animation, "D:\\github program\\MovieTheatreExperience\\src\\Trailers\\FSNHF1.mp4", "Unknown");
        FSN.setDescription("As in previous routes, the story focuses on a teenage mage named Shirou Emiya who takes part in a conflict known as the Holy Grail War to protect his city. However, this time Shirou encounters not only other mages and Servant warriors, but also a mysterious shadow killing most of the participants.\n" +
                "\n");

        Movie Suzume = new Movie("Suzume", cost, 2022, 122, Movie.Genres.Animation, "D:\\github program\\MovieTheatreExperience\\src\\Trailers\\Suzume.mp4", "Unknown");
        Suzume.setDescription("As the skies turn red and the planet trembles, Japan stands on the brink of disaster. However, a determined teenager named Suzume sets out on a mission to save her country. Able to see supernatural forces that others cannot, it's up to her to close the mysterious doors that are spreading chaos across the land. A perilous journey awaits as the fate of Japan rests on her shoulders.\n" +
                "\n");



        JFrame frame = new JFrame("Movie test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setVisible(true);



        Movie option = new Movie();
        option = FSN;
        // Creating & adding the trailer video player
        frame.add(option.createTrailerPlayer(), BorderLayout.CENTER);

        // Repaint & revalidate to fix any rendering errors
        frame.repaint();
        frame.revalidate();
    }


}
