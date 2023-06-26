//Find the largest Sum of contiguous subarray 
//time complexity O(n)
package DynamicProgramming;
public class KadanesAlgorithm {
    static int algorithm(int arr[], int n){
        int max=Integer.MIN_VALUE,sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(max<sum)
                max=sum;
            if(sum<0)
                sum=0;
        }
        return max;
    }
    public static void main(String[] args) {
        int arr[] = { -2, -3, 4, -1, -2, 1, 5, -3 }, n = arr.length;
        System.out.println(algorithm(arr,n));
    }
}
