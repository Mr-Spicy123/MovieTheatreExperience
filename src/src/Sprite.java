package src;

public class Sprite extends Drink {
  static double price = 3.00;


  public Sprite(int si, boolean i, boolean st) {
    super(si, i, st);
  }

  public Sprite() {
    this(0, false, false);
  }
}
