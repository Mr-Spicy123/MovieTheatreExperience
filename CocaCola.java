import javax.swing.*;
import java.util.Random;
public class CocaCola extends Drink {
  static Random rand = new Random();
  static double price = 3.00;
  static int coupon = rand.nextInt(0,2);
  public CocaCola(int si, boolean i, boolean st) {
    super(si, i, st);
  }

  public CocaCola() {
    this(0, false, false);
  }

  /*public static double getCost() {
    return price-coupon;
  }*/
}
