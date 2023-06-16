import java.util.Scanner;

class Node{
    public int val;
    public Node next;
}
public class LinkedList {
    static Scanner sc=new Scanner(System.in);
    static Node head;
    
    
    void insertAtLast(){
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
                p=p.next;
            }
            p.next=obj1;
        }
    }
    
    void insertAtBegin(){
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
            obj1.next=head;
            head=obj1;
        }
        
    }
    
    void insertAtSpecific(int position){
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
            int loc=0;
            while(p!=null && ((position-1)>loc)){
                p=p.next;
                loc++;
            }
            Node temp=p.next;
            p.next=obj1;
            obj1.next=temp;
        }
         
    }
    void deleteAtBegin(){
        if(head==null)
            System.out.println("List is empty");
        else
            head=head.next;
    }
    
    void deleteAtLast(){
        if(head==null)
            System.out.println("List is empty");
        else{
            Node p=head;
            Node p1=head;
            while(p.next!=null){
                p1=p;
                p=p.next;
            }
            p1.next=null;    
        }
    }
    
    void deleteAtSpecific(int position){
        if(head==null)
            System.out.println("List is empty");
        else{
            Node p=head;
            Node temp=head;
            int loc=0;
            while(p!=null && ((position-1)>loc)){
                p=p.next;
                loc++;
            }
            
            temp=p.next;
            // System.out.println("p.val ="+p.val);
            // System.out.println("temp.val ="+temp.val);
            // System.out.println("temp.next.val ="+temp.next.val);
            p.next=temp.next;
        
            
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
                    ob.insertAtLast();
                    break;
                case 2:
                    ob.insertAtBegin();
                    break;
                case 3:
                    System.out.println("Enter the position by index :");
                    int p=sc.nextInt();
                    ob.insertAtSpecific(p);
                    break;
                case 4:
                    ob.deleteAtBegin();
                    break;
                case 5:
                    ob.deleteAtLast();
                    break;
                case 6:
                    System.out.println("Enter the position by index :");
                    int pos=sc.nextInt();
                    ob.deleteAtSpecific(pos);
                    break;
                case 7:
                    ob.display();
                    break;
                default:
                    System.out.println("Wrong operation");
            }
        
        }while(n<=7);
        
        
    }
}
