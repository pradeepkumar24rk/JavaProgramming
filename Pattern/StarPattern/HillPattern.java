package Pattern.StarPattern;

public class HillPattern {

    public static void way1(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
                
    public static void way2(int n) {
        for(int i = 1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(j<=(n-i))
                System.out.print(" ");
                else
                System.out.print("* ");
            }
            System.out.println();
        }
    }
                
    public static void way3(int n) {
            for(int i = 1 ;i<=n;i++) {
                for (int j = i; j < n; j++) {
                    System.out.print("  ");
                }
                for (int j = 1; j < i; j++) {
                    System.out.print("* ");
                }
                for (int j = 1; j <= i; j++) {
                    System.out.print("* ");
                }
                System.out.println();
            }
    }
    
    public static void main(String[] args) {
        way3(5);
    }
}


// Output
//         * 
//       * * *
//     * * * * *
//   * * * * * * *
// * * * * * * * * *
