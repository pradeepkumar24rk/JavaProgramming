import java.util.*;

public class PascelTriangle {
    static int[][] pascelTriangle(int n) {
        int arr[][] = new int[n - 1][];
        System.out.println("1");
        for (int i = 0; i < n - 1; i++) {
            arr[i] = new int[i + 2];
            arr[i][0] = 1;
            arr[i][i + 1] = 1;
            if (i >= 1) {
                for (int j = 1; j < arr[i].length - 1; j++) {
                    arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter of Number :");
        int n = sc.nextInt();
        int a[][] = pascelTriangle(n);
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
        sc.close();
    }
}

// input
// 6
// output
// [1]
// [1,1]
// [1,2,1]
// [1,3,3,1]
// [1,4,6,4,1]
// [1,5,10,10,5,1]