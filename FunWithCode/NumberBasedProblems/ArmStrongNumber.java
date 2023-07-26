//Armstrong Number is a positive number if it is equal to the sum of cubes of its digits is called Armstrong number and if its sum is not equal to the number then its not a Armstrong number. Armstrong Number Program is very popular in java, c language, python etc. Examples: 153 is Armstrong, (1*1*1)+(5*5*5)+(3*3*3) = 153


package NumberBasedProblems;

public class ArmStrongNumber {
        public static void main(String[] args) {
            int num=153,temp=num;
            String s=num+"";
            int n=s.length(),sum=0;
            while(num!=0){
                int u=1;
                for(int i=0;i<n;i++)
                    u*=num%10;
                sum+=u;
                num/=10;
            }
            System.out.println(sum==temp?"True":"False");
            
        }
}
