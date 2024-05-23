import javax.swing.*;

public class ChickenFingers extends Food{

  public ChickenFingers(String si, String f, int sp, ImageIcon imSml, ImageIcon imMed, ImageIcon imLrg) {
    super(si, f, sp, imSml, imMed, imLrg);
    super.foodType = "chicken fingers";
  }
  public ChickenFingers(String si, String f, int sp) {
    super(si, f, sp);
    super.foodType = "chicken fingers";
  }

  public ChickenFingers() {
    super();
    super.foodType = "chicken fingers";
  }
}
