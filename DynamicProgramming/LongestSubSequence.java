//Longest Increasing Sub sequence

package DynamicProgramming;
import java.util.Arrays;
import java.util.Scanner;

public class LongestSubSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), a[] = new int[n], db[] = new int[n];
        Arrays.fill(db, 1);
        for (int i = 0; i < n; a[i++] = sc.nextInt())
            ;
        int max = 1;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j])
                    db[i] = db[i] > db[j] + 1 ? db[i] : db[j] + 1;
                max = max < db[i] ? max = db[i] : max;
            }
        System.out.println(max);
        sc.close();
    }
}


//input
//      5
//      2 1 6 4 5

// solution:
// len=1   [2] [1] [6] [4] [5]
// len =2   [2,6] [2,4] [2,5] [1,6] [1,4] [1,5] [4,5]
// len=3   [2,4,5] [1,4,5]

// output:
// 3