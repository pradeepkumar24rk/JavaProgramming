package DynamicProgramming;

import java.util.*;

public class MinChange {
  static int minChangeBruteForce(int amount, int[] coins) {
    if (amount == 0)
      return 0;

    int minCoins = -1;
    for (int i = 0; i < coins.length; i++) {
      if (coins[i] <= amount) {
        int r = minChangeBruteForce(amount - coins[i], coins);
        if (r != -1) {
          int numCoin = r + 1;
          if (numCoin < minCoins || minCoins == -1) {
            minCoins = numCoin;
          }
        }
      }
    }
    return minCoins;
  }

  static int minChange(int amount, int[] coins, HashMap<Integer, Integer> memo) {
    if (amount == 0)
      return 0;

    if (memo.containsKey(amount))
      return memo.get(amount);

    int minCoins = -1;
    for (int i = 0; i < coins.length; i++) {
      if (coins[i] <= amount) {
        int r = minChange(amount - coins[i], coins, memo);
        if (r != -1) {
          int numCoin = r + 1;
          if (numCoin < minCoins || minCoins == -1) {
            minCoins = numCoin;
          }
        }
      }
    }
    memo.put(amount, minCoins);
    return minCoins;
  }

  public static void main(String[] args) {
    int[] coins = { 1, 2, 3 };
    int amount = 4;
    // System.out.println(minChangeBruteForce(amount,coins));
    HashMap<Integer, Integer> memo = new HashMap<>();
    System.out.println(minChange(amount, coins, memo));
  }
}

// Input: coins = [1,2,3], amount = 4
// Output: 2
// Explanation: The combinations are:
// (1,1,1,1), (1,1,2), (1,3), (2,2)
// The minimum coins needed is 2. (1,3) or (2,2)