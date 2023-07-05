package StringBasedProblems;

//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class beautifulString {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            String box[] = new String[n];
            for (int i = 0; i < n; i++)
                box[i] = br.readLine().trim();
            ot.println(new Solution().noOfPairs(box));
        }
        ot.close();
    }

}
// } Driver Code Ends

class Solution {

    public static boolean checkOdd(HashMap<Character, Integer> map) {
        int flag = 0;
        for (Map.Entry<Character, Integer> m : map.entrySet())
            if (((int) m.getValue() % 2) != 0) {
                flag++;
            }
        if (flag <= 1)
            return true;
        return false;
    }

    public static boolean checkEven(HashMap<Character, Integer> map) {
        int flag = 0;
        for (Map.Entry<Character, Integer> m : map.entrySet())
            if (((int) m.getValue() % 2) == 0)
                flag++;
        if (flag == map.size() - 1 || flag == map.size())
            return true;
        return false;
    }

    public static boolean check(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            else
                map.put(s.charAt(i), 1);
        }
        System.out.println(map);
        if (checkOdd(map) && checkEven(map))
            return true;
        return false;
    }

    public long noOfPairs(String box[]) {
        // Code Here.
        int n = box.length;
        long count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                String s = box[i] + box[j];
                System.out.println(s);
                // if(check(s))
                // count++;
            }
        }
        return count;
    }
}