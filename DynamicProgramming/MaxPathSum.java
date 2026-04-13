package DynamicProgramming;

import java.util.HashMap;
import java.util.List;

public class MaxPathSum {
    public static void main(String[] args) {
        List<List<Integer>> boardList = List.of(
            List.of(5, 3, 2),
            List.of(1, 4, 6)
        );
        HashMap<List<Integer>, Integer> memo = new HashMap<>();
        int maxSum = maxPathListInt(boardList, 0, 0, memo);
        System.out.println("Max Path Sum: " + maxSum);
    }
    
    static int maxPathListInt(List<List<Integer>> board,int row,int col,HashMap<List<Integer>,Integer> memo) {
      if(row >= board.size() || col >= board.get(0).size()){
        return 0;
      };
      
      if(row == 1 && col == 2) {
        return board.get(row).get(col);
      }
      
      List<Integer> pos = List.of(row,col);
      if(memo.containsKey(pos)) {
        return memo.get(pos);
      }
      

     int left = maxPathListInt(board,row,col+1,memo);
     int right = maxPathListInt(board,row+1,col,memo);
     int res = board.get(row).get(col) + Math.max(left, right);
        if(res > 0) memo.put(pos,res);
    return res;
    }
}
