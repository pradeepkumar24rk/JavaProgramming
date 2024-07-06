package Recursion;

public class SkipWord {

    private static String skip(String str) {
        if (str.length() == 0)
            return "";
        if (str.startsWith("apple"))
            return skip(str.substring(5));
        return str.charAt(0) + skip(str.substring(1));
    }
    
    private static String skipAppNotApple(String str) {
        if (str.length() == 0)
            return "";
        if (str.startsWith("app") && !str.startsWith("apple"))
            return skipAppNotApple(str.substring(3));
        return str.charAt(0) + skipAppNotApple(str.substring(1));
    }

    public static void main(String[] args) {
        System.out.println(skip("aaerefapplesdfe"));
        System.out.println(skipAppNotApple("apprefapplesdfe"));
    }
}
