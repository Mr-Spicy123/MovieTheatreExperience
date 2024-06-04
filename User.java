public class User {
  private static double balance = 50;

  public static double getBalance() {
    return balance;
  }

  public static void changeBalance(double d) {
    balance-=d;
  }
}
