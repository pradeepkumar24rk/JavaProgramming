import java.util.Scanner;

public class CombinationNumbers {

    static boolean sum(int a[],int target,int n){
        int i=0;
        while(i<n){
            int j=i+1,sum=a[i];
            while(j<n){
                sum+=a[j];
                if(target == sum ) return false ;
                j++;
            }
            i++;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        int n=sc.nextInt(),a[]=new int[n],min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int l=a[n-1];
        for(int i=1;i<=l;i++){
            int flag=0;
            for(int j=0;j<n;j++){
                if(a[j]==i){
                    flag=1;
                    break;
                }
            }
            if(flag==0  && sum(a,i,n))
                if(min>i)
                    min=i;
        }
        System.out.println(min);
        sc.close();
    }
}


//testcase 1

//input
//4
//1 2 5 6                          3 4 --> missing elements

//output                           1+2=3 so no need to return it.
//4


//testcase 2

//input
//5
//1 2 6 7 8                          3 4 --> missing elements

//output               1+2=3 so no need to return it, here 5 is largest number so no to return it 
//4

