package BasicJavaProblems;

public class MaxRepeatedNumber {
    public static void main(String[] args) {
        int a[] = { 5, 1, 2, 6, 2, 5 }, max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++)
            if (max < a[i])
                max = a[i];
        // System.out.println(max);
        int b[] = new int[max + 1];

        for (int i = 0; i < a.length; i++) {
            b[a[i]]++;
        }

        System.out.println("Counted :");
        for (int i : b)
            System.out.print(+i + " ");

        System.out.println();
        int MaxRepeatedNumberMin = 0, min = 0;
        for (int i = 0; i < b.length; i++) {
            if (MaxRepeatedNumberMin < b[i]) {
                MaxRepeatedNumberMin = b[i];
                min = i;
            }
        }
        System.out.println("MaxRepeatedNumberMin " + min);
    }
}
