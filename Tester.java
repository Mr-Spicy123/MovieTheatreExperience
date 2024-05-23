public class Tester {
  public static void main(String[] args) {
    Food f = new Food("medium", "regular", 0);
    Food f2 = new Food("large", "regular", 2);
    Hotdog h = new Hotdog("small", "ketchup", 5);
    Food[] allFood = Food.getAllFood();
    for (Food element : allFood) {
      if (element != null) {
        System.out.println(element + "\n");
      }
    }
  }
}
