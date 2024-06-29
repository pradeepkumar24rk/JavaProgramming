public class InsertionSort {
    public static void main(String[] args) {
        int a[] = { 3, 5, 2, 4, 1 };
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int j = i - 1;
            while (j >= 0 && temp < a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = temp;
        }
        
        for(int i=0;i<a.length;i++) {
            System.out.println(a[i]);
        }
    }
}
