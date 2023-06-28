import java.util.*;

public class flames {
    public static void main(String[] args) {
      // System.out.println("Hello, World!");
      Scanner sc=new Scanner(System.in);
      StringBuffer s=new StringBuffer("flames");
      StringBuffer s1=new StringBuffer("skyblue");
      StringBuffer s2=new StringBuffer("pradeepkumar");
      
      int n1=s1.length();
      int n2=s2.length();
      
      // System.out.println("removed length before\n"+n1+" "+n2);
      for(int i=0;i<n1;i++){
        for(int j=0;j<n2;j++){
          if(s1.charAt(i)==s2.charAt(j))
          {
            
            // System.out.println("same character\n"+s1.charAt(i)+" "+ s2.charAt(j));
            s1.delete(i,i+1);
            s2.delete(j,j+1);
            n1--;
            n2--;
            i--;
            j--;
           break;
          }
        }
      }
      // System.out.println("removed length after\n"+s1.length()+" "+s2.length());
      int n=s1.length()+s2.length();
      // System.out.println("total="+n);
      
      int var=0;
      for(int i=1;i<=5;i++){
        int k=var;
        // System.out.println("next: "+k);
        int j=1;
        int len=s.length();
        while(j<=n){
          var=k%len;
          // System.out.println(var);
          k++;
          j++;
        }
        // System.out.println("delection value: "+var);
        s.delete(var,var+1);
      }
    //   System.out.println(s);
      
     
      switch(s.toString()){
        case "f":
          System.out.print("Friend");
          break;
        case "l":
          System.out.print("Lover");
          break;
        case "a":
          System.out.print("Affection");
          break;
        case "m":
          System.out.println("Marriage");
          break;
        case "e":
          System.out.println("Enemy");
          break;
        case "s":
          System.out.println("Sister");
          break;
        default:
          System.out.print("Invalid life");
          
      }
      
      sc.close();;
  }
}