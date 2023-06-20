/**
 * QuickSort
 */
public class QuickSort {

    public static void quicksort(int first, int last, int a[]) {
        if (first < last) {

            int i = first, pivot = first,
                    j = last;

            while (i < j) {
                while (a[i] <= a[pivot] && i < last)
                    i++;
                while (a[j] > a[pivot])
                    j--;
                if (i < j)
                // a[i] ^= a[j] ^= a[i] ^= a[j];
                {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }

            int temp = a[pivot];
            a[pivot] = a[j];
            a[j] = temp;
            quicksort(first, j - 1, a);
            quicksort(j + 1, last, a);
        }

    }

    public static void main(String[] args) {
        int a[] = { 7, 6, 10, 5, 9, 2, 1, 15, 7 };
        quicksort(0, a.length - 1, a);

        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}

//           BestCase averageCase worstCase
// quicksort   nlogn       nlogn     n^2 ----> it use partitioning method, it is less time
// complexity compare to others sorting alogrithm