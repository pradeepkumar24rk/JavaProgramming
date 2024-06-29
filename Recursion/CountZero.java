package Recursion;

public class CountZero {

    static int countzero(int n, int count) {
        if(n==0)
            return count;
        if(n%10!=0)
            return countzero(n/10, count);
        return countzero(n/10, count+1);
    }
    public static void main(String[] args) {
        System.out.println(countzero(302008, 0));
    }
}
