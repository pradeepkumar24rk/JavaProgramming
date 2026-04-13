package DynamicProgramming;

import java.util.HashMap;

public class ArraySumPossible {
  public static void main(String[] args) {
    int[] num = { 1, 2, 3 };
    int amount = 4;
    System.out.println("All possible sum: " + sumAllPossible(amount, new HashMap<>(), num, ""));
    System.out.println("Is Possible sum: " + isSumPossible(amount, new HashMap<>(), num));

    System.out.println("The minimal possible: "+MinPossibleLength(amount, new HashMap<>(), num, ""));
  }

  public static boolean sumAllPossible(int amount, HashMap<Integer, Boolean> mem, int[] num, String path) {
    if (amount == 0) {
      System.out.println(path);
      return true;
    }

    if (mem.containsKey(amount)) {
      System.out.println(path);
      return mem.get(amount);
    }

    boolean res = false;
    for (int i = 0; i < num.length; i++) {
      if (num[i] <= amount) {
        int subAmount = amount - num[i];
        boolean r = sumAllPossible(subAmount, mem, num, path + Integer.toString(num[i]));
        mem.put(subAmount, r);
        res = r || res;
      }
    }
    return res;
  }

  public static boolean isSumPossible(int amount, HashMap<Integer, Boolean> mem, int[] num) {
    if (amount == 0)
      return true;

    if (amount < 0) {
      return false;
    }

    if (mem.containsKey(amount)) {
      return mem.get(amount);
    }

    for (int i = 0; i < num.length; i++) {
      int subAmount = amount - num[i];
      if (isSumPossible(subAmount, mem, num)) {
        mem.put(subAmount, true);
        return true;
      }
    }
    mem.put(amount, false);
    return false;
  }

  public static int MinPossibleLength(int amount, HashMap<Integer, Boolean> mem, int[] num, String path) {
    if (amount == 0) {
      System.out.println(path);
      return path.length();
    }

    // if (mem.containsKey(amount)) {
    // System.out.println(path);
    // return mem.get(amount);
    // }

    int res = -1;
    for (int i = 0; i < num.length; i++) {
      if (num[i] <= amount) {
        int subAmount = amount - num[i];
        int r = MinPossibleLength(subAmount, mem, num, path + Integer.toString(num[i]));
        // mem.put(subAmount, r);
        res = res == -1 ? r : res < r ? res : r;
      }
    }
    return res;
  }
}
