package org.mshaq.ds.shortest_path;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {

    private static class BFS {
        public int shortestPathBinaryMatrix(int[][] grid) {

            final int[] OFFSET_POSITIONS = {0, 1, 1, 0, -1, -1, 1, -1, 0};
            int noOfRows = grid.length;
            int noOfColumns = grid[0].length;

            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{0, 0, 0});

            int[][] distanceArr = new int[noOfRows][noOfColumns];
            for (int i = 0; i < noOfRows; i++) {
                Arrays.fill(distanceArr[i], Integer.MAX_VALUE);
            }
            distanceArr[0][0] = 0;

            while (!q.isEmpty()) {
                int[] current = q.poll();
                int distance = current[0];
                int row = current[1];
                int column = current[2];

                for (int i = 0; i < OFFSET_POSITIONS.length - 1; i++) {
                    int newRow = row + OFFSET_POSITIONS[i];
                    int newColumn = column + OFFSET_POSITIONS[i + 1];

                    if (newRow == noOfRows - 1 &&
                            newColumn == noOfColumns - 1) {
                        return distance + 1;
                    }

                    if (WithInRange(newRow, newColumn, noOfRows, noOfColumns) &&
                            grid[newRow][newColumn] == 0 &&
                            distance + 1 < distanceArr[newRow][newColumn]) {
                        distanceArr[newRow][newColumn] = distance + 1;
                        q.add(new int[]{distance + 1, newRow, newColumn});
                    }
                }

            }
            return -1;

        }

        private boolean WithInRange(int newRow, int newColumn, int noOfRows, int noOfColumns) {
            return newRow >= 0 && newRow < noOfRows && newColumn >= 0 && newColumn < noOfColumns;
        }
    }

    private static class BFS_BEST {
        public int shortestPathBinaryMatrix(int[][] grid) {
            int n = grid.length, m = grid[0].length;


            boolean[][] visited = new boolean[n][m];
            if (grid[0][0] == 1) return -1;
            Queue<Element> que = new LinkedList<>(); //since its moving unit distance in grid not need of priorityQueue. we can save log(n)
            que.add(new Element(1, 0, 0));

            while (!que.isEmpty()) {
                Element ele = que.poll();
                int distance = ele.distance;
                int r = ele.r;
                int c = ele.c;

                if (r == n - 1 && c == m - 1) return distance; // reached destination

                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        int nrow = r + i;
                        int ncol = c + j;
                        if (nrow < n && ncol < m && nrow >= 0 && ncol >= 0 &&
                                grid[nrow][ncol] == 0 &&
                                !visited[nrow][ncol]) {
                            que.add(new Element(distance + 1, nrow, ncol));
                            visited[nrow][ncol] = true; //mark visited
                        }
                    }
                }
            }
            return -1;
        }

        static class Element {
            int distance, r, c;

            Element(int d, int row, int col) {
                distance = d;
                r = row;
                c = col;
            }
        }
    }
}
