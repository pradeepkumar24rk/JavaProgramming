public class KaprekarNumber {
    static int square(int n)
    {
        int res=0;
        for(int i=0;i<n;i++)
            res+=n;
        return res;
    }
    public static void main(String args[]) {
      int n=297;
      int sq=square(n);
      String s=String.valueOf(sq);
     
      int sum=0,sn=s.length();
      String l="",r="";
      for(int i=0;i<sn;i++){
          if(i<(sn/2))
            l+=s.charAt(i);
        // System.out.println(l);
         if(i>=sn/2)
            r+=s.charAt(i);
      }
        sum=Integer.parseInt(r)+Integer.parseInt(l);
        // System.out.println(sum);
      
      if(sum==n)
        System.out.println("True");
    else
        System.out.println("False");
    }
}



// input

// 45                        45^2=2025   ==>20+25=45

// output

// True