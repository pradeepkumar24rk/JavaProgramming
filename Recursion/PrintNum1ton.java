package Recursion;

public class PrintNum1ton {

    static void one_to_n(int n) {
        if(n==1) {
            System.out.print(n+" ");
            return;
        }
        one_to_n(n-1);
        System.out.print(n +" ");
    }
    
    static void n_to_one(int n) {
        if(n==1) {
            System.out.print(n+" ");
            return;
        }
        System.out.print(n+" ");
        n_to_one(n-1);
    }
    
    static void uninarySub(int n) {
        if(n==1) {
            System.out.print(n+" ");
            return;
        }
        System.out.print(n+" ");
        // uninarySub(n--);  -- stack over flow error
        uninarySub(--n);
    }
    public static void main(String[] args) {
        one_to_n(5);
        System.out.println();
        n_to_one(5);
        System.out.println();
        uninarySub(5);
    }
}

//output
// 1 2 3 4 5 
// 5 4 3 2 1