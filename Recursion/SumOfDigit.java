package Recursion;

public class SumOfDigit {
    static int sum(int n) {
        if(n/10 == 0){
            return n;
        }
        return n%10+sum(n/10);
    }
    static int mul(int n) {
        if(n/10 == 0){
            return n;
        }
        return n%10*mul(n/10);
    }
    public static void main(String[] args) {
        System.out.println(sum(55));
        System.out.println(mul(55));
    }
}
