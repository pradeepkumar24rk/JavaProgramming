package BackTracking;

public class NQueens {

    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        int val = solveNQ(board, 0);
        System.out.println(val);
    }

    static void displayBoard(boolean board[][]) {
        // for(int[] arr:board) {
        // System.out.println(Arrays.toString(arr));
        // }
        for (boolean[] arr : board) {
            for (boolean ele : arr) {
                if (ele) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    static int solveNQ(boolean[][] board, int row) {
        if (row == board.length) {
            displayBoard(board);
            return 1;
        }

        int count = 0;
        for (int col = 0; col < board[0].length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += solveNQ(board, row + 1);
                board[row][col] = false;
            }
        }
        return count;
    }

    static boolean isSafe(boolean[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col])
                return false;
        } // top-bottom

        // right dia
        int rightdia = Math.min(row, (board[0].length - 1) - col);
        // System.out.println(rightdia);
        for (int i = 1; i <= rightdia; i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }

        // left dia
        int maxleft = Math.min(row, col);
        for (int i = 1; i <= maxleft; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }
        return true;
    }

}