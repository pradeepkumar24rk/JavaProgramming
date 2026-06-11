package Tree;

class Tree {
    int val;
    Tree left, right;

    Tree() {
    }

    Tree(int val) {
        this.val = val;
    }

    Tree(int val, Tree left, Tree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SubtreeOfAnotherTree {
    // public static boolean isSubTreeOfAnotherTree(Tree p, Tree q) { // it work
    // only if root initial node of p and q is not same
    // if (p == null && q == null) {
    // return true;
    // }
    // if (p == null && q != null) {
    // return false;
    // }

    // if (p != null && q == null) {
    // return false;
    // }

    // if (p.val == q.val) {

    // boolean isSubstree = isSubTreeOfAnotherTree(p.left, q.left) &&
    // isSubTreeOfAnotherTree(p.right, q.right);
    // if(!isSubstree) {
    // return isSubTreeOfAnotherTree(p.left, q) || isSubTreeOfAnotherTree(p.right,
    // q);
    // }
    // return isSubstree;

    // }

    // return isSubTreeOfAnotherTree(p.left, q) || isSubTreeOfAnotherTree(p.right,
    // q);
    // }

    public static boolean isSubTreeOfAnotherTree(Tree p, Tree q) {
        if (p == null)
            return false;
        if (isSameTree(p, q))
            return true;
        return isSubTreeOfAnotherTree(p.left, q) || isSubTreeOfAnotherTree(p.right, q);

    }

    public static boolean isSameTree(Tree p, Tree q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null && q != null) {
            return false;
        }

        if (p != null && q == null) {
            return false;
        }

        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }

    public static void main(String[] args) {

        // Build first tree:
        // 1
        // / \
        // 2 3
        // / /
        // 4 5
        Tree p = new Tree(1);
        p.left = new Tree(2);
        p.right = new Tree(3);
        p.left.left = new Tree(4);
        p.right.left = new Tree(5);

        // Build second tree:
        // 1
        // / \
        // 4 5
        Tree q = new Tree(1);
        q.left = new Tree(4);
        q.right = new Tree(5);

        boolean same = isSubTreeOfAnotherTree(p, q);

        System.out.println("Is the first tree a subtree of the second? " + same);
    }
}
