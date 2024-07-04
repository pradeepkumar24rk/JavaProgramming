package Recursion;

import java.util.Arrays;

public class SelectionSort {
    static void sort(int arr[],int row,int col,int max) {
        if(row == 0)
            return;
        if(row>col) {
            if(arr[col]>arr[max]) {
                max = col;
            }
            sort(arr, row, col+1,max);
        } else{
            int temp = arr[col-1];
            arr[col-1] = arr[max];
            arr[max] = temp;
            sort(arr, row-1, 0,0);
        }
    }
   public static void main(String[] args) {
    int arr[] = {4, 1, 3, 9, 7 },row = arr.length-1,col=0,max = 0;
    sort(arr,row,col,max);
    System.out.println(Arrays.toString(arr));
   } 
}
