//time complexity is O(n)

package SearchingAlgorithm;

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
    
    public static void main(String[] args) {
        int a[]={11,3,55,55,6,7,355,77};
        int target=55;
        int n=a.length;
        System.out.println(linearSearch(a,n,target));
        System.out.println(recursiveLinearSearch(a,0,target));
        System.out.println(recursiveLinearSearchForward(a,0,target));
        System.out.println(recursiveLinearSearchBackward(a,n-1,target));
    }
}
