import java.util.Scanner;
public class videoBuy {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        videop op=new videop();
        Scanner sc=new Scanner(System.in);
        int i;
        do{
            System.out.print("\n-------------------------------------------------------------------");
            System.out.print("\n1.Add video\n2.Take video\n3.return value\n4.Rate video\n5.display\n6.Exit\n");
            System.out.print("\n-------------------------------------------------------------------");
            System.out.print("\nEnter the operation : ");
            i=sc.nextInt();
            switch(i){
                case 1:
                    op.addvideo();
                    break;
                case 2:
                    op.takevideo();
                    break;
                case 3:
                    op.returnvideo();
                    break;
                case 4:
                    op.ratevideo();
                    break;
                case 5:
                    op.display();
                    break;
                case 6:
                    System.out.println("Exited");
                    break;

            }

        }while(i!=6);
        
        sc.close();

    }
}
class videop{
    video vs[]=new video[10];
    Scanner sc=new Scanner(System.in);
    int id=0;
    public void addvideo(){
        System.out.print("\nEnter the video name : ");
        String s=sc.next();
        video data=new video(s, true, 0, 0);
        vs[id]=data;
        id++;
        System.out.print("\nVideo is add successfully");
        System.out.print("\n-------------------------------------------------------------------");

    }

    public void takevideo(){
        System.out.print("\nEnter the video name : ");
        String s=sc.next();
        for(int i=0;i<id;i++){
            if((vs[i].getName()).equals(s)){
                Boolean a=false;
                int count =vs[i].getcus()+1;
                video data=new video(s, a,vs[i].getrate() , count);
                vs[i]=data;
                System.out.print("\nVideo is successfully taken");
                System.out.print("\n-------------------------------------------------------------------");

            }
        }
    }

    public void returnvideo(){
        System.out.print("\nEnter the video name : ");
        String s=sc.next();
        int c=0;
        for(int i=0;i<id;i++){
            if((vs[i].getName()).equals(s)){
                Boolean a=true;
                int count =vs[i].getcus();
                video data=new video(s, a,vs[i].getrate(), count);
                vs[i]=data;
                System.out.print("\nVideo is successfully returned");
                System.out.print("\n-------------------------------------------------------------------");
            }
            else
                c++;
        }
        if(c==id){
            
            System.out.print("\nVideo is not founded");
            System.out.print("\n-------------------------------------------------------------------");

        }
        
    }
    public void ratevideo(){
        System.out.print("\nEnter the video name :");
        String s=sc.next();
        System.out.print("\nEnter the rate :");
        int r=sc.nextInt();
        for(int i=0;i<id;i++){
            if((vs[i].getName()).equals(s)){
                int count =vs[i].getcus();
                float rate;
                if(count==1)
                    rate=r;
                else
                    rate=(vs[i].getrate()+r)/2;
                video data=new video(s,vs[i].getavail(),rate ,count);
                vs[i]=data;
                System.out.print("\nrate is updated");
                System.out.print("\n-------------------------------------------------------------------\n");

                
            }
        }
    }
    
    public void display() {
        // System.out.println("Enter the video name : ");
      //  String s=sc.next();
        for(int i=0;i<id;i++){
            // if((vs[i].getName()).equals(s)){
                System.out.print("\n*********************************************************************");
                System.out.print("\nName\tAvailable\trate\tcustomer\tcount");
                System.out.print("\n"+vs[i].getName()+"\t"+vs[i].getavail()+"\t"+vs[i].getrate()+"\t"+vs[i].getcus());
                System.out.print("\n*********************************************************************");
                
            // }
        }
        
    }
}
class video{
    private String name="";
    private boolean avail=true;
    private float rate=0;
    private int cus=0;
    video(String a,boolean b,float c,int d){
          this.name=a;
          this.avail=b;
          this.rate=c;
          this.cus=d;
    }
    public String getName(){
        return name;
    }
    public boolean getavail(){
        return avail;
    }
    public float getrate(){
        return rate;
    }
    public int getcus(){
        return cus;
    }
}

