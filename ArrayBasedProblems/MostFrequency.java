package ArrayBasedProblems;
import java.util.*;

public class MostFrequency {
    public static void main(String[] args) {
        int arr[] = {2,2,2,2,1,1,1,4,4};
        int resV =0,res=0;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i:arr) {
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            } else
                map.put(i,1);
        }
        System.out.println(map);
        for(Map.Entry<Integer,Integer> m:map.entrySet()) {
            int val = (int)m.getValue();
            int key = (int)m.getKey();
            if(resV<val){
                resV = val;
                res = key;  
            }
        }
        System.out.println(res);
    }
}
