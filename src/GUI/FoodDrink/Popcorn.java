package GUI.FoodDrink;

public class Popcorn extends Food {
  static double price = 6.00;

  public Popcorn(String si, String f, int sp) {
    super(si, f, sp);
    super.foodType = "popcorn";
  }

  public Popcorn() {
    super();
    super.foodType = "popcorn";
  }
}
