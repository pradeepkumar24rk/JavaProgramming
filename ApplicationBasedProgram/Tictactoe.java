import java.util.Scanner;

public class Tictactoe {
    public static void main(String[] args) {
        // System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int n = 3;
        String arr[][] = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = " ";
            }
        }

        boolean gameOver = false;
        String player = "x";
        while (!gameOver) {
            printBoard(arr, n);
            System.out.print("Enter your index " + player + ": ");
            String ind = sc.nextLine();
            arr[Integer.parseInt(ind.charAt(0) + "")][Integer.parseInt(ind.charAt(1) + "")] = player;
            if (haveWon(arr, n, player)) {
                gameOver = true;
                System.out.println("Player " + player + " has won!");
            }
            player = player.equals("x") ? "o" : "x";
        }
        printBoard(arr, n);
        sc.close();
    }

    static void printBoard(String arr[][], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" | " + arr[i][j] + " | ");
            }
            System.out.println();
        }
    }

    static boolean haveWon(String arr[][], int n, String player) {
        for (int i = 0; i < n; i++) { // row
            if (arr[i][0] == player && arr[i][1] == player && arr[i][2] == player) {
                return true;
            }

        }

        for (int i = 0; i < n; i++) { // col
            if (arr[0][i] == player && arr[1][i] == player && arr[2][i] == player) {
                return true;
            }
        }

        if (arr[0][2] == player && arr[1][1] == player && arr[2][0] == player) {
            return true;
        }

        if (arr[0][0] == player && arr[1][1] == player && arr[2][2] == player) {
            return true;
        }

        return false;
    }
}
