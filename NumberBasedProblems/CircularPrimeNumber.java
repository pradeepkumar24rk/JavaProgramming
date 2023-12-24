package NumberBasedProblems;

public class CircularPrimeNumber {
    static int count=0;
    public static void isprime(int num){
        int flag=0;
        for(int i=2;i<num/2;i++){
            if(num%i==0)
            {
                flag=1;
                break;
            }
        }
        if(flag==0)
            count++;
    }
    public static void main(String[] args) {
        int num=1193;
        String s=num+"";
        char c[]=s.toCharArray();
        int n=s.length();
        isprime(num);
        if(count==1){
            
            for(int i=n-1,j=i-1;i>0;i--,j--){
                char temp=c[i];
                c[i]=c[j];
                c[j]=temp;
                String r=new String(c);
                isprime(Integer.parseInt(r));
            }
        } 
    }
}
