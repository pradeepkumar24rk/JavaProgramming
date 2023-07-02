package ArrayBasedProblems;

import java.util.Arrays;

public class OddposdescEvenposAsc {
    public static void main(String[] args) {
        int a[]={2, 5, 3, 6},n=a.length,b[]=new int[n];
        int j=0,l=n/2;
        for(int i=0;i<n;i++){
            if(i%2!=0){
                b[j++]=a[i];
            }
            
            if(i%2==0)
                b[l++]=a[i];
        }
    
        for(int i=0;i<n-1;i++){
            for(int k=i+1;k<n;k++){
            
                if(b[i]<b[k] && i<n/2)
                {
                    int temp=b[i];
                    b[i]=b[k];
                    b[k]=temp;
                }
                
            
                if(b[i]>b[k] && i>=n/2)
                {
                    int temp=b[i];
                    b[i]=b[k];
                    b[k]=temp;
                }
            }
        }
        
                    System.out.println(Arrays.toString(b));
    }
}
