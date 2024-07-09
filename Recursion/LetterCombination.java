package Recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {

    private static void pad(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        int digit = str.charAt(0) - '0';
        for (int i = (digit - 1) * 3; i < (digit * 3); i++) {
            char ch = (char) ('a' + i);
            pad(str.substring(1), ans + ch);
        }
    }

    static List<String> padleetcode(String str, String ans) {

        if (str.length() == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(ans);
            return list;
        }
        int digit = str.charAt(0) - '0';
        ArrayList<String> mainlist = new ArrayList<>();
        int s = (digit - 2) * 3, e = ((digit - 1) * 3);
        if (digit == 7)
            e += 1;
        else if (digit == 8) {
            s += 1;
            e += 1;
        } else if (digit == 9) {
            s += 1;
            e += 2;
        }
        for (int i = s; i < e; i++) {
            char ch = (char) ('a' + i);
            mainlist.addAll(padleetcode(str.substring(1), ans + ch));
        }
        return mainlist;
    }

    public static void main(String[] args) {
        pad("18", ""); // 1-8 (9-yz)
        System.out.println(padleetcode("29", "")); // 2-9 (7 - pqrs, 8 - tuv, 9 - wxyz)
    }
}
