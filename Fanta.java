import javax.swing.*;

public class Fanta extends Drink {
  static double price = 1.00;

  public Fanta(int si, boolean i, boolean st) {
    super(si, i, st);
  }

  public Fanta() {
    this(0, false, false);
  }
}
