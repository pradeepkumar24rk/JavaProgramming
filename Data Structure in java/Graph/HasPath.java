package Graph;
import java.util.*;

public class HasPath {
    public static void main(String[] args) {
        HashMap<Character, List<Character>> graph = new HashMap<>();
        graph.put('a', Arrays.asList('b', 'c'));
        graph.put('b', Arrays.asList('d','c'));
        graph.put('d', Arrays.asList());
        graph.put('c', Arrays.asList('e'));
        graph.put('e', Arrays.asList());
        System.out.println("Has Path DFT: "+hasPathDft(graph, 'a', 'e'));
        System.out.println("Has Path BFT: "+hasPathBft(graph, 'a', 'e'));
      
    }
    
    static boolean hasPathDft(HashMap<Character, List<Character>> graph, Character src, Character dest) {
      if(src == dest) {
        return true;
      }
      
      for(Character neg: graph.get(src)) {
        if(hasPathDft(graph,neg,dest)) {
          return true;
        } 
      }
      return false;
    }
    
    static boolean hasPathBft(HashMap<Character, List<Character>> graph, Character src, Character dest) {
      List<Character> queue = new ArrayList<>();
      queue.add(src);
      while(queue.size()!=0) {
        Character current = queue.remove(0);
        if(current == dest) {
          return true;
        }
        for(Character neg: graph.get(current)) {
          queue.add(neg);
        }
      }
      return false;
    }
    
    
}
