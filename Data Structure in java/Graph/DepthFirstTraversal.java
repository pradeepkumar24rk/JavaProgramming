package Graph;

import java.util.*;

public class DepthFirstTraversal {
    
    static void dft(HashMap<Integer, List<Integer>> graph,int source) {
        System.out.print(source+" ");
        for(int neighbour:graph.get(source)) {
            dft(graph,neighbour);
        }
    } // it work based on the principle of stack. It first visit the source node and then it visit the neighbour of the source node and then it visit the neighbour of the neighbour node and so on. It will visit all the nodes in the graph. It will not visit the same node twice as it will not have any neighbour to visit after visiting it once. It will visit all the nodes in the graph in a depth first manner.
    
    static void dftIterative(HashMap<Integer, List<Integer>> graph,int source) {
      List<Integer> stack = new ArrayList<>();
      stack.add(source);
      while(!stack.isEmpty()) {
        int current = stack.remove(stack.size()-1);
        System.out.print(current+" ");
        for(int neg: graph.get(current)) {
          stack.add(neg);
        }
      }
    }

    public static void main(String[] args) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList( 3));
        graph.put(2, Arrays.asList(4));
        graph.put(3, Arrays.asList());
        graph.put(4, Arrays.asList());
        System.out.println("Recursive DFT:");
        dft(graph, 0);
        System.out.println("\nIterative DFT:");
        dftIterative(graph, 0);

    }

}

// Example graph:
// 0 ---> 1
// |      |
// v      v
// 2      3
// |
// v      
// 4

