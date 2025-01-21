package org.mshaq.ds.cycles;

import java.util.Stack;

public class TopologicalSortDFS {

    public int[] topologicalDFS(int[][] grid) {
        int V = grid.length;
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        int[] result = new int[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, grid, stack, visited);
            }
        }

        int i = 0;
        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }
        return result;
    }

    private void dfs(int node, int[][] grid, Stack<Integer> stack, boolean[] visited) {
        visited[node] = true;
        for (int current : grid[node]) {
            if (!visited[current]) {
                dfs(current, grid, stack, visited);
            }
        }
        stack.push(node);
    }

}
