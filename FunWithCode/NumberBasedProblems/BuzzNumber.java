//A number is said to be Buzz Number if it ends with 7 or is divisible by 7.
//Example: 1007 is a Buzz Number.


package NumberBasedProblems;

public class BuzzNumber {
    public static void main(String[] args) {
        int n=1007;
        if(n%10==7 || n%7==0)
            System.out.println("It is a Buzz Number");
        else
            System.out.println("It is not a Buzz Number");
    }
}
