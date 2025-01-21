package org.mshaq.ds.cycles;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BiPartiteV1 {


    // Using DFS
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] visited = new int[V];
        Arrays.fill(visited, -1);
        for (int i = 0; i < V; i++) {
            if (visited[i] == -1 &&
                    !dfs(i, 0, graph, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, int color, int[][] graph, int[] visited) {
        visited[node] = color;
        for (int current : graph[node]) {
            if (visited[current] == -1) {
                if (!dfs(current, 1 - color, graph, visited)) {
                    return false;
                }
            } else if (visited[current] == color) {
                return false;
            }
        }
        return true;
    }

    private boolean bfs(int node, int[][] graph, int[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = 0;

        while (!q.isEmpty()) {
            int top = q.poll();
            for (int current : graph[top]) {
                if (visited[current] == -1) {
                    visited[current] = 1 - visited[node];
                    q.add(current);
                } else if (visited[node] == visited[current]) {
                    return false;
                }
            }
        }
        return true;
    }
}
