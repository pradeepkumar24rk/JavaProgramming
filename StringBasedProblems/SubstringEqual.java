//comparing two substring and return max length of substring which is equal

package StringBasedProblems;

public class SubstringEqual {

    static String substring(char[] c,int i,int j){
        String s="";
        for(int k=i;k<j;k++)
            s+=c[k];
        return s;
        
    } 
    public static void main(String[] args) {
        String s2="string",s1="asdfestrderingl";
        char[] c1=s1.toCharArray(),c2=s2.toCharArray();
        // int i=0,max=0;
        // while(i<c1.length-1){
        //     int j=i+1;
        //     while(j<=c2.length){
        //         int flag=0,k=0;
        //         String r1=substring(c1, i, j);
        //         while(k<c2.length-1){
        //             int l=k+1;
        //             while(l<=c2.length){
        //                 String r2=substring(c2, k, l);
        //                 if(r1.equals(r2)){
        //                     int len=r1.length();
        //                     if(max<len)
        //                         max=len;
        //                     flag=1;
        //                     break;
        //                 }
        //                 l++;
        //             }
        //             if(flag==1)
        //                 break;
        //             k++;
        //         }
        //         j++;
        //     }
        //     i++;
        // }
        
        // System.out.println(max);
        
        
        
        
        int i=0,max=0;
        while(i<c1.length){
            int j=0,k=i;
            while(j<c2.length)
            {
                int count=0;
                
                while( j<c2.length && i<c1.length && c1[k]==c2[j]){
                System.out.print(c1[k]);
                    k++;
                    j++;
                    count++;
                    if(j>=c2.length || i>=c1.length)
                        break;
                    // flag=1;
                }
                k=i;
                j++;
                if(count >0)
                System.out.print(count);
               if(max<count)
                max=count;
            }
            i++;
            // System.out.println(count);
            
        }
        System.out.print(max);
        
        
        // int max=0;
        // for(int i=0;i<c1.length;i++){
        // int count=0;
        //     for(int j=i;j<c2.length;j++){
        //         if(c1[j]==c2[j])
        //             count++;
        //     }
        //     if(count>max)
        //         max=count;
        // }
        // System.out.println(max);
        
    }
}




//input

//s2="string",s1="asdfestrderingl";

//output


//sub   len

// s    ->1
// str  ->3
//tr    ->2
//r     ->1
//ring  ->4
//ing   ->3
//ng    ->2
//g     ->1

// max=4