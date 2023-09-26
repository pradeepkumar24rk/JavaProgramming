package NumberBasedProblems;
import java.util.*;

public class UnstableNumber {
    public static void main(String[] args) {
        int in[]={1313,12,122,678,898};
        
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<in.length;i++){
            HashMap<Character,Integer> map=new HashMap<Character,Integer>();
            String s=in[i]+"";
            // System.out.println();
            char c[]=s.toCharArray();
            // System.out.println(c[1]);
            for(int j=0;j<c.length;j++){
                if(map.containsKey(c[j]))
                    map.put(c[j],map.get(c[j])+1);
                else
                    map.put(c[j],1);
            }
            // System.out.println(map);
            Set<Integer> values = new HashSet<>(map.values());
            boolean allValuesSame = values.size() == 1;
            // System.out.println(allValuesSame);
            if(!allValuesSame)
                list.add(in[i]);
                
        }
        Collections.sort(list);
        // System.out.println(list);
        System.out.println(list.get(list.size()-1)+list.get(0));
    }
}
