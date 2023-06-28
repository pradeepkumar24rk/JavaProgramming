public class suduko {
    static int n=9;
    static boolean check(int grid[][],int row,int col){
        if(row==n-1 && col==n)
            return true;
        if(col==n)
        {
            row++;
            col=0;
        }
        if(grid[row][col]!=0)
            return check(grid, row, col+1);
        for(int i=1;i<=n;i++){
            if(issafe(grid,row,col,i)){
                grid[row][col]=i;
                // System.out.println(i);
                if(check(grid, row, col+1))
                    return true;
            }
            grid[row][col]=0;
        }
        
        return false;
    }

    static boolean issafe(int grid[][],int row,int col,int i){

        for(int j=0;j<n;j++)
            if(grid[row][j]==i)
                return false;

        for(int j=0;j<n;j++){
            if(grid[j][col]==i)
                return false;
        }

        int st=row-row%3,sp=col-col%3;
        for(int j=0;j<3;j++){
            for(int k=0;k<3;k++){
                if(grid[j+st][k+sp]==i)
                    return false;
            }
        }

        return true;
    }

    static void print(int grid[][]){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
        public static void main(String[] args) {
            int grid[][]={ { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                            { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                            { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                            { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                            { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                            { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                            { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                            { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                            { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
            if(check(grid,0,0))
                print(grid);
            else
                System.out.println("empty");
        }
}
