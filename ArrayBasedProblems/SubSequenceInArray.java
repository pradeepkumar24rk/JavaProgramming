package ArrayBasedProblems;

import java.util.ArrayList;

public class SubSequenceInArray {

    private static void bitSubSequence() { // time complexity - o(2^n)
        int a[] = { 1, 2, 3 }, n = a.length, total = (1 << n) - 1;
        System.out.println("Total number of subSequence :" + total);

        for (int i = 1; i <= total; i++) {
            int target = i, j = 0;
            String b = "";
            while (target != 0) {
                if ((target & 1) == 1) {
                    b += String.valueOf(a[j]) + " ";
                }
                j++;
                target >>= 1;
            }
            System.out.println(b);
        }
    }

    private static void listSubSequence() { // time complexity - o(n*2^n) duplication not allow
        int nums[] = { 1, 2, 3 };
        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int i : nums) {
            int n = outer.size();
            for (int j = 0; j < n; j++) {
                ArrayList<Integer> inter = new ArrayList<>(outer.get(j));
                inter.add(i);
                outer.add(inter);
            }
        }
        System.out.println(outer);
    }

    private static void listSubSequenceDuplicate() { // time complexity - o(n*2^n) with duplication allow
        int nums[] = { 1, 2, 2 };
        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start = 0, end = 0;
        for (int i = 0; i < nums.length; i++) {
            start = 0;
            if (i > 0 && nums[i] == nums[i - 1])
                start = end + 1;
            end = outer.size() - 1;
            int n = outer.size();
            for (int j = 0; j < n; j++) {
                ArrayList<Integer> inter = new ArrayList<>(outer.get(j));
                inter.add(nums[i]);
                outer.add(inter);
            }
        }
        System.out.println(outer);
    }

    private static void targetSumSubSequence() {
        int a[] = { 5, 3, 1, 6, 2 }, sumOfSquence = 6, n = a.length, total = (1 << n) - 1, count = 0;
        System.out.println("Total number of subSequence :" + total);

        for (int i = 1; i <= total; i++) {
            int target = i, sum = 0, j = 0;
            String b = "";
            while (target != 0) {
                if ((target & 1) == 1) {
                    sum += a[j];
                    b += String.valueOf(a[j]) + " ";
                }
                j++;
                target >>= 1;
            }
            if (sum == sumOfSquence) {
                System.out.println(b);
                count++;
            }
        }
        System.out.println("Number of Subsequence equal to sumOfSquence Given :" + count);
    }

    public static void main(String[] args) {
        bitSubSequence();
        listSubSequence();
        listSubSequenceDuplicate();
    }
}
