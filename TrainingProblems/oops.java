import java.util.*;

interface area {
    public void rect();

    public void circle();
}

public class oops implements area {
    int a = 10;
    int b = 20;
    int r = 2;

    public void rect() {
        System.out.println("Area of rectangle is 10*20: " + (a * b));
    }

    public void circle() {
        System.out.println("Area of circle is 2*2*3.14: " + (r * r * 3.14));
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        System.out.println(s);
        oops obj = new oops();
        obj.rect();
        obj.circle();
        System.out.println("Hello World");
        sc.close();
    }
}