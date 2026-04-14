package DynamicProgramming;

import java.util.*;
public class CountingChange {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int count = countChange(4,nums,0);
        System.out.println("CountChange BruteForce: "+count);
        HashMap<String,Integer> memo = new HashMap<>();
        int countImp = countChange(4,nums,0,memo);
        System.out.println("CountChange (Improved): "+ countImp);
    } 
    
    static int countChange(int target,int[] nums,int start ) {
      if(target==0) return 1;
      if(target < 0) return 0;
      int res = 0;
      for(int i = start;i<nums.length;i++) {
        res += countChange(target-nums[i],nums,i);
      }
      return res;
    }
    
     static int countChange(int target,int[] nums,int start,HashMap<String, Integer> memo ) {
      if(target==0) return 1;
      if(target < 0) return 0;

      String key = target+"-"+start;
      if(memo.containsKey(key)) return memo.get(key);
      
    
      int res = 0;
      for(int i = start;i<nums.length;i++) {      
        res += countChange(target-nums[i],nums,i,memo);;
      }
    
      memo.put(key,res);      
      return res;
    }
}

