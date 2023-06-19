/**
 * QuickSort
 */
public class QuickSort {

    public static void quicksort(int first, int last, int a[]) {
        int i = first, pivot = first,
                j = last;

        while (i < j) {
            while (a[i] <= a[pivot])
                i++;
            while (a[j] > a[pivot])
                j--;
            if (i > j)
                // a[pivot] ^= a[j] ^=a[pivot] ^= a[j];
            {   
                int temp=a[pivot];
                a[pivot]=a[j];
                a[j]=temp;
            }
            else
                // a[i] ^= a[j] ^= a[i] ^= a[j];
                {   
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
       
        

    }

    public static void main(String[] args) {
        int a[] = { 7, 6, 10, 5, 9,2, 1, 15, 7 };
        quicksort(0, a.length - 1, a);

        for (int i : a) {
            System.out.print(i+" ");
        }
    }
}