import javax.swing.*;

public class Hotdog extends Food{


  public Hotdog(String si, String f, int sp, ImageIcon imSml, ImageIcon imMed, ImageIcon imLrg) {
    super(si, f, sp, imSml, imMed, imLrg);
    super.foodType = "hotdog";
  }
  public Hotdog(String si, String f, int sp) {
    super(si, f, sp);
    super.foodType = "hotdog";
  }

  public Hotdog() {
    super();
    super.foodType = "hotdog";
  }
}
