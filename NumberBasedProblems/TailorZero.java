package NumberBasedProblems;

public class TailorZero {

    static int findTrailingZeros(int n)
    {
        if (n < 0) // Negative Number Edge Case
            return -1;
 
        // Initialize result
        int count = 0;
 
        // Keep dividing n by powers
        // of 5 and update count
        for (int i = 5; n / i >= 1; i *= 5)
            count += n / i;
 
        return count;
    }
    
    public static void main(String[] args) {
        long n=201,sum=1,count=0;
        for(long i=2;i<=n;i++)
            sum*=i;
        System.out.println("Factorial = "+sum);
        while(sum!=0){
            long rem=sum%10;
            if(rem!=0)
                break;
            count++;
            sum/=10;
        }
        System.out.println("trailing zero count = "+count);
    }
}
 