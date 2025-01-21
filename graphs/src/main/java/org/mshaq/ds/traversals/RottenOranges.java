package org.mshaq.ds.traversals;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public int orangesRotting(int[][] grid) {
        int rowSize = grid.length;
        int columnSize = grid[0].length;
        int freshOranges = 0;
        int[][] visited = new int[rowSize][columnSize];
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    visited[i][j] = 2;
                }

                if (grid[i][j] == 1) {
                    freshOranges += 1;
                }
            }
        }
        int count = 0;
        int totalTime = 0;
        int[] offset = {0, 1, 0, -1, 0};
        while (!q.isEmpty()) {
            Pair top = q.poll();
            totalTime = Math.max(totalTime, top.time);
            for (int i = 0; i < 4; i++) {
                int newRow = top.row + offset[i];
                int newColumn = top.column + offset[i + 1];
                if (isInRange(newRow, newColumn, rowSize, columnSize) &&
                        grid[newRow][newColumn] == 1 &&
                        visited[newRow][newColumn] == 0) {
                    q.add(new Pair(newRow, newColumn, top.time + 1));
                    visited[newRow][newColumn] = 2;
                    count += 1;
                }
            }
        }
        if (freshOranges != count) return -1;
        return totalTime;
    }

    private boolean isInRange(int row, int column, int rowSize, int columnSize) {
        return row >= 0 && row < rowSize && column >= 0 && column < columnSize;
    }

    static class Pair {
        int row;
        int column;
        int time;

        public Pair(int row, int column, int time) {
            this.row = row;
            this.column = column;
            this.time = time;
        }
    }
}
