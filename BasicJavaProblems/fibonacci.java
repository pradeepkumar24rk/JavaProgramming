package BasicJavaProblems;

public class fibonacci {

    static void iterativeFib(int n){
        int f=2,n1=0,n2=1;
        System.out.print(n1+" "+n2+" ");
        while(f<n){
            int n3=n1+n2;
            n1=n2;
            n2=n3;
            f++;
            System.out.print(n2+" ");
        }
        System.out.println();
    }
    
    static int recuriveFib(int n){
        if(n<=1)
            return n;
        return recuriveFib(n-1)+recuriveFib(n-2);
    }
    public static void main(String[] args) {
        int n=10;
        System.out.println("Iterative Fibonacci :");
        iterativeFib(n);
        System.out.println("Recurive Fibonacci :");
        for(int i=0;i<n;i++)
        System.out.print(recuriveFib(i)+" ");
    }
}
