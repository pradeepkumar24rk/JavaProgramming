package Graph;


import java.util.*;

public class undirectedPath {
  
    static boolean hasPathBft(HashMap<Character, List<Character>> graph, Character src, Character des) {
      List<Character> queue = new ArrayList<>();
      queue.add(src);
      HashMap<Character, Boolean> memo = new HashMap<>();
      memo.put(src,false);
      while(queue.size()!=0) {
        Character current = queue.remove(0);
        if(current == des ){
          return true;
        }
        if(memo.get(current)!=null && memo.get(current)) continue;
        memo.put(current,true);
        for(Character neg: graph.get(current)) {
          queue.add(neg);
        }
      }
      return false;
    }
    
    static boolean hasPathDft(HashMap<Character, List<Character>> graph, Character src, Character des) {
      List<Character> queue = new ArrayList<>();
      queue.add(src);
      HashMap<Character, Boolean> memo = new HashMap<>();
      memo.put(src,false);
      while(queue.size()!=0) {
        Character current = queue.remove(queue.size()-1);
        if(current == des ){
          return true;
        }
        if(memo.get(current)!=null && memo.get(current)) continue;
        memo.put(current,true);
        System.out.print(current+" ");
        for(Character neg: graph.get(current)) {
          queue.add(neg);
        }
      }
      return false;
    }
    
    static boolean hasPathDftRecusion(HashMap<Character, List<Character>> graph, Character src, Character des, HashSet<Character> memo) {
      if(src==des) {
        return true;
      }
      
      if(memo.contains(src)) return false;
      memo.add(src);
      for(Character neg: graph.get(src)) {
        if(hasPathDftRecusion(graph,neg,des,memo)) {
          return true;
        }
      }
      return false;
      
    }
  
    public static void main(String[] args) {
        HashMap<Character, List<Character>> graph = new HashMap<>();
        graph.put('i', Arrays.asList('j', 'k'));
        graph.put('j', Arrays.asList('i'));
        graph.put('k', Arrays.asList('i', 'm','l'));
        graph.put('m', Arrays.asList('k'));
        graph.put('l', Arrays.asList('k'));
        graph.put('o', Arrays.asList('n'));
        graph.put('n', Arrays.asList('o'));

        System.out.println("Has Path DFT: "+hasPathDft(graph, 'i', 'm'));
        System.out.println("Has Path DFT: "+hasPathDftRecusion(graph, 'i', 'm',new HashSet<Character>()));
        System.out.println("Has Path BFT: "+hasPathBft(graph, 'k', 'n'));
    }
}
