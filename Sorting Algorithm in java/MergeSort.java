import java.util.Arrays;

public class MergeSort {
    private static int[] sort(int[] arr) {
        if(arr.length == 1)
            return arr;
        int mid = arr.length/2;
        int left[] = sort(Arrays.copyOfRange(arr, 0, mid));
        int right[] = sort(Arrays.copyOfRange(arr, mid, arr.length));
        
        return merge(left,right);
    }
    
    private static int[] merge(int[] left, int[] right) {
        int ans[] = new int[left.length+right.length];
        
        int i =0,j=0,k=0;
        while(i<left.length && j<right.length) {
            if(left[i]<right[j]){
                ans[k]=left[i];
                i++;
            } else {
                ans[k] = right[j];
                j++;
            }
            k++;
        }
        
        while(i<left.length) {
            ans[k] = left[i];
            i++;
            k++;
        }
        while(j<right.length) {
            ans[k] = right[j];
            j++;
            k++;
        }
        
        return ans;
    }


    public static void main(String[] args) {
        int arr[] = {5,6,4,2,3,1,8};
        arr = sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
