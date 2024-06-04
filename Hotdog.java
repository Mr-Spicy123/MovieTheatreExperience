import javax.swing.*;

import java.util.Random;
public class Hotdog extends Food{
  static Random rand = new Random();
  static double price = 6.00;
  static int coupon = rand.nextInt(0,2);
  public Hotdog(String si, String f, int sp) {
    super(si, f, sp);
    super.foodType = "hotdog";
  }

  public Hotdog() {
    super();
    super.foodType = "hotdog";
  }

  public static double getCost() {
    return price-coupon;
  }
}
