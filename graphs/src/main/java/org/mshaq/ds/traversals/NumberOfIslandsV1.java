package org.mshaq.ds.traversals;

import java.util.LinkedList;
import java.util.Queue;


// Including the Diagonals
public class NumberOfIslandsV1 {

    public int numIslands(char[][] grid) {
        int count = 0;
        // Get size of row and column
        int rowSize = grid.length;
        int colSize = grid[0].length;

        // Create a visited 2-D array with same size
        boolean[][] visited = new boolean[rowSize][colSize];

        // Iterate individual point of 2-D grid array by validating land/water and not visitws
        // if land then it's the first point and we can apply DFS/BFS
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    bfs(i, j, visited, grid);
                }
            }
        }
        return count;
    }

    private void bfs(int i, int j, boolean[][] visited, char[][] grid) {
        // Marked visited as true for current point
        visited[i][j] = true;

        // Get size of row and column
        int rowSize = grid.length;
        int colSize = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        while (!q.isEmpty()) {
            int[] top = q.poll();
            int currRowIdx = top[0];
            int currColIdx = top[1];

            // Iterate in all the direction for a single node
            for (int deltaRIdx = -1; deltaRIdx <= 1; deltaRIdx++) {
                for (int deltaCIdx = -1; deltaCIdx <= 1; deltaCIdx++) {

                    int newRowIdx = currRowIdx + deltaRIdx;
                    int newColIdx = currColIdx + deltaCIdx;

                    // Validate the newRowIdx and newColIdx are within grid range
                    if (withInRange(newRowIdx, newColIdx, rowSize, colSize) &&
                            grid[newRowIdx][newColIdx] == '1' &&
                            !visited[newRowIdx][newColIdx]) {
                        // Mark the node as visited
                        visited[newRowIdx][newColIdx] = true;
                        // Push in queue
                        q.add(new int[]{newRowIdx, newColIdx});
                    }
                }
            }
        }

    }

    private boolean withInRange(int i, int j, int rowSize, int colSize) {
        if (i < 0 || i >= rowSize) return false;
        if (j < 0 || j >= colSize) return false;
        return true;
    }
}
