package Recursion;

import java.util.ArrayList;

public class SubSequenceString {
    private static void subSequence(String str, String ans) {
        if(str.length() == 0) {
            System.out.println(ans);
            return;
        }
        subSequence(str.substring(1), ans+str.charAt(0));
        subSequence(str.substring(1), ans);
    }
    
    private static ArrayList<String> subSequenceArrayList(String str, String ans) {
        if(str.length() == 0) {
            // System.out.println(ans);
            ArrayList<String> list = new ArrayList<>();
            list.add(ans);
            return list;
        }
        ArrayList<String> left = subSequenceArrayList(str.substring(1), ans+str.charAt(0));
        ArrayList<String> right = subSequenceArrayList(str.substring(1), ans);
        left.addAll(right);
        return left;
    }
    
    
    
    public static void main(String[] args) {
        subSequence("abc", "");
        System.out.println(subSequenceArrayList("abc", ""));
    }
}
