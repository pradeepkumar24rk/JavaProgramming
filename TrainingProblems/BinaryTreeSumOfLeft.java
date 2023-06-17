//The sum of immediate child == root

public class BinaryTreeSumOfLeft {
    static class Tree {
        int val;
        Tree left, right;

        public Tree(int val) {
            this.val = val;
        }
    }

    public static int checktheBinaryTree(Tree root) {

        if (root == null || root.left == null && root.right == null)
            return 1;
        int child = 0;
        if (root.left != null)
            child += root.left.val;
        if (root.right != null)
            child += root.right.val;
        if (child == root.val && (checktheBinaryTree(root.left) == 1) && (checktheBinaryTree(root.right) == 1))
            return 1;
        else
            return 0;

    }

    public static void main(String[] args) {
        Tree root;
        root = new Tree(10);
        root.left = new Tree(8);
        root.right = new Tree(2);
        root.right.left = new Tree(2);
        root.left.right = new Tree(5);
        root.left.left = new Tree(3);

        if (checktheBinaryTree(root) == 1)
            System.out.println("The sum of immediate child == root is true");
        else
            System.out.println("The sum of immediate child == root is false");

    }
}
