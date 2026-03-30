package DynamicProgramming;

import java.util.HashMap;

public class Tribnocci {
    public static void main(String[] args) {
        int n = 4;
        HashMap<Integer, Integer> memo = new HashMap<>();
        int result = tribonnci(n, memo);
        System.out.println("The " + n + "th Tribonacci number is: " + result);
    }

    public static int tribonnci(int index, HashMap<Integer, Integer> mem) {
        if (index <= 1) {
            return 0;
        }
        
        if (index == 2) {
            return 1;
        }

        if (mem.containsKey(index)) {
            return mem.get(index);
        }

        int val = tribonnci(index - 1, mem) + tribonnci(index - 2, mem) + tribonnci(index - 3, mem);
        mem.put(index, val);
        return val;
    }
}
