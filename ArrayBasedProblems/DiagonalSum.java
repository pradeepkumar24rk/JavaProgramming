package ArrayBasedProblems;

public class DiagonalSum {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println("Diagonal sum: " + diagonalSum(matrix));
    }
    
    public static int diagonalSum(int[][] matrix) { // O(n) time and O(1) space
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
            if (i != matrix.length - i - 1) {
                sum += matrix[i][matrix.length - i - 1];
            }
        }
        return sum;
    }
    
    public int bruceForce(int[][] mat) { // O(n^2) time and O(1) space
        int sum = 0;
        int col = mat[0].length-1;
        for(int i =0;i<mat.length;i++) {
            for(int j = 0;j<mat[0].length;j++) {
                if(i==j || j==(col-i)){
                    System.out.println(mat[i][j]);
                    sum += mat[i][j];
                }
            }
        }
        return sum;
    }
}
