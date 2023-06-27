public class CountingSubsequence {
    public static void main(String[] args) {
        
        int a[]={1,2,3,4} ,n=a.length;
        System.out.println((1<<n)-1);  //total subsequence
        int target=4,i=0;
        while(target!=0){
            if((target&1)==1)
                System.out.print(a[i]+" ");
            i++;
            target>>=1; 
        }
    }
}
