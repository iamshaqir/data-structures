package org.mshaq.ds.shortest_path;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


/***
 * <a href="https://leetcode.com/problems/path-with-minimum-effort/description/">1631. Path With Minimum Effort</a>
 */
public class PathWithMinimumEffort {

    private static class BFS_DIJKSTRAS {

        public int minimumEffortPath(int[][] heights) {
            final int[] OFFSET = {0, 1, 0, -1, 0};
            int n = heights.length;
            int m = heights[0].length;

            int[][] disArr = new int[n][m];
            for (int i = 0; i < n; i++) {
                Arrays.fill(disArr[i], Integer.MAX_VALUE);
            }
            disArr[0][0] = 0;

            Queue<Tuple> q = new PriorityQueue<>(Comparator.comparingInt(tuple -> tuple.distance));
            q.add(new Tuple(0, 0, 0));

            while (!q.isEmpty()) {
                Tuple current = q.poll();
                int row = current.row;
                int column = current.column;
                int distance = current.distance;
                if (row == n - 1 && column == m - 1) {
                    return distance;
                }
                for (int i = 0; i < 4; i++) {
                    int nRow = row + OFFSET[i];
                    int nColumn = column + OFFSET[i + 1];
                    if (inRange(nRow, nColumn, n, m)) {
                        int maxEffort = Math.max(distance,
                                Math.abs(heights[row][column] - heights[nRow][nColumn]));
                        if (maxEffort < disArr[nRow][nColumn]) {
                            disArr[nRow][nColumn] = maxEffort;
                            q.add(new Tuple(maxEffort, nRow, nColumn));
                        }
                    }
                }
            }
            return 0;
        }

        private boolean inRange(int row, int column, int n, int m) {
            return row >= 0 && column >= 0 && row < n && column < m;
        }

        static class Tuple {
            int distance;
            int row;
            int column;

            public Tuple(int distance, int row, int column) {
                this.distance = distance;
                this.row = row;
                this.column = column;
            }
        }
    }
}
