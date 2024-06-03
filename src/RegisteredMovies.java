/**
 * A class containing a pre-constructed Movie for every registered movie (you're welcome)
 */
public class RegisteredMovies {
    public static final float COST = 10f;
    public static class Action {
        public static final Movie MISSION_IMPOSSIBLE = new Movie(
                "Mission Impossible - Fallout",
                COST,
                2018,
                147,
                Movie.Genres.Action,
                "Res\\Trailers\\MissionImpossible-Fallout.mp4",
                "A group of terrorists plans to detonate three plutonium cores for<br/>" +
                        "a simultaneous nuclear attack on different cities. Ethan Hunt, along<br/>" +
                        "with his IMF team, sets out to stop the carnage.",
                "Res\\MissionImp.jpg"
        );
        public static final Movie STAR_WARS = new Movie(
                "Star Wars: Revenge of The Sith ",
                COST,
                2005,
                140,
                Movie.Genres.Action,
                "Res\\Trailers\\StarWars-RevengeOfTheSith.mp4",
                "Three years into the Clone Wars, Obi-Wan Kenobi pursues<br/>" +
                        "a new threat, while Anakin Skywalker is lured by Chancellor<br/>" +
                        "Palpatine into a sinister plot to rule the galaxy. Nearly<br/>" +
                        "three years have passed since the beginning of the Clone Wars.<br/>" +
                        "The Republic, with the help of the Jedi, takes on Count Dooku<br/>" +
                        "and the Separatists.",
                "Res\\Starwars.jpg"
        );
        public static final Movie AVENGERS_END_GAME = new Movie(
                "Avengers: End Game",
                COST,
                2019,
                182,
                Movie.Genres.Action,
                "Res\\Trailers\\MarvelStudios-AvengersEndgame.mp4",
                "The grave course of events set in motion by Thanos, that wiped<br/>" +
                        "out half the universe and fractured the Avengers ranks, compels<br/>" +
                        "the remaining Avengers to take one final stand in Marvel Studios'<br/>" +
                        "grand conclusion to twenty-two films",
                "Res\\Avengers.jpg"
        );
    }

    public static class Horror {
        public static final Movie IT = new Movie(
                "It",
                COST,
                2017,
                137,
                Movie.Genres.Horror,
                "Res\\Trailers\\It.mp4",
                "Seven young outcasts in Derry, Maine, are about to face<br/>" +
                        "their worst nightmare -- an ancient, shape-shifting<br/>" +
                        "evil that emerges from the sewer every 27 years to<br/>" +
                        "prey on the town's children. Banding together over<br/>" +
                        "the course of one horrifying summer, the friends must<br/>" +
                        "overcome their own personal fears to battle the murderous,<br/>" +
                        "bloodthirsty clown known as Pennywise.",
                "Res\\It.jpg"
        );
        public static final Movie A_QUIET_PLACE = new Movie(
                "A Quiet Place",
                COST,
                2018,
                90,
                Movie.Genres.Horror,
                "Res\\Trailers\\AQUIETPLACE.mp4",
                "If they hear you, they hunt you. A family must live in<br/>" +
                        "silence to avoid mysterious creatures that hunt by sound.<br/>" +
                        "Knowing that even the slightest whisper or footstep can<br/>" +
                        "bring death, Evelyn and Lee are determined to find a way<br/>" +
                        "to protect their children while desperately searching for<br/>" +
                        "a way to fight back.",
                "Res\\AQuietPlace.jpg"
        );
        public static final Movie SHINING = new Movie(
                "The Shining",
                COST,
                1980,
                136,
                Movie.Genres.Horror,
                "Res\\Trailers\\TheShining.mp4",
                "Jack Torrance (Jack Nicholson) becomes winter caretaker at<br/>" +
                        "the isolated Overlook Hotel in Colorado, hoping to cure<br/>" +
                        "his writer's block. He settles in along with his wife,<br/>" +
                        "Wendy (Shelley Duvall), and his son, Danny (Danny Lloyd),<br/>" +
                        "who is plagued by psychic premonitions. As Jack's writing<br/>" +
                        "goes nowhere and Danny's visions become more disturbing,<br/>" +
                        "Jack discovers the hotel's dark secrets and begins to<br/>" +
                        "unravel into a homicidal maniac hell-bent on terrorizing<br/>" +
                        "his family.",
                "Res\\Shining.jpg"
        );
    }

    public static class Animation {
        public static final Movie FATE = new Movie(
                "Fate/stay night",
                COST,
                2017,
                120,
                Movie.Genres.Animation,
                "Res\\Trailers\\FateStayNight.mp4",
                "As in previous routes, the story focuses on a teenage mage<br/>" +
                        "named Shirou Emiya who takes part in a conflict known as<br/>" +
                        "the Holy Grail War to protect his city. However, this<br/>" +
                        "time Shirou encounters not only other mages and Servant<br/>" +
                        "warriors, but also a mysterious shadow killing most of<br/>" +
                        "the participants.",
                "Res\\FateNight.jpg"
        );
        public static final Movie SUZUME = new Movie(
                "Suzume",
                COST,
                2022,
                122,
                Movie.Genres.Animation,
                "Res\\Trailers\\Suzume.mp4",
                "As the skies turn red and the planet trembles, Japan stands<br/>" +
                        "on the brink of disaster. However, a determined teenager<br/>" +
                        "named Suzume sets out on a mission to save her country.<br/>" +
                        "Able to see supernatural forces that others cannot, it's<br/>" +
                        "up to her to close the mysterious doors that are spreading<br/>" +
                        "chaos across the land. A perilous journey awaits as the<br/>" +
                        "fate of Japan rests on her shoulders.",
                "Res\\Suzume.jpg"
        );
        public static final Movie YOUR_NAME = new Movie(
                "Your Name",
                COST,
                2016,
                107,
                Movie.Genres.Animation,
                "Res\\Trailers\\YourName.mp4",
                "Two teenagers share a profound, magical connection upon<br/>" +
                        "discovering they are swapping bodies. Things manage to<br/>" +
                        "become even more complicated when the boy and girl<br/>" +
                        "decide to meet in person.",
                "Res\\YourName.jpg"
        );
    }
}
