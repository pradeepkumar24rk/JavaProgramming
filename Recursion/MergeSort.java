package Recursion;

import java.util.Arrays;

public class MergeSort {
    private static void sort(int[] arr, int i, int j) {
        if (j-i == 1)
            return;
        int mid = (i + j) / 2;
        sort(arr, i, mid);
        sort(arr, mid, j);

        merge(arr, i, mid, j);
    }

    private static void merge(int[] arr, int s, int mid, int e) {
        int ans[] = new int[e - s];

        int i = s, j = mid, k = 0;
        while (i < mid && j < e) {
            if (arr[i] < arr[j]) {
                ans[k] = arr[i];
                i++;
            } else {
                ans[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i < mid) {
            ans[k] = arr[i];
            i++;
            k++;
        }
        while (j < e) {
            ans[k] = arr[j];
            j++;
            k++;
        }
        
        for(int q=0;q<ans.length;q++){
            arr[s+q] = ans[q];
        }
        
    }

    public static void main(String[] args) {
        int arr[] = { 5, 6, 4, 2, 3, 1, 8 };
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
