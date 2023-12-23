package Pattern;
public class pattern3
{
    public static void main(String[]args){
        int n=7;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=i;j++)
                System.out.print(" ");
            for(int j=i;j<=n;j++)
                System.out.print(j+" ");
            
            System.out.println();
        }
         
    }
}

// output
//  1 2 3 4 5 6 7 
//   2 3 4 5 6 7
//    3 4 5 6 7
//     4 5 6 7
//      5 6 7
//       6 7
//        7