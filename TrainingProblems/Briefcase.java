public class Briefcase {
    public static void main(String[] args) {
        int n = 11;
        if (n % 9 != 0) // n%9 give the sum of integer into single integer.but here it used for
                        // remaining word which is not division by 9, because 9 is largest single digit
                        // integer
        System.out.print(n % 9);
        for(int i=n/9;i>0;i--)
            System.out.print("9");  
            
        System.out.println("\nSum of integer into single digit :" + 29%9); // 2+9=11=1+1=2
    }
}
