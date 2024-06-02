package src;

public class Hotdog extends Food{
  static double price = 6.00;

  public Hotdog(String si, String f, int sp) {
    super(si, f, sp);
    super.foodType = "hotdog";
  }

  public Hotdog() {
    super();
    super.foodType = "hotdog";
  }
}
