import java.util.Arrays;
import java.util.Scanner;

public class CountingSort {

    static int maximum(int arr[], int n) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
            max = arr[i] > max ? arr[i] : max;
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 10;
        // int arr[] = new int[n];

        int arr[] = { 2, 5, 3, 4, 5, 5, 6, 9, 3, 1 };

        int max = maximum(arr, n);
        int frequenceArr[] = new int[max + 1];
        Arrays.fill(frequenceArr, 0);

        for (int i = 0; i < n; i++)
            frequenceArr[arr[i]] += 1;

        for (int i = 1; i <= max; i++)
            frequenceArr[i] = frequenceArr[i] + frequenceArr[i - 1];

        max = maximum(frequenceArr, max + 1);

        int b[] = new int[max + 1];

        for (int i = n - 1; i >= 0; i--) {

            b[frequenceArr[arr[i]]] = arr[i];
            frequenceArr[i] -= 1;
        }

        for (int k = 0; k <= max; k++)
            if (b[k] > 0)
                System.out.print(" " + b[k] + " ");

        sc.close();

    }
}
