public class MovieTest {
    public static void main(String[] args) {
        Movie movie1 = new Movie("Lego Movie 1", 40f, 2014, 100f, Movie.Genres.Action);
        Movie movie2 = new Movie("Lego Movie 2", 45f, 2019, 107f, Movie.Genres.Action);
        System.out.println(movie1.equals(movie2));
    }
}
