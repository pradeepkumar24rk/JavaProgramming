package Tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class MaximumDepth {
    public int maxDepth(TreeNode root) {
        return maxdep(root, 0);
    }

    static int maxdep(TreeNode root, int count) {
        // System.out.println(count);
        if (root == null) {
            return count;
        }
        int l = maxdep(root.left, count + 1);
        int r = maxdep(root.right, count + 1);
        // System.out.println(l+" "+r);
        return l > r ? l : r;
    }

    public static void main(String[] args) {
        // Build sample tree:
        // 3
        // / \
        // 9 20
        // / \
        // 15 7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaximumDepth sol = new MaximumDepth();
        int depth = sol.maxDepth(root);

        System.out.println("Maximum depth of tree: " + depth);
    }

}

// Input: root = [3,9,20,null,null,15,7]
// Output: 3