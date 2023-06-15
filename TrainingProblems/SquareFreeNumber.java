import java.util.Scanner;

public class SquareFreeNumber {
    public static int sfn(int n){
        int count=0;
        for(int i=2;i<=n;i++){
            if(n%i==0){
                if(sqr(i)){
                    System.out.println("crt"+i);
                    count++;
                }
            }
            
        }
        return count;
    }
    static boolean sqr(int val){
        int sq=(int)Math.sqrt(val);
        boolean flag=true;
        if((sq*sq)!=val){
            for(int i=2;i<=val;i++){
                if(val%i==0){
                    int sqi=(int)Math.sqrt(i);
                    if((sqi*sqi)==i){
                        flag=false;
                        break;
                    }
                }
               
            }
        } else flag=false;
        return flag;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(sfn(n));
        sc.close();
    }
}
