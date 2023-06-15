import java.util.Scanner;

public class primeNumber {

    public static boolean isprime(int n){
        // if(n==0 || n==1)
        //     return false;
        // if(n==2)
        //     return true;
        // for(int i=2;i<n/2;i++){
        //     if(n%i==0)
        //         return false;
        // }
        // return true;
        
        if(n!=2 && n%2==0)
            return false;
        for(int i=2;i<=Math.sqrt(n);i++){      // algorithm
            if(n%i==0)
                return false;
        }
        
        return true;  
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(isprime(n))
            System.out.println("Prime number");
        else 
            System.out.println("not a prime number");
        sc.close();
    }
}
