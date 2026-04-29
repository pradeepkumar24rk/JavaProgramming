package Graph;

import java.util.*;

public class ShortestPath {
    public static int shortestPath(Map<Character, List<Character>> graph, Character src, Character des,
            List<Character> memo) {
        Map<Character, Integer> dist = new HashMap<>();
        List<Character> queue = new ArrayList<>();
        dist.put(src, 0);
        queue.add(src);
        while (!queue.isEmpty()) {
            Character currentNode = queue.remove(0);
            if (memo.contains(currentNode))
                continue;
            memo.add(currentNode);
            for (Character neg : graph.get(currentNode)) {
                int newDistance = dist.get(currentNode) + 1;
                if (neg == des) {
                    return newDistance;
                }
                queue.add(neg);
                dist.put(neg, newDistance);

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('V', new ArrayList<>(Arrays.asList('W', 'Y')));
        graph.put('W', new ArrayList<>(Arrays.asList('X', 'V')));
        graph.put('Y', new ArrayList<>(Arrays.asList('Z', 'V')));
        graph.put('X', new ArrayList<>(Arrays.asList('Z', 'W')));
        graph.put('Z', new ArrayList<>(Arrays.asList('Y', 'X')));
        // Map<Character,Integer> memo = new HashMap<>();
        List<Character> memo = new ArrayList<>();
        System.out.println(shortestPath(graph, 'V', 'Z', memo));

    }
}
