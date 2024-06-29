package Recursion;

public class ReverseNumber {
    static int sum =0;
    static void rev(int n) {
        if(n/10==0){
            sum+=n%10;
            return;
        }
        sum=(sum+(n%10))*10;
        // System.out.println(sum);
        rev(n/10);
    }
    
    static int rev2(int n, int size) {
        if(n/10==0){
            return n;
        }
        // System.out.println(size);
        return ((n%10)*(int)Math.pow(10, size-1)) + rev2(n/10, size-1);
    }
    public static void main(String[] args) {
        int n = 121;
        rev(n);
        System.out.println(sum);
        System.out.println(rev2(n,(int)Math.log10(n)+1));
        
    }
}
