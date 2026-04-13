package ArrayBasedProblems;

public class subset {
    public static void main(String[] args) {
      // System.out.println("Hello, World!");
      int a[]={1,2,3};
      for(int i=0;i<a.length;i++){
        String s="";
        int k=1;
        while(k<a.length){
            
            for(int j=i;j<k;j++)
            {
              s+=a[j]+" ";
            }
            k++;
            System.out.println();
        }
        System.out.print(s);
      }
  }
}

// Explaination of problem:
// Given an integer array nums of unique elements, return all possible subsets (the power set).
// The solution set must not contain duplicate subsets. The subsets can be returned in any order.




// output

// 1 1 2 

// 2 