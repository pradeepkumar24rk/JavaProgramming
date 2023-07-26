package NumberBasedProblems;

public class TailorZero {
    public static void main(String[] args) {
        long n=201,sum=1,count=0;
        for(long i=2;i<=n;i++)
            sum*=i;
        System.out.println(sum);
        while(sum!=0){
            long rem=sum%10;
            if(rem!=0)
                break;
            count++;
            sum/=10;
        }
        System.out.println(count);
    }
}
 