package Graph;
import java.util.*;

public class CountComponent {
   public static int connectedComponentsCount(Map<Integer, List<Integer>> graph) {
    int count = 0;
    List<Integer> memo = new ArrayList<>();
    for(int key: graph.keySet()) {
      if(memo.contains(key)) continue;
      count += dtp(graph,memo,key);
    }
    // System.out.println(count);
    return count;
  }

  public static int dtp(Map<Integer, List<Integer>> graph,List<Integer> memo,int src) {
    List<Integer> stack = new ArrayList<>();
    stack.add(src);
    while(!stack.isEmpty()) {
      int current = stack.remove(stack.size()-1);
      if(memo.contains(current)) continue;
      memo.add(current);
      for(int neg: graph.get(current)) {
        stack.add(neg);
      }
    }
    return 1;
  }
    
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, new ArrayList<>(Arrays.asList(8, 1, 5)));
        graph.put(1, new ArrayList<>(Arrays.asList(0)));
        graph.put(5, new ArrayList<>(Arrays.asList(0, 8)));
        graph.put(8, new ArrayList<>(Arrays.asList(0, 5)));
        graph.put(2, new ArrayList<>(Arrays.asList(3, 4)));
        graph.put(3, new ArrayList<>(Arrays.asList(2, 4)));
        graph.put(4, new ArrayList<>(Arrays.asList(3, 2)));

        System.out.println("Count of component is : " + connectedComponentsCount(graph));
    }
}