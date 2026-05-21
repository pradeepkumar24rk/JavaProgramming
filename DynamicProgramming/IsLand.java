package DynamicProgramming;

import java.util.ArrayList;

public class IsLand {

    public static void main(String[] args) {
        ArrayList<String> visited = new ArrayList<>();
        Character[][] island = {
                { 'W', 'L', 'L', 'W' },
                { 'W', 'L', 'W', 'W' },
                { 'W', 'W', 'W', 'W' },
                { 'W', 'W', 'L', 'W' }
        };
        int landCount = 0, row = island.length, col = island[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (exploreIsLand(island, i, j, visited))
                    landCount += 1;
            }
        }
        System.out.println("Number of IsLand: " + landCount);
    }

    static boolean exploreIsLand(Character[][] island, int row, int col, ArrayList<String> visited) {
        String key = row + "," + col;
        boolean rowBound = row >= 0 && row < island.length;
        boolean colBound = col >= 0 && col < island[0].length;
        if (!rowBound || !colBound)
            return false;

        if (visited.contains(key)) {
            return false;
        }

        visited.add(key);

        if (island[row][col] == 'W')
            return false;

        exploreIsLand(island, row + 1, col, visited);
        exploreIsLand(island, row - 1, col, visited);
        exploreIsLand(island, row, col + 1, visited);
        exploreIsLand(island, row, col - 1, visited);

        return true;

    }
}
