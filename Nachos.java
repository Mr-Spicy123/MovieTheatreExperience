import javax.swing.*;

import java.util.Random;
public class Nachos extends Food {
  static Random rand = new Random();
  static double price = 8.00;
  static int coupon = rand.nextInt(0,2);

  public Nachos(String si, String f, int sp) {
    super(si, f, sp);
    super.foodType = "nachos";
  }

  public Nachos() {
    super();
    super.foodType = "nachos";
  }
  public static double getCost() {
    return price-coupon;
  }

}
