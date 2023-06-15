public class GroupOfPrimeNumber {
    public static boolean isprime(long r){
        if(r!=2 && r%2==0) return false;
        for(int i=2;i<Math.sqrt(r);i++){
            if(r%i==0)
                return false;
        }
        return true;
    }
    public static void main(String args[]) {
      long a=1513101918;
      int n=2;
    //   int d=(int)Math.pow(10,n);
    //   while(a>0){
    //       long r=a%d;
    //       if(isprime(r))
    //         System.out.println(r);
    //       a/=d;
    //   }
    String s=String.valueOf(a);
    int i=0;
        while(i!=s.length()){
            int r=Integer.parseInt(s.substring(i,i+n));
            if(isprime(r))
                System.out.println(r);
            i+=n;
        }
    }
}
