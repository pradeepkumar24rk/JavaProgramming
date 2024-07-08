package Recursion;

import java.util.ArrayList;

public class Permutations {

    private static void permutation(String str,String ans) {
        if(str.length() == 0) {
            System.out.println(ans);
            return;
        }
        char ch = str.charAt(0);
        for(int i = 0;i<=ans.length();i++) {
            String f = ans.substring(0, i);
            String e = ans.substring(i,ans.length());
            permutation(str.substring(1), f+ch+e);
        }
    }
    
    private static ArrayList<String> permutationArrayList(String str,String ans) {
        if(str.length() == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(ans);
            return list;
        }
        char ch = str.charAt(0);
        ArrayList<String> arr = new ArrayList<>();
        for(int i = 0;i<=ans.length();i++) {
            String f = ans.substring(0, i);
            String e = ans.substring(i,ans.length());
           
           arr.addAll(permutationArrayList(str.substring(1), f+ch+e));
        }
        return arr;
    }
    
    private static int permutationCount(String str,String ans) {
        if(str.length() == 0) {
            // System.out.println(ans);
            return 1;
        }
        int count = 0;
        char ch = str.charAt(0);
        for(int i = 0;i<=ans.length();i++) {
            String f = ans.substring(0, i);
            String e = ans.substring(i,ans.length());
            count+=permutationCount(str.substring(1), f+ch+e);
        }
        return count;
    }
    
    public static void main(String[] args) {
        String str = "abc";
        permutation(str,"");
        System.out.println(permutationArrayList(str,""));
        System.out.println(permutationCount("abcd",""));
        
    }
}
