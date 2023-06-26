//time complexity O(n3) cubic

public class LargestSumContiguousSubarray {

    static int Sum(int i, int j, int a[]) {
        int sum = 0;
        for (int k = i; k <= j; k++)
            sum += a[k];
        return sum;
    }

    public static void main(String[] args) {
        int arr[] = { -2, -3, 4, -1, -2, 1, 5, -3 }, n = arr.length;
        int i = 0, max = Integer.MIN_VALUE;
        while (i < n - 1) {
            int j = i + 1;
            while (j < n) {
                int sum = Sum(i, j, arr);
                if (max < sum) {
                    max = sum;
                }
                j++;
            }
            i++;
        }
        System.out.println(max);
    }
}
