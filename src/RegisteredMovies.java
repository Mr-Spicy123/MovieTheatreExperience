public class RegisteredMovies {
    public static final float COST = 10f;
    public class Action {
        public static final Movie MISSION_IMPOSSIBLE = new Movie(
                "Mission Impossible - Fallout",
                COST,
                2018,
                147,
                Movie.Genres.Action,
                "src\\Trailers\\MissionImpossible-Fallout.mp4",
                "A group of terrorists plans to detonate three plutonium cores for a simultaneous nuclear attack on different cities." +
                        "Ethan Hunt, along with his IMF team, sets out to stop the carnage."
        );
        public static final Movie STAR_WARS = new Movie(
                "Star Wars: Revenge of The Sith ",
                COST,
                2005,
                140,
                Movie.Genres.Action,
                "src\\Trailers\\StarWars-RevengeOfTheSith.mp4",
                "<html>" +
                        "Three years into the Clone Wars, Obi-Wan Kenobi pursues<br/>" +
                        "a new threat, while Anakin Skywalker is lured by Chancellor<br/>" +
                        "Palpatine into a sinister plot to rule the galaxy. Nearly<br/>" +
                        "three years have passed since the beginning of the Clone Wars.<br/>" +
                        "The Republic, with the help of the Jedi, takes on Count Dooku<br/>" +
                        "and the Separatists." +
                    "</html>"
        );
        public static final Movie AVENGERS_END_GAME = new Movie(
                "Avengers: End Game",
                COST,
                2019,
                182,
                Movie.Genres.Action,
                "src\\Trailers\\MarvelStudios-AvengersEndgame.mp4",
                "The grave course of events set in motion by Thanos, that wiped out half the universe and fractured the Avengers ranks, compels the remaining Avengers to take one final stand in Marvel Studios' grand conclusion to twenty-two films"
        );
    }

    public class Horror {
        public static final Movie IT = new Movie(
                "It",
                COST,
                2017,
                137,
                Movie.Genres.Horror,
                "src\\Trailers\\It.mp4",
                "Seven young outcasts in Derry, Maine, are about to face their worst nightmare -- an ancient, shape-shifting evil that emerges from the sewer every 27 years to prey on the town's children. Banding together over the course of one horrifying summer, the friends must overcome their own personal fears to battle the murderous, bloodthirsty clown known as Pennywise."
        );
        public static final Movie A_QUIET_PLACE = new Movie(
                "A Quiet Place",
                COST,
                2018,
                90,
                Movie.Genres.Horror,
                "src\\Trailers\\AQUIETPLACE.mp4",
                "If they hear you, they hunt you. A family must live in silence to avoid mysterious creatures that hunt by sound. Knowing that even the slightest whisper or footstep can bring death, Evelyn and Lee are determined to find a way to protect their children while desperately searching for a way to fight back."
        );
        public static final Movie SHINING = new Movie(
                "The Shining",
                COST,
                1980,
                136,
                Movie.Genres.Horror,
                "src\\Trailers\\TheShining.mp4",
                "Jack Torrance (Jack Nicholson) becomes winter caretaker at the isolated Overlook Hotel in Colorado, hoping to cure his writer's block." +
                        "He settles in along with his wife, Wendy (Shelley Duvall), and his son, Danny (Danny Lloyd), who is plagued by psychic premonitions." +
                        "As Jack's writing goes nowhere and Danny's visions become more disturbing, Jack discovers the hotel's dark secrets and begins to unravel into a homicidal maniac hell-bent on terrorizing his family."
        );
    }

    public class Animation {
        public static final Movie FATE = new Movie(
                "Fate/stay night",
                COST,
                2017,
                120,
                Movie.Genres.Animation,
                "src\\Trailers\\FateStayNight.mp4",
                "As in previous routes, the story focuses on a teenage mage named Shirou Emiya who takes part in a conflict known as the Holy Grail War to protect his city." +
                        "However, this time Shirou encounters not only other mages and Servant warriors, but also a mysterious shadow killing most of the participants."
        );
        public static final Movie SUZUME = new Movie(
                "Suzume",
                COST,
                2022,
                122,
                Movie.Genres.Animation,
                "src\\Trailers\\Suzume.mp4",
                "As the skies turn red and the planet trembles, Japan stands on the brink of disaster." +
                        "However, a determined teenager named Suzume sets out on a mission to save her country." +
                        "Able to see supernatural forces that others cannot, it's up to her to close the mysterious doors that are spreading chaos across the land." +
                        "A perilous journey awaits as the fate of Japan rests on her shoulders."
        );
        public static final Movie YOUR_NAME = new Movie(
                "Your Name",
                COST,
                2016,
                107,
                Movie.Genres.Animation,
                "src\\Trailers\\YourName.mp4",
                "Two teenagers share a profound, magical connection upon discovering they are swapping bodies." +
                        "Things manage to become even more complicated when the boy and girl decide to meet in person."
        );
    }
}
