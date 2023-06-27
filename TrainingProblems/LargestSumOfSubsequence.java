public class LargestSumOfSubsequence {
    public static void main(String[] args) {
        int a[]={1,2,3,4,5},n=5,count=(1<<n)-1;
        int max=Integer.MIN_VALUE;
        for(int i=1;i<=count;i++){
            int target=i,sum=0,j=0;
            while(target!=0){
                if((target&1)==1){
                    sum+=a[j];
                    System.out.print(a[j]+" ");
                }
                j++;
                target>>=1;
            }
            System.out.println();
            System.out.println("sum of array :"+sum);
            if(max<sum)
                max=sum;
        }
        System.out.println("largest Sum Of Subsequence :"+max);
    }
}
