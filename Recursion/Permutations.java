package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    private static void permutation(String str,String ans) {
        if(str.length() == 0) {
            System.out.println(ans);
            return;
        }
        char ch = str.charAt(0);
        for(int i = 0;i<=ans.length();i++) {
            String f = ans.substring(0, i);
            String e = ans.substring(i,ans.length());
            permutation(str.substring(1), f+ch+e);
        }
    }
    
    private static ArrayList<String> permutationArrayList(String str,String ans) {
        if(str.length() == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(ans);
            return list;
        }
        char ch = str.charAt(0);
        ArrayList<String> arr = new ArrayList<>();
        for(int i = 0;i<=ans.length();i++) {
            String f = ans.substring(0, i);
            String e = ans.substring(i,ans.length());
           
           arr.addAll(permutationArrayList(str.substring(1), f+ch+e));
        }
        return arr;
    }
    
    private static int permutationCount(String str,String ans) {
        if(str.length() == 0) {
            // System.out.println(ans);
            return 1;
        }
        int count = 0;
        char ch = str.charAt(0);
        for(int i = 0;i<=ans.length();i++) {
            String f = ans.substring(0, i);
            String e = ans.substring(i,ans.length());
            count+=permutationCount(str.substring(1), f+ch+e);
        }
        return count;
    }
    
// Array Permutation
    static void permutationArray(int[] nums,List<List<Integer>> list,List<Integer> ans,int index) {
        if(index == nums.length){
            list.add(ans);
            return;
        }
        for(int i = 0;i<=ans.size();i++){
            List<Integer> temp = new ArrayList<>(ans) ;
            temp.add(i,nums[index]);
            permutationArray(nums,list,temp,index+1);
        }
    }
    public static List<List<Integer>> Arraypermute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        permutationArray(nums,list,new ArrayList<Integer>(),0);
        return list;
    }
    
    public static void main(String[] args) {
        String str = "abc";
        permutation(str,"");
        System.out.println(permutationArrayList(str,""));
        System.out.println(permutationCount("abcd",""));
        System.out.println(Arraypermute(new int[] {1,2,3}));
        
    }
}
