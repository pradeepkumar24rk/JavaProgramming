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

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val == q.val) {
            boolean l = isSameTree(p.left, q.left);
            boolean r = isSameTree(p.right, q.right);
            return l && r;
        }
        return false;
    }

    public static void main(String[] args) {
        // Build first tree:
        // 1
        // / \
        // 2 3
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        // Build second tree:
        // 1
        // / \
        // 2 3
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        SameTree sol = new SameTree();
        boolean same = sol.isSameTree(p, q);

        System.out.println("Are the two trees the same? " + same);
    }

}

// EXAMPLE 1:
// Input: p = [1,2,3], q = [1,2,3]
// Output: true

// EXAMPLE 2:
// Input: p = [1,2], q = [1,null,2]
// Output: false
