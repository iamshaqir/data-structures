package org.mshaq.ds.traversals;

/**
 * <aset href="https://leetcode.com/problems/surrounded-regions/description/">130. Surrounded Regions</aset>
 */
public class SurroundedRegions {

    private int nr;
    private int nc;

    public void solve(char[][] board) {
        this.nr = board.length;
        this.nc = board[0].length;

        boolean[][] visited = new boolean[nr][nc];

        // Mark the Row boundaries as visited
        for (int j = 0; j < nc; j++) {


            if (board[0][j] == 'O' && !visited[0][j]) {
                dfs(0, j, board, visited);
            }

            if (board[nr - 1][j] == 'O' && !visited[nr - 1][j]) {
                dfs(nr - 1, j, board, visited);
            }
        }

        // Mark the Column boundaries as visited
        for (int i = 0; i < nr; i++) {

            if (board[i][0] == 'O' && !visited[i][0]) {
                dfs(i, 0, board, visited);
            }

            if (board[i][nc - 1] == 'O' && !visited[i][nc - 1]) {
                dfs(i, nc - 1, board, visited);
            }
        }

        // Replace 'O' with 'X' in valid cells, as boundaries are already visited
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int row, int column, char[][] board, boolean[][] visited) {
        if (!isWithInRange(row, column) || board[row][column] != 'O' || visited[row][column]) {
            return;
        }
        visited[row][column] = true;
        dfs(row + 1, column, board, visited);
        dfs(row - 1, column, board, visited);
        dfs(row, column + 1, board, visited);
        dfs(row, column - 1, board, visited);
    }

    private boolean isWithInRange(int row, int column) {
        return row >= 0 && row < nr && column >= 0 && column < nc;
    }

    public static void main(String[] args) {
        char[][] mat = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        // Function call to replace surrounded 'O's with 'X's
        new SurroundedRegions().solve(mat);

        int n = mat.length;
        int m = mat[0].length;

        // Output
        System.out.println("The updated matrix is:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
