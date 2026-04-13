package BackTracking;
import java.util.*;


public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), list);
        return list;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> subList, List<List<Integer>> list) {
        if (target == 0) {
            list.add(new ArrayList<>(subList)); // add a copy of current combination
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                subList.add(candidates[i]);
                backtrack(candidates, target - candidates[i], i, subList, list); // allow reuse of same element
                subList.remove(subList.size() - 1); // backtrack
            }
        }
    }

    // Main method to test
    public static void main(String[] args) {
        CombinationSum sol = new CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> result = sol.combinationSum(candidates, target);
        System.out.println("Combinations that sum to " + target + ":");
        for (List<Integer> combo : result) {
            System.out.println(combo);
        }
    }

}
