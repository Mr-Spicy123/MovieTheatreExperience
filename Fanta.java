import java.util.Random;
public class Fanta extends Drink {
  static Random rand = new Random();
  static double price = 1.00;
  static int coupon = rand.nextInt(0,2);

  public Fanta(int si, boolean i, boolean st) {
    super(si, i, st);
  }

  public Fanta() {
    this(0, false, false);
  }

  public static double getCost() {
    return price-coupon;
  }

}
