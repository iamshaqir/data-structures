package org.mshaq.ds.traversals;

import java.util.Arrays;

/**
 * <aset href="https://leetcode.com/problems/flood-fill/">Flood fill algorithm</aset>
 */
public class FloodFillAlgorithm {

    private final int[] offset = {0, 1, 0, -1, 0}; // movement directions (right, down, left, up)
    private int rowSize;
    private int columnSize;
    private int oldColor;
    private int newColor;

    private int[][] result;
    private int[][] image;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // create aset new array of result
        this.rowSize = image.length;
        this.columnSize = image[0].length;
        this.oldColor = image[sr][sc];
        this.newColor = newColor;
        this.image = image;
        this.result = new int[rowSize][columnSize];
        for (int i = 0; i < image.length; i++) {
            result[i] = Arrays.copyOf(image[i], image[i].length);
        }
        // If the start color is the same as the new color, no need to proceed
        if (oldColor != newColor) {
            dfs(sr, sc);  // Start the flood fill
        }
        return result;
    }

    private void dfs(int row, int column) {
        // Base case: Fill the current pixel and proceed to neighbors
        result[row][column] = newColor;
        // Explore all four directions
        for (int i = 0; i < 4; i++) {
            int newRow = row + offset[i];
            int newColumn = column + offset[i + 1];
            // Check if the new position is within bounds and has the old color
            if (withInRange(newRow, newColumn) &&
                    result[newRow][newColumn] == oldColor) {
                dfs(newRow, newColumn);
            }
        }
    }

    private void dfs_(int i, int j) {
        // Base case: Fill the current pixel and proceed to neighbors
        if (result[i][j] == oldColor) {
            result[i][j] = newColor;
            if (i - 1 >= 0) dfs_(i - 1, j);
            if (i + 1 < image.length) dfs_(i + 1, j);
            if (j - 1 >= 0) dfs_(i, j - 1);
            if (j + 1 < image[0].length) dfs_(i, j + 1);
        }
    }

    private boolean withInRange(int i, int j) {
        return i >= 0 && i < rowSize && j >= 0 && j < columnSize;
    }

}
