package Pattern.NumberPattern;
public class spiral {
    public static void main(String[] args) {
      // S-
      int n=5;
      int a[][]=new int[n][n];
      int x=1;
      int row=0,col=0;
      int right=n-1,left=0;
      int top=0,bottom=n-1;
      for (int t=0;t<n-2;t++)
      {
        for(int i=col;i<=right;i++){
          a[row][i]=x;
        //  System.out.print(a[row][i]+" ");
          x++;
          col++;
          
        }
        col--;
        right--;
        for(int i=row+1;i<=bottom;i++){
         // try{
          a[i][col]=x;
          // System.out.print(a[i][col]+" ");
          row++;
          x++;
         // }catch(Exception e){}
        }
      //  row--;
        bottom--;
        for(int i=col-1;i>=left;i--){
          a[row][i]=x;
         //  System.out.print(a[row][i]+" ");
          x++;
          col--;
        }
       // col++;
        left++;
        for(int i=row-1;i>top;i--){
          a[i][col]=x;
          // System.out.print(a[i][col]+" ");
          x++;
          row--;
        }
       // row++;
        top++;
        col++;
      }
      for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
          System.out.print(a[i][j]+" ");
        }
        System.out.println();
      }
  }
}


// output
// 01 02 03 04 05 
// 16 17 18 19 06 
// 15 24 25 20 07 
// 14 23 22 21 08 
// 13 12 11 10 09 