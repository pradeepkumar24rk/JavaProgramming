package Recursion;

import java.util.*;

public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    private static void backtrack(List<String> list, String ans, int open, int close, int max) {
        if (ans.length() == max * 2) {
            list.add(ans);
            return;
        }
        if (open < max) {
            backtrack(list, ans + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(list, ans + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> ans = generateParenthesis(n);
        System.out.println(ans);
    }
}