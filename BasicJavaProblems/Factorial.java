package BasicJavaProblems;

public class Factorial {

    static int withMultOperator(int n) {

        System.out.println("With using Multiplication operator");
        int sum = 1;
        for (int i = 2; i <= n; i++)
            sum *= i;
        return sum;
    }

    static int withOutMultOperator(int n) {
        System.out.println("Without using Multiplication operator");
        int temp = n;
        for (int i = n - 1; i > 0; i--) {
            int sum = 0;
            for (int j = 0; j < i; j++)
                sum += temp;
            // System.out.println(sum+" "+i);
            temp = sum;
        }
        return temp;

    }
    
    static int recurivefact(int n){
        if(n==1)
        return 1;
        return n*recurivefact(n-1);
    }
    
    public static void main(String[] args) {
        System.out.println(withMultOperator(5));
        System.out.println(withOutMultOperator(5));
        System.out.println("Recurive operation");
        System.out.println(recurivefact(5));
    }
}
