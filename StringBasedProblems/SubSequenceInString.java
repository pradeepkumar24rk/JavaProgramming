package StringBasedProblems;
public class SubSequenceInString {
    public static void main(String[] args) {
        String s="abcd";
        int n=s.length(),total=(1<<n)-1;
        for(int i=1;i<=total;i++){
            int target=i,j=0;
            while(target!=0){
                if((target&1)==1)
                    System.out.print(s.charAt(j)+" ");
                j++;
                target>>=1;
            }
            System.out.println();
        }
    }
}
