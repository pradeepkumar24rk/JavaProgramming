import java.time.DayOfWeek;
import java.util.Arrays;

public class CountingSort {

    static int maximum(int arr[], int n) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
            max = arr[i] > max ? arr[i] : max;
        return max;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 5, 3, 2, 5, 5, 9, 1, 3 }, n = arr.length;
        int max = maximum(arr, n);
        int frequenceArr[] = new int[max];
        Arrays.fill(frequenceArr, 0);
        
        for (int i = 1; i <= n; i++)
            frequenceArr[arr[i]] += 1;
        for (int i = 2; i < n; i++)
            frequenceArr[i] = frequenceArr[i] + frequenceArr[i - 1];
        
        max=maximum(frequenceArr, n);
            
        int b[] = new int[max];
    
        
        int i=n;
        do {
            b[frequenceArr[arr[i]]]=arr[i];
            frequenceArr[i]-=1;
            --i;
        } while (i > 0);
        
        for(int k=1;k<=b.length;k++)
            System.out.println(b[k]);

    }
}
