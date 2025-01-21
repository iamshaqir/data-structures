package org.mshaq.ds.traversals;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/number-of-enclaves/">1020. Number of Enclaves</a>
 */
public class NumberOfEnclaves {

    private int rowSize, columnSize;

    public int numEnclaves(int[][] grid) {
        this.rowSize = grid.length;
        this.columnSize = grid[0].length;
        boolean[][] visited = new boolean[rowSize][columnSize];
        Queue<int[]> q = addBoundaries(grid, visited);
        markVisited(grid, q, visited);
        return count(grid, visited);
    }

    private int count(int[][] grid, boolean[][] visited) {
        int count = 0;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    private void markVisited(int[][] grid, Queue<int[]> q, boolean[][] visited) {
        final int[] offset = {0, 1, 0, -1, 0};

        // Mark all lands connected to boundaries as visited
        while (!q.isEmpty()) {
            int[] top = q.poll();
            for (int i = 0; i < 4; i++) {
                int newRow = top[0] + offset[i];
                int newColumn = top[1] + offset[i + 1];
                if (isWithInRange(newRow, newColumn) &&
                        grid[newRow][newColumn] == 1 &&
                        !visited[newRow][newColumn]) {
                    visited[newRow][newColumn] = true;
                    q.add(new int[]{newRow, newColumn});
                }
            }
        }
    }

    private Queue<int[]> addBoundaries(int[][] grid, boolean[][] visited) {
        // Add the boundary lands to Queue
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                if ((i == 0 || i == rowSize - 1 ||
                        j == 0 || j == columnSize - 1) &&
                        grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        return queue;
    }

    private boolean isWithInRange(int newRow, int newColumn) {
        return newRow >= 0 && newRow < rowSize && newColumn >= 0 && newColumn < columnSize;
    }

    public int numEnclaves_(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int enclaves = 0;

        for (int i = 0; i < m; i++) {
            dfs(i, 0, m, n, grid, visited);
            dfs(i, n - 1, m, n, grid, visited);
        }
        for (int j = 0; j < n; j++) {
            dfs(0, j, m, n, grid, visited);
            dfs(m - 1, j, m, n, grid, visited);
        }
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    enclaves++;
                }
            }
        }
        return enclaves;
    }

    private void dfs(int i, int j, int m, int n, int[][] grid, boolean[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        dfs(i + 1, j, m, n, grid, visited);
        dfs(i - 1, j, m, n, grid, visited);
        dfs(i, j + 1, m, n, grid, visited);
        dfs(i, j - 1, m, n, grid, visited);
    }
}
