package src;

public class Nachos extends Food {
  static double price = 8.00;

  public Nachos(String si, String f, int sp) {
    super(si, f, sp);
    super.foodType = "nachos";
  }

  public Nachos() {
    super();
    super.foodType = "nachos";
  }
}
