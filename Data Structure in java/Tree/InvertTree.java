package Tree;

class Tree {
    int val;
    Tree left, right;
}

public class InvertTree {

    // Preorder traversal to collect values
    static void preOrder(Tree root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // In-place inversion (most optimal)
    static void invertSwap(Tree root) {
        if (root == null) return;
        Tree temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertSwap(root.left);
        invertSwap(root.right);
    }  // this is the most optimal solution as it does not require extra space for creating new tree and it does the swapping in place.

    // Create a new inverted tree (extra space)
    public static Tree invertTree(Tree root) {
        if (root == null) return null;
        Tree res = new Tree();
        res.val = root.val;
        invert(root, res);
        return res;
    } // this is the solution which creates a new tree and does not modify the original tree. It uses extra space for creating new tree and also for the recursive stack.

    static void invert(Tree root, Tree res) {
        if (root == null) return;

        if (root.right != null) {
            res.left = newNode(root.right);
            invert(root.right, res.left);
        }
        if (root.left != null) {
            res.right = newNode(root.left);
            invert(root.left, res.right);
        }
    }

    static Tree newNode(Tree root) {
        Tree nn = new Tree();
        nn.val = root.val;
        return nn;
    }

    public static void main(String[] args) {
        // Build sample tree:
        //        1
        //       / \
        //      2   3
        //     /   / \
        //    4   7   5
        Tree root = new Tree();
        root.val = 1;
        root.left = new Tree();
        root.left.val = 2;
        root.right = new Tree();
        root.right.val = 3;
        root.left.left = new Tree();
        root.left.left.val = 4;
        root.right.left = new Tree();
        root.right.left.val = 7;
        root.right.right = new Tree();
        root.right.right.val = 5;

        System.out.println("Original tree (preorder):");
        preOrder(root);

        // In-place inversion
        invertSwap(root);
        System.out.println("\nInverted tree (preorder, in-place):");
        preOrder(root);

        // Build tree again for new-tree inversion
        Tree root2 = new Tree();
        root2.val = 1;
        root2.left = new Tree();
        root2.left.val = 2;
        root2.right = new Tree();
        root2.right.val = 3;
        root2.left.left = new Tree();
        root2.left.left.val = 4;
        root2.right.left = new Tree();
        root2.right.left.val = 7;
        root2.right.right = new Tree();
        root2.right.right.val = 5;

        Tree res = invertTree(root2);
        System.out.println("\nInverted tree (preorder, new tree):");
        preOrder(res);
    }
}