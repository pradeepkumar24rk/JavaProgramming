class Tree {
    int val;
    Tree left, right;

    public Tree(int val) {
        this.val = val;
    }
}

public class BinaryTreeSumOfLeft {

    public static void checktheBinaryTree(Tree root) {
        
        if(root.val==sumOfChild(root.val))
            true;
        
    }

    public static void main(String[] args) {
        Tree root;
        root=new Tree(10);
        root.left=new Tree(8);
        root.right=new Tree(2);
        root.right.left=new Tree(2);
        root.left.right=new Tree(5);
        root.left.left=new Tree(3);
        
       SystechecktheBinaryTree(root)); 
        
    }
}
