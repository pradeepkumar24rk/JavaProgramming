public class BubbleSort {
    public static void main(String[] args) {
        int arr[]={4,1,3,9,7};
        int n=arr.length;
        for(int i=0;i<n;i++){
            int k=n;
            for(int j=0;j<k-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            k--;
            
        }
        for(int i=0;i<n;i++)
            System.out.println(arr[i]);
        
    }
}
