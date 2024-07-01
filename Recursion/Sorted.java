package Recursion;

public class Sorted {

    static boolean isSorted(int[] arr, int n, int first, int second) {       //optimized
        if(n<0)
            return true;
        if(arr[first]>arr[second])
            return false;
        return isSorted(arr, n-1, first+1, second+1);
    }
    
    static boolean issorted(int[] arr,int index) {
        if(index==arr.length-1)
            return true;
        return arr[index]<=arr[index+1] && issorted(arr, index+1);
    }
    public static void main(String[] args) {
        int arr[] = {2,6,8,8}, n = arr.length;
        System.out.println(isSorted(arr,n-2,0,1));
        System.out.println(issorted(arr, 0));
    }
}
 