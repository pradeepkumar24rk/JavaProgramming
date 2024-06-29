package Recursion;

/**
 * Palindrome
 */
public class Palindrome {
    static int rev2(int n, int size) {
        if(n/10==0){
            return n;
        }
        // System.out.println(size);
        return ((n%10)*(int)Math.pow(10, size-1)) + rev2(n/10, size-1);
    }
    
    static boolean isPalindrome(int n,int size) {
        System.out.println(rev2(n, size));
        return rev2(n, size)==n;
    }
    public static void main(String[] args) {
        int n = 121, size = (int)Math.log10(n)+1;
        System.out.println(isPalindrome(n, size));
        
    }  
}