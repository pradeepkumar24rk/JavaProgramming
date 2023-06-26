//time complexity is O(n)

package SearchingAlgorithm;

public class LinearSearch {

    static String linearSearch(int a[],int n,int t){
        for(int i=0;i<n;i++)
            if(a[i]==t)
                return "Founded";
        return "NotFounded";
    }
    public static void main(String[] args) {
        int a[]={11,3,55,6,7,355,77};
        int target=15;
        int n=a.length;
        System.out.println(linearSearch(a,n,target));
    }
}
