package org.mshaq.ds.traversals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfDistinctIslands {

    private int nr;
    private int nc;

    private static final int[] DIRECTION_OFFSET = {0, 1, 0, -1, 0};

    public int countDistinctIslands(int[][] grid) {
        this.nr = grid.length;
        this.nc = grid[0].length;

        boolean[][] visited = new boolean[nr][nc];
        Set<List<String>> noOfIslands = new HashSet<>();
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    List<String> landList = new ArrayList<>();
                    dfs(i, j, grid, visited, i, j, landList);
                    noOfIslands.add(landList);
                }
            }
        }
        return noOfIslands.size();
    }

    private void dfs(int r, int c,
                     int[][] grid, boolean[][] visited,
                     int baseRow, int baseColumn,
                     List<String> landList) {
        landList.add((r - baseRow) + "," + (c - baseColumn));
        for (int i = 0; i < 4; i++) {
            int newRow = r + DIRECTION_OFFSET[i];
            int newColumn = c + DIRECTION_OFFSET[i + 1];
            if (isInRange(newRow, newColumn) &&
                    grid[newRow][newColumn] == 1 &&
                    !visited[newRow][newColumn]) {
                visited[newRow][newColumn] = true;
                dfs(newRow, newColumn,
                        grid, visited,
                        baseRow, baseColumn,
                        landList);
            }
        }

    }

    private boolean isInRange(int row, int column) {
        return row >= 0 && row < nr &&
                column >= 0 && column < nc;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}
        };

        int ans = new NumberOfDistinctIslands().countDistinctIslands(grid);

        System.out.println("The count of distinct islands in the given grid is: " + ans);
    }
}
