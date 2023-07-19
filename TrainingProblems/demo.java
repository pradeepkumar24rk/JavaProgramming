public class demo {
    static int a=10;
    
    static int func(){
    int b=a+1;
    a=a+1;
        return b;
    }
    public static void main(String[] args) {
        
        System.out.println(func());
        a=a+1;
        System.out.println(a);
        
        StringBuilder s1=new StringBuilder("pradeep");
        StringBuilder s2=s1;
        s1.reverse();
        System.out.println(s1);
        System.out.println(s2);
        
        
        
        
    }
}
