import java.util.Scanner;

class Node{
    public int val;
    public Node next;
}
public class LinkedList {
    static Scanner sc=new Scanner(System.in);
    static Node head;
    
    
    void createNode(){
        System.out.println("Enter the insert value :");
        int val=sc.nextInt();
        Node obj1=new Node();
        obj1.val=val;
        obj1.next=null;
        
        
        if(head==null){
            System.out.println("head is null");
            head=obj1;
        }
        else{
            Node p=head;
            while(p.next!=null){
                System.out.println(p.val);
                p=p.next;
            }
            p.next=obj1;
        }
    }
    
    void display(){
        System.out.println("Display the node list :");
        Node p=head;
        while(p!=null){
            System.out.println(p.val);
            p=p.next;
        }
        
    }
    public static void main(String[] args) {
        
        LinkedList ob=new LinkedList();
        int n;
        do{
            System.out.println("Enter the operation :");
             n=sc.nextInt();
            switch(n){
                case 1:
                    ob.createNode();
                    break;
                case 2:
                    ob.display();
                    break;
                default:
                    System.out.println("Wrong operation");
            }
        
        }while(n<=2);
        
        
    }
}
