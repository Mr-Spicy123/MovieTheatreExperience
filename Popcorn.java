import javax.swing.*;
import java.util.Random;

public class Popcorn extends Food {
  static Random rand = new Random();
  static double price = 6.00;
  static int coupon = rand.nextInt(0,2);
  public Popcorn(String si, String f, int sp) {
    super(si, f, sp);
    super.foodType = "popcorn";
  }

  public Popcorn() {
    super();
    super.foodType = "popcorn";
  }

  public static double getCost() {
    return price-coupon;
  }
}
