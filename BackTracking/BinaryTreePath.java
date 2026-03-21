package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {
    // TreeNode definition
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static void main(String[] args) {
        // Build sample tree:
        //        1
        //       / \
        //      2   3
        //       \
        //        5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        BinaryTreePath sol = new BinaryTreePath();
        List<String> paths = sol.binaryTreePaths(root);

        System.out.println("Root-to-leaf paths:");
        for (String path : paths) {
            System.out.println(path);
        }
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> sList = new ArrayList<>();
        backTrack(root,"",sList);
        return sList;
    }

    static void backTrack(TreeNode root, String str,List<String> sList) {
        if(root == null) return;

         if(str.length()==0){
            str = root.val+"";
        } else {
            str = str+"->"+root.val+"";
        }
        
        if(root.left == null && root.right == null) {
            sList.add(str);
            return;
        }

        backTrack(root.left,str,sList);
        backTrack(root.right,str,sList);
        return;
    }
}

// Root-to-leaf paths:
// 1->2->5
// 1->3