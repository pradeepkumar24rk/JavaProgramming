package Recursion;

import java.util.Arrays;

public class BubbleSort {
    static void sort(int arr[],int row,int col) {
        if(row == 0)
            return;
        if(row>col) {
            if(arr[col]>arr[col+1]) {
                int temp = arr[col];
                arr[col] = arr[col+1];
                arr[col+1] = temp;
            }
            sort(arr, row, col+1);
        } else
            sort(arr, row-1, 0);
    }
   public static void main(String[] args) {
    int arr[] = {4, 1, 3, 9, 7 },row = arr.length-1,col=0;
    sort(arr,row,col);
    System.out.println(Arrays.toString(arr));
   } 
}
