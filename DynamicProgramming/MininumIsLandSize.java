package DynamicProgramming;

import java.util.ArrayList;

public class MininumIsLandSize {
    public static void main(String[] args) {
        ArrayList<String> visited = new ArrayList<>();
        Character[][] island = {
                { 'W', 'L', 'L', 'W' },
                { 'W', 'L', 'W', 'W' },
                { 'W', 'W', 'W', 'W' },
                { 'W', 'W', 'L', 'W' }
        };
        int minLandSize = Integer.MAX_VALUE, row = island.length, col = island[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int newLandSize = exploreIsLand(island, i, j, visited);
                // System.err.println(newLandSize);
                if (newLandSize != 0 && minLandSize > newLandSize) {
                    System.err.println("Island Size: "+newLandSize);
                    minLandSize = newLandSize;
                }

            }
        }
        System.out.println("Minimum of IsLand: " + minLandSize);
    }

    static int exploreIsLand(Character[][] island, int row, int col, ArrayList<String> visited) {
        String key = row + "," + col;
        boolean rowBound = row >= 0 && row < island.length;
        boolean colBound = col >= 0 && col < island[0].length;
        if (!rowBound || !colBound)
            return 0;

        if (visited.contains(key)) {
            return 0;
        }

        visited.add(key);

        if (island[row][col] == 'W')
            return 0;

        int count = 1;
        count += exploreIsLand(island, row + 1, col, visited);
        count += exploreIsLand(island, row - 1, col, visited);
        count += exploreIsLand(island, row, col + 1, visited);
        count += exploreIsLand(island, row, col - 1, visited);

        return count;

    }
}
