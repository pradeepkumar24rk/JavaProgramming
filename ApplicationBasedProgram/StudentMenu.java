import java.util.*;
public class StudentMenu {
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        
        studentop op=new studentop();
        int p;
        System.out.println("------------------------------------");
        System.out.println("1.add the student\n2.display all the student\n3.specific student\n4.Exit..");
        System.out.println("------------------------------------");
        do{
            System.out.println("Enter the operation:");
            p=sc.nextInt();
            switch(p){
                case 1:
                    op.addStudent();
                    break;
                case 2:
                    op.display();
                    break;
                case 3:
                    op.specific();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                
            }

        }while(p!=4);
        sc.close();
            
    }
}


class studentop{

    student data[]=new student[10];
    Scanner sc=new Scanner(System.in);

    int Rollno=0;
    public void addStudent(){
        System.out.println("Enter Number of student to add:");
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            System.out.println("Name :");
            String n=sc.next();
            System.out.println("Dept:");
            String d=sc.next();
            System.out.println("Marks:");
            int m[]=new int[5];
            for(int j=0;j<5;j++){
                m[i]=sc.nextInt();
            }
            student obj=new student(n,d,m);
            data[Rollno]=obj; 
            Rollno++;
                        
        }
    }


    
    public void display(){
        
        for(int i=0;i<Rollno;i++){
            System.out.println("----------------------------------");
            System.out.println("Rollno:"+(i+1));
            System.out.println("Name :"+data[i].getName());
            System.out.println("Dept :"+data[i].getdept());
            System.out.println("-----------------------------------");
        }
    }

    public void specific(){
        System.out.println("Enter the student rollno:");
        int x=sc.nextInt();
        System.out.println("Rollno:"+(x));
        System.out.println("Name :"+data[x-1].getName());
        System.out.println("Dept :"+data[x-1].getdept());
        System.out.println("Avg :"+avg(data[x-1].getmark()));
    }

    public static int avg(int m[]){
        int sum=0;
        for(int j=0;j<m.length;j++){
            sum+=m[j];
        }
        System.out.println("Total :"+sum);
        return sum/5;
    }
}


class student{
    private String name="";
    private String dept="";
    private int mark[]=new int[5];
    student(String a,String b,int c[]){
        this.name=a;
        this.dept=b;
        this.mark=c;
    }
    public String getName(){
        return name;
    }
    public String getdept(){
        return dept;
    }
    public int[] getmark(){
        return mark;
    }
}
