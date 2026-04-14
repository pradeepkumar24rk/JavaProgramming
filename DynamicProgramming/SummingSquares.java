package DynamicProgramming;

import java.util.*;
public class SummingSquares {
    public static void main(String[] args) {
        int count = summingSquarsBruteForce(10);
        System.out.println("summingSquars BruteForce: "+count);
        HashMap<Integer,Integer> memo = new HashMap<>();
        int countImp = summingSquars(87,memo);
        System.out.println("summingSquars (Improved): "+ countImp);
    } 
    
    static int summingSquarsBruteForce(int target) {
      // System.out.println(target);
      if(target == 0) return 0;
      
      int res = -1;
      for(int i = 1;i*i<=target;i++) {
        int squar = i*i;
        int ss = summingSquarsBruteForce(target-squar);
        if(ss!=-1) {
          int newss = ss+1;
          if(res == -1 || res>newss) {
            res = newss;
          }
        }
      }
      return res;
    }
    
    static int summingSquars(int target, HashMap<Integer,Integer> memo) {
      // System.out.println(target);
      if(target == 0) return 0;
      
      if(memo.containsKey(target))
      return memo.get(target);
      
      int res = -1;
      for(int i = 1;i*i<=target;i++) {
        int squar = i*i;
        int ss = summingSquars(target-squar,memo);
        if(ss!=-1) {
          int newss = ss+1;
          if(res == -1 || res>newss) {
            res = newss;
          }
        }
      }
      
      memo.put(target,res);
      
      return res;
    }
}
