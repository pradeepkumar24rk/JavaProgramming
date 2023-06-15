import java.util.Scanner;

public class ChocolateVanilla {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n=sc.nextLong(),k=sc.nextLong();
        Long c= n%2==0 ? (n/2) : (n/2)+1;
        if(k<=c)
            System.out.println((k*2)-1);
        else
            System.out.println((k-c)*2);
        sc.close();
    }
}
