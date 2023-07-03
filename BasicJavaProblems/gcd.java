package BasicJavaProblems;

public class gcd {

    static int GeneralMethod(int a, int b) {
        int gcd = 0;
        for (int i = 1; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0)
                gcd = i;
        }
        return gcd;
    }

    static int eludienSub(int a, int b) {
        if (b == 0)
            return a;
        else
            return eludienSub(b, Math.abs(a - b));
    }

    static int eludienMod(int a, int b) {
        if (b == 0)
            return a;
        else
            return eludienSub(b, (a % b));
    }

    public static void main(String[] args) {
        System.out.println("General Method :");
        System.out.println(GeneralMethod(20, 30));
        System.out.println("Eudien Algorithm(Subtraction)");
        System.out.println(eludienSub(20, 30));
        System.out.println("Eudien Algorithm(%)");
        System.out.println(eludienMod(20, 30));
    }
}
