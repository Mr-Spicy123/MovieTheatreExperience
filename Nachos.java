import javax.swing.*;

public class Nachos extends Food{

  public Nachos(String si, String f, int sp, ImageIcon imSml, ImageIcon imMed, ImageIcon imLrg) {
    super(si, f, sp, imSml, imMed, imLrg);
    super.foodType = "nachos";
  }
  public Nachos(String si, String f, int sp) {
    super(si, f, sp);
    super.foodType = "nachos";
  }

  public Nachos() {
    super();
    super.foodType = "nachos";
  }
}
