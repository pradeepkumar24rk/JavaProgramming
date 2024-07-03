package Recursion;

public class PatternRightAngleTriangle {

    static void downPattern(int row,int col) {
        if(row==-1)
            return;
        if(row == col){
            System.out.println();
            downPattern(row-1, 0);
        }
        else{
            System.out.print("* ");
            downPattern(row,col+1);
        }
    }
    static void upPattern(int row,int col) {
        if(row==-1)
            return;
        if(row == col){
            upPattern(row-1, 0);
            System.out.println();
        }
        else{
            upPattern(row,col+1);
            System.out.print("* ");
        }
    }
    public static void main(String[] args) {
        downPattern(4,0);
        upPattern(4, 0);
    }
}


//output
// * * * * 
// * * *
// * *
// *



// *
// * *
// * * *
// * * * *