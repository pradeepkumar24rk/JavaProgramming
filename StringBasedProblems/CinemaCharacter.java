package StringBasedProblems;
import java.util.Scanner;

public class CinemaCharacter {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        char a[]=s.toCharArray();
        int n=a.length;
        for(int i=1;i<n;i++){
            int j=i-1;
            char temp=a[i];
            while(j>=0 && temp<a[j])
            {
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=temp;
        }
        System.out.println(String.valueOf(a));
        
        int count=1,p=0;
        char temp=a[0];
        for(int i=0;i<n-1;i++){
            if(a[i]==a[i+1])
                count++;
            else
                count=1;
            if(count>p){
                temp=a[i];
                p=count;
            }
        }
        
        System.out.println(temp);
        sc.close();
    }
}

// testcase 1

// input

// ddcccdcaaa               which character is more time appeared and less ASCII key value

// output

// c                        here c character is more time appeared





// testcase 2

//input

// aaaadddbbbb              here a and b are equal times appeared but a is less ASCII value

//output

//a