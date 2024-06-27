//time complexity O(log n)


package SearchingAlgorithm;

public class BinarySearch {

    static int[] sort(int arr[],int n){
        for(int i=1;i<n;i++){
            int temp=arr[i],k=i-1;
            while(k>=0 && temp<arr[k]){
                arr[k+1]=arr[k];
                k--;
            }
            arr[k+1]=temp;
        }
        return arr;
        
    }
    static String binarySearch(int arr[],int n,int t){
        int a[]=sort(arr,n);
        int left=0,right=n-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(a[mid]>t)
                right=mid-1;
            else if(a[mid]<t)
                left=mid+1;
            else if(a[mid]==t)
                return "founded";
        }
        return "Not Founded";
    }
    
    static String recursiveBinaryString(int arr[], int target, int start, int end) {
        if(start>end) {
            return "Not founded";
        }
        int mid = start +(end-start)/2;
        if(arr[mid] == target)
            return "founded";
        if(arr[mid] < target)
            return recursiveBinaryString(arr, target, mid+1, end);
        
        return recursiveBinaryString(arr, target, start, mid-1);
    }
    public static void main(String[] args) {
        int a[]={22,66,4,7,3,6,52,79,42},n=a.length,target=52;
        System.out.println(binarySearch(a,n,target));
        System.out.println(recursiveBinaryString(a,target,0,n-1));
        
    }
}
