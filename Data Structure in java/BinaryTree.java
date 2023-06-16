class Tree{
    int val;
    Tree left,right;
}
public class BinaryTree {

    public static Tree insert(Tree root,int v) {
        if(root==null){
            Tree node=new Tree();
            node.val=v;
            return node;
        }
        else if(root.val<v)
            root.right=insert(root.right, v);
        else if(root.val>v)
            root.left=insert(root.left, v);
        
        return root;
    }
    
    public static void inorder(Tree root) {          //print tha value in ascending order
        if(root==null)
            return;
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }
    
    public static void desinorder(Tree root) {          //print tha value in descending order
        if(root==null)
            return;
        desinorder(root.right);
        System.out.print(root.val+" ");
        desinorder(root.left);
    }
        
    public static void preorder(Tree root) {
        if(root==null)
            return;
        System.out.print(root.val+" ");
        preorder(root.left);
        preorder(root.right);
    }
    
    public static void postorder(Tree root) {
        if(root==null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val+" ");
    }
    
    
    
    
    //Find the tree is perfect tree or not
    
    
    public static int depth(Tree root) {
        int d=0;
        while(root!=null){
            d++;
            root=root.left;
        }
        return d;
    }
    
    public static boolean checkChildBranch(Tree root,int d,int level ) {
        if(root==null)
            return true;
        
        if(root.left==null && root.right==null)
            return (d==level+1);
        if(root.left==null || root.right==null)
            return false;
        
        return checkChildBranch(root.left,d,level+1) && checkChildBranch(root.right,d,level+1);
    }
    
    public static boolean isPerfectTree(Tree root) {
        int d=depth(root);
        return checkChildBranch(root,d,0);
    }
    
    
    
    
    public static void main(String[] args) {
        Tree root=new Tree();
        root=null;
        root=insert(root,10);
        root=insert(root,8);
        root=insert(root,7);
        root=insert(root,9);
        root=insert(root,12);
        root=insert(root,11);
        root=insert(root,13);
        
        System.out.println("-------------INORDER----------------");
        inorder(root);
        System.out.println("\n-------------DESINORDER----------------");
        desinorder(root);
        System.out.println("\n-------------PREORDER----------------");
        preorder(root);
        System.out.println("\n-------------POSTORDER----------------");
        postorder(root);
        System.out.println("\n-------------IsPerfectBinaryTree----------------");
        System.out.println(isPerfectTree(root));
    }
}
