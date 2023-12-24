package Pattern.StarPattern;
import java.util.Scanner;
public class patternM {
    public static void main(String arg[]){
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       for(int i=0;i<n;i++){
           for(int j=0;j<n;j++)
           {
               if((j==0) ||(j==n-1)||(i<=n/2 && j==(n-1)-i) || (i<n/2 && i==j))
               System.out.print("* ");
              //  else if(i==n-1 && j==n-1)
              //  System.out.println("*");
               else
               System.out.print("  ");
            }
            System.out.println();
        }
        sc.close();
    }
}


// input :
// 5                should be a old number

// output :

// *       * 
// * *   * * 
// *   *   * 
// *       * 
// *       * 