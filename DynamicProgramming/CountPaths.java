package DynamicProgramming;

import java.util.*;
public class CountPaths {
    static int count;
    public static void main(String[] args) {
        boolean[][] board = {
          {true,true,false},
          {true,true,true},
        };
        countPathsBruteForce(board,"",0,0); // only for printing paths
        
        HashMap<String, Boolean> memo = new HashMap<>();
        countPathsBoolean(board,"",0,0,memo); 
        System.out.println("Boolean Memoization Count Path: "+count); // for counting paths using boolean memoization and count save in global variable
        
        HashMap<String, Integer> memoInt = new HashMap<>();
        int countInt = countPathsInt(board,0,0,memoInt); // for counting paths using integer memoization and count return from function
        System.out.println("Integer Memoization Count Path: "+countInt);
        
        List<List<Boolean>> boardList = new ArrayList<>();
        boardList.add(Arrays.asList(true,true,false));
        boardList.add(Arrays.asList(true,true,true));
        HashMap<List<Integer>, Integer> memoListInt = new HashMap<>();
        int countListInt = countPathsListInt(boardList,0,0,memoListInt); // for counting paths using integer memoization with List as key
        System.out.println("List Board Count Path: "+countListInt);
      
    }
 
    static void countPathsBruteForce(boolean[][] board,String path,int row,int col) {
      // System.out.println(board.length);
      //   System.out.println(row+" "+ col);
      if(row >= board.length || col >= board[0].length){
        return;
      };
      
      if(row == 1 && col == 2) {
        path += row+""+col;
        System.out.println(path);
        return;
      }
      
      if(!board[row][col]) return;
      
      path += row+""+col+",";
      countPathsBruteForce(board,path,row,col+1);
      countPathsBruteForce(board,path,row+1,col);
      return;
    }
    
    static boolean countPathsBoolean(boolean[][] board,String path,int row,int col,HashMap<String,Boolean> memo) {
      // System.out.println(board.length);
      //   System.out.println(row+" "+ col);
      String mat = row+""+col;
      if(row >= board.length || col >= board[0].length){
        return false;
      };
      
      if(row == 1 && col == 2) {
        path += mat;
        count++;
        // System.out.println(path);
        return true;
      }
      
      if(memo.containsKey(mat)) {
        count++;
        return memo.get(mat);
      }
      
      if(!board[row][col]) return false;
      
      path += mat+",";
      int nexCol = col+1;
      boolean left = countPathsBoolean(board,path,row,nexCol,memo);
      if(left) memo.put(row+""+nexCol,left);
      int nexRow = row+1;
      boolean right = countPathsBoolean(board,path,nexRow,col,memo);
      if(right) memo.put(nexRow+""+col,right);
      
      return left || right;
    }
    
    static int countPathsInt(boolean[][] board,int row,int col,HashMap<String,Integer> memo) {
        String mat = row+""+col;
      if(row >= board.length || col >= board[0].length){
        return 0;
      };
      
      if(row == 1 && col == 2) {
        return 1;
      }
      
      if(memo.containsKey(mat)) {
        return memo.get(mat);
      }
      
      if(!board[row][col]) return 0;
      
      int nexCol = col+1;
      int left = countPathsInt(board,row,nexCol,memo);
      if(left > 0) memo.put(row+""+nexCol,left);
      int nexRow = row+1;
      int right = countPathsInt(board,nexRow,col,memo);
      if(right > 0) memo.put(nexRow+""+col,right);
      
      return left + right;
    }
    
    static int countPathsListInt(List<List<Boolean>> board,int row,int col,HashMap<List<Integer>,Integer> memo) {
      if(row >= board.size() || col >= board.get(0).size()){
        return 0;
      };
      
      if(row == 1 && col == 2) {
        return 1;
      }
      
      List<Integer> pos = List.of(row,col);
      if(memo.containsKey(pos)) {
        return memo.get(pos);
      }
      
      if(!board.get(row).get(col)) return 0;
      

     int res = countPathsListInt(board,row,col+1,memo) + countPathsListInt(board,row+1,col,memo);
        if(res > 0) memo.put(pos,res);
    return res;
    }
}