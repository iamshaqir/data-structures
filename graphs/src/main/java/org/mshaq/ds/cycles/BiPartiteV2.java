package org.mshaq.ds.cycles;

/**
 * <a href="https://leetcode.com/problems/is-graph-bipartite/description/">785. Is Graph Bipartite?</a>
 */
public class BiPartiteV2 {

    // Using DFS
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] visited = new int[V];

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0 &&
                    !dfs(i, 1, graph, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, int color, int[][] graph, int[] visited) {
        if (visited[node] != 0) {
            return visited[node] == color;
        }
        visited[node] = color;
        for (int current : graph[node]) {
            if (!dfs(current, -(color), graph, visited)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] grid = {{1}, {0, 2, 4}, {1, 3}, {2, 6}, {1, 5}, {4, 6}, {3, 5, 7}, {6, 8}, {7}};
        boolean flag = new BiPartiteV2().isBipartite(grid);
        System.out.println("Is Bi-Partite: " + flag);
    }
}
