import java.util.Scanner;
class MediaModel {
    private int id = 0;
    private String name = "";
    private int connections[];
    
    MediaModel(int id, String name, int connections[]) {
        this.id = id;
        this.name = name;
        this.connections = connections;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public int[] getConnections() {
        return connections;
    }

}

class MediaViewModel {
    
}


public class SocialMedia {

    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        
        MediaViewModel media=new MediaViewModel();
        int p;
        System.out.println("------------------------------------");
        System.out.println("1.add the Member\n2.display all the Member\n3.specific Member\n4.Mutual Friends\n5.Exit..");
        System.out.println("------------------------------------");
        do{
            System.out.println("Enter the operation:");
            p=sc.nextInt();
            switch(p){
                case 1:
                    media.addStudent();
                    break;
                case 2:
                    media.display();
                    break;
                case 3:
                    media.specific();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                
            }

        }while(p!=5);
        sc.close();
            
    }
}

