package Recursion;

public class SkipLetter {

    private static String skip(String str, String target, int index) {
        String s = "";
        if (index == str.length())
            return s;
        if (target.equals(str.charAt(index) + ""))
            s = "" + skip(str, target, index + 1);
        else
            s = str.charAt(index) + skip(str, target, index + 1);
        return s;
    }

    private static String skip(String str, String target) {
        String s = "";
        if (str.length() == 0)
            return s;
        if (target.equals(str.charAt(0) + ""))
            s = "" + skip(str.substring(1), target);
        else
            s = str.charAt(0) + skip(str.substring(1), target);
        return s;
    }

    private static void skip(String str, String target, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        if (target.equals(str.charAt(0) + ""))
            skip(str.substring(1), target, ans);
        else
            skip(str.substring(1), target, ans + str.charAt(0));

    }

    private static String skip(String str) {
        if (str.length() == 0) {
            return "";
        }
        if (str.charAt(0) == 'a')
            return skip(str.substring(1));
        else
            return str.charAt(0) + skip(str.substring(1));
    }

    public static void main(String[] args) {
        System.out.println(skip("baccad", "a", 0));
        System.out.println(skip("baccad", "a"));
        skip("baccadah", "a", "");
        System.out.println(skip("baccadadeda"));
    }
}
