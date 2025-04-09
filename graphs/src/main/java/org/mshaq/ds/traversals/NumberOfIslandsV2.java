package org.mshaq.ds.traversals;


import java.util.LinkedList;
import java.util.Queue;

// Excluding the diagonals
public class NumberOfIslandsV2 {

    private int rowSize;
    private int colSize;

    public int numIslands(char[][] grid) {
        int count = 0;
        // Get size of row and column
        rowSize = grid.length;
        colSize = grid[0].length;

        // Create aset visited 2-D array with same size
        boolean[][] visited = new boolean[rowSize][colSize];

        // Iterate individual point of 2-D grid array by validating land/water and not visit
        // if land then it's the first point, and we can apply DFS/BFS
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
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        while (!q.isEmpty()) {
            int[] top = q.poll();
            int currRowIdx = top[0];
            int currColIdx = top[1];
            int[] offset = {0, 1, 0, -1, 0};
            // Iterate in all the direction for aset single node
            for (int k = 0; k < 4; k++) {
                int newRowIdx = currRowIdx + offset[k];
                int newColIdx = currColIdx + offset[k + 1];

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

    private boolean withInRange(int i, int j, int rowSize, int colSize) {
        if (i < 0 || i >= rowSize || j < 0 || j >= colSize) return false;
        return true;
    }

    private void dfs(int i, int j, boolean[][] visited, char[][] grid) {
        if (!withInRange(i, j, rowSize, colSize) || grid[i][j] == 0 || visited[i][j]) return;
        visited[i][j] = true;
        dfs(i + 1, j, visited, grid);
        dfs(i - 1, j, visited, grid);
        dfs(i, j + 1, visited, grid);
        dfs(i, j - 1, visited, grid);
    }
}
