package BasicJavaProblems;

public class SwapWithoutThirdVar {


    static void swapByadd(int a,int b){
        System.out.println("SwapByAddandSub");
        System.out.println("Before Swap :"+a+" "+b);
        b=a+b;   //sum of two numbers   b=10+20 ==>b=30
        a=b-a;   //a=30-10  ==>a=20
        b=b-a;   //b=30-20  ==>b=10
        System.out.println("After Swap :"+a+" "+b);
    }
    public static void main(String[] args) {
        swapByadd(10,20);
        
    }
}
