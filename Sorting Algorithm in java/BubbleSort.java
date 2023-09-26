public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = { 4, 1, 3, 9, 7 };
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int k = n;
            for (int j = 0; j < k - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            k--;
        }
        for (int i = 0; i < n; i++)
            System.out.println(arr[i]);

    }
}

// Example

// arr[]={23,17,2,15,6}

// soln:

// step1:
// arr[]={17,2,15,6,23}

// step2:
// arr[]={2,15,6,17,23}

// step3:
// arr[]={2,15,6,17,23}

// step4:
// arr[]={2,6,15,17,23}
