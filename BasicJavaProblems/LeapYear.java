package BasicJavaProblems;

public class LeapYear {


    static boolean Leap(int n){
        if((n%4==0 && n%100!=0)||(n%400==0))
            return true;
        return false;
    }
    
    static boolean detail(int n){
         // if the year is divided by 4
        if(n%4==0){
            //if year is century
            if(n%100==0){
            
                // if year is divided by 400
                // then it is a leap year
                if(n%400==0)
                    return true;
                else
                    return false;
            }
            else
                return true;
        }
        else
            return false;
    }
    public static void main(String[] args) {
        int n=1900; //not leap year
        System.out.println("Shorted condition :");
        System.out.println(Leap(n));
        System.out.println("complete condition :");
        System.out.println(detail(n));
    }
}
