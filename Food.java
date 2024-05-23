import javax.swing.*;

public class Food {
  //class variables
  static Food[] allFood = new Food[50];
  static int menuIndex = 0;
  final static double PRICE = 4.97;
  //can increase amount when a button is pressed
  static int amount = 0;
  static int totalFoodObj = 0;

  //instance variables
  String size;
  String flavour;
  int spiceLevel;
  int foodRemaining;
  String foodType;
  final int FOOD_ID;
  //ImageIcon instance variables
  ImageIcon imageSmall;
  ImageIcon imageMedium;
  ImageIcon imageLarge;

  public Food(String si, String f, int sp, ImageIcon imSml, ImageIcon imMed, ImageIcon imLrg) {
    //can print the toString of each element to display menu on GUI
    allFood[menuIndex] = this;
    menuIndex++;
    totalFoodObj++;
    FOOD_ID = totalFoodObj;
    //set instance variables to parameters
    imageSmall = imSml;
    imageMedium = imMed;
    imageLarge = imLrg;
    size = si;
    flavour = f;
    spiceLevel = sp;
    //100% of the food is remaining
    foodRemaining = 100;
    //objects from this class are labeled cas food
    foodType = "food";
  }
  public Food(String si, String f, int sp) {
    this(si, f, sp, null, null, null);
  }

  public Food() {
    this("NO INPUT", "NO INPUT", 0);
  }

  public static Food[] getAllFood() {
    return allFood;
  }
  public String toString() {
    return "ID: " + FOOD_ID + "\nFood type: " + foodType + "\nSize: " + size + "\nFlavour: " + flavour + "\nSpice level: " + spiceLevel + "\nFood remaining: " + foodRemaining;
  }

  public static double Cost(){
    return amount*PRICE;
  }

  public void Eat(){
    foodRemaining -= 10;
  }
}
