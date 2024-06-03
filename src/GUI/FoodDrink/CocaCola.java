package GUI.FoodDrink;

public class CocaCola extends Drink {
  static double price = 3.00;

  public CocaCola(int si, boolean i, boolean st) {
    super(si, i, st);
  }

  public CocaCola() {
    this(0, false, false);
  }

}
