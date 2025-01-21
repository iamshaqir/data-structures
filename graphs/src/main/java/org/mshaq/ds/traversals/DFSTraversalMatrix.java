package org.mshaq.ds.traversals;

import java.util.ArrayList;
import java.util.List;

public class DFSTraversalMatrix {

    private int rowSize;
    private int columnSize;

    public List<Integer> dfs(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] visited = new boolean[r][c];
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfsHelper(i, j, visited, grid, res);
                }
            }
        }
        return res;
    }

    private void dfsHelper(int r, int c, boolean[][] visited, int[][] grid, List<Integer> res) {
        if (!isWithinRange(r, c) || grid[r][c] != 1 || visited[r][c]) {
            return;
        }
        visited[r][c] = true;
        res.add(grid[r][c]);
        dfsHelper(r - 1, c, visited, grid, res); // up
        dfsHelper(r + 1, c, visited, grid, res); // down
        dfsHelper(r, c - 1, visited, grid, res); // left
        dfsHelper(r, c + 1, visited, grid, res); // right
    }

    private boolean isWithinRange(int r, int c) {
        return r >= 0 && r < rowSize && c >= 0 && c < columnSize;
    }
}
