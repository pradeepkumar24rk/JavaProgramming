package Graph;

import java.util.*;
public class BreathFirstTraversal {

    static void bft(HashMap<Integer, List<Integer>> graph,int source) {
        List<Integer> queue = new ArrayList<>();
        queue.add(source);
        while(!queue.isEmpty()) {
            int current = queue.remove(0);
            System.out.print(current+" ");
            for(int neg: graph.get(current)) {
                queue.add(neg);
            }
        }
    } // it work based on the principle of queue. It first visit the source node and then it visit the neighbour of the source node and then it visit the neighbour of the neighbour node and so on. It will visit all the nodes in the graph. It will not visit the same node twice as it will not have any neighbour to visit after visiting it once. It will visit all the nodes in the graph in a breath first manner.

    public static void main(String[] args) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList( 3));
        graph.put(2, Arrays.asList(4));
        graph.put(3, Arrays.asList());
        graph.put(4, Arrays.asList());
        System.out.println("Breath First Traversal:");
        bft(graph, 0);
    }
}
