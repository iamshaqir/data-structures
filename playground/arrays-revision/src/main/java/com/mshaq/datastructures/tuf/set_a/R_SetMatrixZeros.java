package com.mshaq.datastructures.tuf.set_a;

public class R_SetMatrixZeros {

    // TC (n x m) x (n + m) + (n x m)
    static class BruteForce {
        public void setZeroes(int[][] A) {
            int m = A.length;
            int n = A[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (A[i][j] == 0) {
                        markRow(A, i, m);
                        markColumn(A, j, n);
                    }
                }

            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (A[i][j] == -1) {
                        A[i][j] = 0;
                    }
                }
            }
        }

        private void markRow(int[][] A, int row, int m) {
            for (int i = 0; i < m; i++) {
                if (A[row][i] != 0) {
                    A[row][i] = -1;
                }
            }
        }

        private void markColumn(int[][] A, int column, int n) {
            for (int i = 0; i < n; i++) {
                if (A[column][i] != 0) {
                    A[column][i] = -1;
                }
            }
        }
    }

    static class Better {
        public void setZeroes(int[][] A) {
            int m = A.length;
            int n = A[0].length;

            int[] row = new int[m];
            int[] column = new int[n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (A[i][j] == 0) {
                        row[i] = 1;
                        column[j] = 1;
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (row[i] == 1 ||
                            column[j] == 1) {
                        A[i][j] = 0;
                    }
                }
            }

        }
    }

    static class Optimal {

        public void setZeroes(int[][] A) {

            int m = A.length;
            int n = A[0].length;
            int extraCol = 1;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (A[i][j] == 0) {
                        A[i][0] = 0;

                        if (i != 0) {
                            A[0][j] = 0;
                        } else {
                            extraCol = 0;
                        }
                    }
                }
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (A[0][j] == 0 || A[i][0] == 0) {
                        A[i][j] = 0;
                    }
                }
            }

            if (A[0][0] == 0) {
                for (int j = 0; j < n; j++) {
                    A[0][j] = 0;
                }
            }

            if (extraCol == 0) {
                for (int i = 0; i < m; i++) {
                    A[i][0] = 0;
                }
            }
        }
    }
    // Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
    // Output: [[1,0,1],[0,0,0],[1,0,1]]
}
