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
    
    public static void main(String[] args) {
        Tree root=new Tree();
        root=null;
        root=insert(root,5);
        root=insert(root,8);
        root=insert(root,4);
        root=insert(root,1);
        root=insert(root,6);
        
        System.out.println("-------------INORDER----------------");
        inorder(root);
        System.out.println("\n-------------DESINORDER----------------");
        desinorder(root);
        System.out.println("\n-------------PREORDER----------------");
        preorder(root);
        System.out.println("\n-------------POSTORDER----------------");
        postorder(root);
    }
}
