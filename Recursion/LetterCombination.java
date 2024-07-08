package Recursion;

public class LetterCombination {

    private static void pad(String str,String ans) {
        if(str.length()==0) {
            System.out.println(ans);
            return;
        }
        
        int digit = str.charAt(0) - '0';
        for(int i = (digit-1)*3;i<(digit*3);i++) {
            char ch = (char) ('a'+i);
            pad(str.substring(1), ans+ch);
        }
    }
    public static void main(String[] args) {
        pad("12", "");
    }
}
