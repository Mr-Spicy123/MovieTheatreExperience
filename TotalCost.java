public class TotalCost {
  static int totalCostInd = 0;
  static double[] costs = new double[100];


  public static double getTotalCost() {
    double totalCost = 0;
    for (int i = 0; i < costs.length; i++) {
      if (costs[i] != 0) {
        totalCost += costs[i];
      }
    }
    return totalCost;
  }

  public static void addCost(double c) {
    costs[totalCostInd] = c;
    totalCostInd++;
  }

  public static void print() {
    for (double d : costs) {
      if (d != 0) {
        System.out.println(d);
      }
    }
    //space between prints
    System.out.println("");
  }

}
