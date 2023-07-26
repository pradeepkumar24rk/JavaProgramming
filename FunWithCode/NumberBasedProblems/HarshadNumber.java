package NumberBasedProblems;
public class HarshadNumber {
    public static void main(String[] args) {
        int n=1729,sum=0,temp=n;
    while(temp!=0){
        sum+=temp%10;
        temp/=10;
    }
    if(n%sum==0)
      System.out.println("True");
    else
        System.out.println("False");
    
    }
}


// The number 18 is a Harshad number in base 10, because the sum of the digits 1 and 8 is 9 (1 + 8 = 9), and 18 is divisible by 9 (since 18 % 9 = 0)

//input

// 18       

// output

// True