package ArrayBasedProblems;
public class SubSequenceInArray {
    public static void main(String[] args) {
        int a[]={5,3,1,6,2},sumOfSquence=6,n=a.length,total=(1<<n)-1,count=0;
        System.out.println("Total number of subSequence :"+total);
        
        for(int i=1;i<=total;i++){
            int target=i,sum=0,j=0;
            String b="";
            while(target!=0){
                if((target&1)==1){
                    sum+=a[j];
                    b+=String.valueOf(a[j])+" ";
                }
                j++;
                target>>=1;
            }
            if(sum==sumOfSquence){
                System.out.println(b);
                count++;
            }
        }
        System.out.println("Number of Subsequence equal to sumOfSquence Given :"+count);
    }
}
