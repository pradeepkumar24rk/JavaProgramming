//time complexity is O(n)

package SearchingAlgorithm;

import java.util.ArrayList;

public class LinearSearch {

    static String linearSearch(int a[],int n,int t){
        for(int i=0;i<n;i++)
            if(a[i]==t)
                return "Founded";
        return "NotFounded";
    }
    
    static boolean recursiveLinearSearch(int a[],int index, int target) {
        if(index == a.length-1)
            return false;
        return a[index]==target || recursiveLinearSearch(a, index+1, target);
    }
    
    
    //Example a[] = {1,23,5,5,10}
    static int recursiveLinearSearchForward(int a[],int index, int target) {
        if(index == a.length-1)
            return -1;
        if(a[index]==target)
            return index;
        return recursiveLinearSearchForward(a, index+1, target);
    } //it return index as 2
    static int recursiveLinearSearchBackward(int a[],int index, int target) {
        if(index == -1)
            return -1;
        if(a[index]==target)
            return index;
        return recursiveLinearSearchBackward(a, index-1, target);
    } //it return index as 3
    
    // if we have multiple occurs in search array if you need two value index added in the new array list
    
    static ArrayList<Integer> recursiveLinearSearchFindMultipleIndex1(int a[],int index,int target, ArrayList<Integer> list) {   //optimized function for multiple index with arraylist
        if(index == -1)
            return list;
        if(a[index]==target)
            list.add(index);
        return recursiveLinearSearchFindMultipleIndex1(a, index-1, target,list);
    }
    static ArrayList<Integer> recursiveLinearSearchFindMultipleIndex2(int a[],int index,int target) {  // It is not optimized
        ArrayList<Integer> list = new ArrayList<>();
        if(index == -1)
            return list;
        if(a[index]==target)
            list.add(index);
        list.addAll(recursiveLinearSearchFindMultipleIndex2(a, index-1, target));
        return list;
    }
    
    public static void main(String[] args) {
        int a[]={11,3,55,55,6,7,355,77};
        int target=55;
        int n=a.length;
        System.out.println(linearSearch(a,n,target));
        System.out.println(recursiveLinearSearch(a,0,target));
        System.out.println(recursiveLinearSearchForward(a,0,target));
        System.out.println(recursiveLinearSearchBackward(a,n-1,target));
        
        ArrayList<Integer> arr = new ArrayList<>();
        System.out.println(recursiveLinearSearchFindMultipleIndex1(a,n-1,target,arr));
        System.out.println(arr); //both return same because in previous call it send only reference many reference for single object.
        
        System.out.println(recursiveLinearSearchFindMultipleIndex2(a,n-1,target));
    }
}
