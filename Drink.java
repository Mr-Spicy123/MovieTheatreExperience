import javax.swing.*;
import java.util.Random;

public class Drink {
  static Random rand = new Random();
  private static final double price = 3.00; // the cost of the drink
  private static double cost; //total cost to the user
  private int size; // 3 different sizes for the drinks 1, 2, or 3
  private boolean ice; // lets the user choose the percentage of ice
  private boolean straw; // a boolean to allow the user to choose between a plastic or paper straw
  static boolean refill; // allows the user to refill their drink, default is false and if its true then the refill button should appear and then disappear once they click on the button
  static int drinkAmount; // the number of items of a individual item is being bought (eg. 3 burgers or 5 drinks etc.)
  static int drinkRemaining; // the amount of liquid remaining default should be a 100
  static int couponGen = rand.nextInt(0, 11);// generates a random number for the coupon
  static boolean coupon = false; // if true they get a discount if false then nothing happens
  static double discount = 0.85; // the cost after the amount of items, size, price and discount is calculated


  public Drink(int si, boolean i, boolean st) {
    size = si;
    ice = i;
    straw = st;
  }

  public Drink() {
    this(0, false, false);
  }

  public static void applyCoupon() { // method to give a 10% discount if they get a coupon
    if (coupon) {
      if (couponGen == 3) {
        coupon = true;
      }
    }
  }


  public double getCost() { // method to calculate the cost of a drink WE WILL NEED ANOTHER METHOD FOR THE COST OF DIFFERENT TYPES OF DRINKS!
    if (coupon) {
      cost = (price + size) * discount;
    } else {
      cost = price + size;
    }
    return cost;
  }

  public static void consume() { // every time the user clicks on the drink button the amount of drink they have remaining goes down can't be less the 0
    if (drinkRemaining >= 10) {
      drinkRemaining -= 10;
    }
  }

  public void setdrinkSize(int s) {
    size = s;
  }

  public void setdrinkIce(boolean i) {
    ice = i;
  }

  public void setdrinkStraw(boolean s) {
    straw = s;
  }

  public int getdrinkSize() {
    return size;
  }

  public boolean getdrinkIce() {
    return ice;
  }

  public boolean getdrinkStraw() {
    return straw;
  }

  public static void drinkIncrease() { // method to increase the amount of drinks being bought when clicking a button
    if (drinkAmount < 10) {
      drinkAmount++;
    }
  }

  public static void drinkDecrease() {  // method to decrease the amount of drinks being bought when clicking a button
    if (drinkAmount > 0) {
      drinkAmount--;
    }
  }
  // public static void refill(drinkRemaining){ // method to let the user refill their drink, button should only appear once the drinkRemaining value is 0 and disapper once the user clicks on the button
  //  if (drinkRemaining == 0){        //do this if we get our MVP working
  //     refill = true;
  //    if (refill == true){
  //    set.drinkRemaining = 100;
  //   }
  //  }
  //  else refill = false;
  // }

}

