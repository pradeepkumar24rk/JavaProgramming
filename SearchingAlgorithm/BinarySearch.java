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
    public static void main(String[] args) {
        int a[]={22,66,4,7,3,6,52,79,42},n=a.length,target=51;
        System.out.println(binarySearch(a,n,target));
        
    }
}
