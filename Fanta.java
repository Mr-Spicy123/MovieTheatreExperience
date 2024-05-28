import javax.swing.*;

public class Fanta extends Drink {
  //to the person handling the photos:
  //put path to image file in parameters
  static ImageIcon imageSmall = new ImageIcon();
  static ImageIcon imageMedium = new ImageIcon();
  static ImageIcon imageLarge = new ImageIcon();


  public Fanta(int si, boolean i, boolean st) {
    super(si, i, st);
    super.setImageSmall(imageSmall);
    super.setImageMedium(imageMedium);
    super.setImageLarge(imageLarge);
  }

  public Fanta() {
    this(0, false, false);
  }
}
