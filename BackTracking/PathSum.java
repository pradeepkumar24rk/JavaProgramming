package BackTracking;

import java.util.*;

public class PathSum {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static void main(String[] args) {
        // Build sample tree:
        //        5
        //       / \
        //      4   8
        //     /   / \
        //    11  13  4
        //   /  \     / \
        //  7    2   5   1
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;

        PathSum demo = new PathSum();
        List<List<Integer>> result = demo.pathSum(root, targetSum);

        System.out.println("Paths with sum " + targetSum + ":");
        for (List<Integer> path : result) {
            System.out.println(path);
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> pathSum = new ArrayList<>();
        backTrack(root, targetSum, 0, new ArrayList<>(), pathSum);
        return pathSum;
    }

    static void backTrack(TreeNode root, int targetSum, int sum, List<Integer> path, List<List<Integer>> pathSum) {
        if (root == null) return;

        sum += root.val;
        path.add(root.val);
        
        backTrack(root.left, targetSum, sum, path, pathSum);
        backTrack(root.right, targetSum, sum, path, pathSum);

        if (root.left == null && root.right == null && sum == targetSum) {
            pathSum.add(new ArrayList<>(path));
        }

        path.remove(path.size() - 1);
    }
}

// Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
// Output: [[5,4,11,2],[5,8,4,5]]
// Explanation: There are two paths whose sum equals targetSum:
// 5 + 4 + 11 + 2 = 22
// 5 + 8 + 4 + 5 = 22