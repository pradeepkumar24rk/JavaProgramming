package BasicJavaProblems;

public class PrimeNumRange {

    static int count(int input1,int input2){
        int count=0;
        for(int i=input1;i<=input2;i++){
            int flag=0;
            for(int j=2;j<=i/2;j++)
                if(i%j==0)
                {
                    flag=1;
                    break;
                }
            
            if(flag==0){
                System.out.println(i);
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println("Number of Prime Numbers for the given range :"+ count(2,20) );
    }
}
