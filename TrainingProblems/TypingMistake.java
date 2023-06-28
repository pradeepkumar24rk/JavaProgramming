import java.util.*;

public class TypingMistake {
    // static String check(String s, String o){
    //     HashMap<Character,Integer> map1=new HashMap<Character,Integer>();
    //         for(int i=0;i<s.length();i++)
    //             if(map1.containsKey(s.charAt(i)))
    //                 map1.put(s.charAt(i),map1.get(s.charAt(i))+1);
    //             else
    //                 map1.put(s.charAt(i),1);
                    
    //         //the output is return by ai
            
    //         HashMap<Character,Integer> map2=new HashMap<Character,Integer>();
    //         for(int i=0;i<o.length();i++)
    //             if(map2.containsKey(o.charAt(i)))
    //                 map2.put(o.charAt(i),map2.get(o.charAt(i))+1);
    //             else
    //                 map2.put(o.charAt(i),1);
    //         System.out.println(map2);
    //         System.out.println(map1);
    //         int flag=0;
    //         for(Map.Entry<Character,Integer> m:map1.entrySet()){
    //             for(Map.Entry<Character,Integer> m1:map2.entrySet()){
    //                 if(((m.getKey()==m1.getKey()) && (m.getValue()<=m1.getValue()))){
    //                     flag+=1;
    //                     break;
    //                 }
                    
    //             }
    //         }
    //         return flag==map1.size() ?"Yes" :"No";
    //     }
    //     public static void main(String[] args) {
    //          Scanner sc=new Scanner(System.in);
    //         int t=sc.nextInt();
    //         while(t-->0){
    //             //the ouput should be
    //         String s=sc.next();
    //         String o=sc.next();
    //         System.out.println(check(s,o));
            
    //    }
    //    sc.close();
    // }
    
    
    static String check(StringBuffer s,StringBuffer o){
        
        for(int i=0;i<s.length();i++)
        {
            int flag=0;
            for(int j=0;j<o.length();j++)
                if(s.charAt(i)==o.charAt(j)){
                    System.out.println(s.charAt(i));
                    o.deleteCharAt(j);
                    flag=1;
                    break;
                }
            if(flag==0)    
                return "No";
        }
        return "Yes";
    } 
    
    public static void main(String[] args) {
             Scanner sc=new Scanner(System.in);
            int t=sc.nextInt();
            sc.nextLine();
            while(t-->0){
                //the ouput should be
            StringBuffer s=new StringBuffer(sc.nextLine());
            StringBuffer o=new StringBuffer(sc.nextLine());
            
            System.out.println(s+" "+o);
            System.out.println(check(s, o));
            
            }
       sc.close();
    }
}
