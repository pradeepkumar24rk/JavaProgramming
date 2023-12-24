package Pattern.NumberPattern;
public class pattern2
{
    public static void main(String[]arg)
    {
        byte num=7;

        for(int i=1;i<=num;i++)
        {
            int r=0;
            for(int j=1;j<=i;j++)
            {
                System.out.print(j+" ");
                r=j;
            }
            for(int f=r-1;f>0;f--)
            {
                System.out.print(f+" ");
            }
            System.out.println();
        }
    }
}

// output
// 1 
// 1 2 1 
// 1 2 3 2 1 
// 1 2 3 4 3 2 1 
// 1 2 3 4 5 4 3 2 1 
// 1 2 3 4 5 6 5 4 3 2 1 
// 1 2 3 4 5 6 7 6 5 4 3 2 1 