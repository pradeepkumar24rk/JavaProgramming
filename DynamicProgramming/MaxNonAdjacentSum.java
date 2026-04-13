package DynamicProgramming;

import java.util.*;

public class MaxNonAdjacentSum {
    public static void main(String[] args) {
        int[] nums = { 2, 4, 5, 12, 7 };
        int maxSum = maxNonAdjacentSumBruteForce(nums);
        HashMap<String, Integer> memo = new HashMap<>();
        int maxSumImproved = maxNonAdjacentSum(nums, memo);
        System.out.println("Max Non-Adjacent Sum (Brute Force): " + maxSum);
        System.out.println("Max Non-Adjacent Sum (Improved): " + maxSumImproved);
        int maxSumWithoutSubArray = maxNonAdjacentSumWithoutSubArrayBruteForce(nums, 0);
        System.out.println("Max Non-Adjacent Sum (Without SubArray): " + maxSumWithoutSubArray);
        HashMap<Integer, Integer> memoWithoutSubArray = new HashMap<>();
        int maxSumWithoutSubArrayImproved = maxNonAdjacentSumWithoutSubArray(nums, 0, memoWithoutSubArray);
        System.out.println("Max Non-Adjacent Sum (Without SubArray Improved): " + maxSumWithoutSubArrayImproved);
        
    }

    static int[] subArray(int[] nums, int start, int end) {
        if (start > end) {
            return new int[0];
        }
        int[] arr = new int[end - start];
        for (int i = start, j = 0; i < end; i++, j++) {
            arr[j] = nums[i];
        }
        return arr;
    }

    static int maxNonAdjacentSumBruteForce(int[] nums) {
        if (nums.length == 0)
            return 0;
        int left = maxNonAdjacentSumBruteForce(subArray(nums, 2, nums.length));
        System.out.println("Left: " + left);
        int right = maxNonAdjacentSumBruteForce(subArray(nums, 1, nums.length));
        System.out.println("Right: " + right);
        return Math.max(nums[0] + left, right);
    }

    static int maxNonAdjacentSum(int[] nums, HashMap<String, Integer> memo) {
        if (nums.length == 0)
            return 0;

        String key = Arrays.toString(nums);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int left = maxNonAdjacentSum(subArray(nums, 2, nums.length), memo);

        int right = maxNonAdjacentSum(subArray(nums, 1, nums.length), memo);

        int res =  Math.max(nums[0] + left, right);
        if (res > 0)
            memo.put(key, res);

        return res;
    }

    static int maxNonAdjacentSumWithoutSubArrayBruteForce(int[] nums, int index) {
        if (index >= nums.length)
            return 0;

        return Math.max(nums[index] + maxNonAdjacentSumWithoutSubArrayBruteForce(nums, index + 2),
                maxNonAdjacentSumWithoutSubArrayBruteForce(nums, index + 1));

    }
    
     static int maxNonAdjacentSumWithoutSubArray(int[] nums, int index, HashMap<Integer, Integer> memo) {
        if (index >= nums.length)
            return 0;
           
        if(memo.containsKey(index)) {
            return memo.get(index);
        }

        int res =  Math.max(nums[index] + maxNonAdjacentSumWithoutSubArray(nums, index + 2, memo),
                maxNonAdjacentSumWithoutSubArray(nums, index + 1, memo));
        if(res > 0) memo.put(index, res);
                
        return res;

    }
    
    
}

// Input: nums = [2,4,5,12,7]
// Output: 16
// Explanation:
// 2,4,5,12,7
// / \
// 5,12,7 4,5,12,7
// / \ / \
// 7 12,7 12,7 5,12,7
// / \ / \
// [] [] [] 7