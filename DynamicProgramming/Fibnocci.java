package DynamicProgramming;

import java.util.*;

public class Fibnocci {
    public static void main(String[] args) {
        int n = 10;
        HashMap<Integer, Integer> memo = new HashMap<>();
        int result = fib(n, memo);
        System.out.println("The " + n + "th Fibonacci number is: " + result);
    }

    public static int fib(int n, HashMap<Integer, Integer> memo) {
        if (n <= 1)
            return n;

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int val = fib(n - 1, memo) + fib(n - 2, memo);
        memo.put(n, val);

        return val;
    }
}