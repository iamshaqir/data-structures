package org.mshaq.ds.cycles;

import java.util.List;

public class DetectCycleDirected {

    // DFS
    public boolean isCyclic(int N, List<Integer>[] adj) {
        boolean[] visited = new boolean[N];
        boolean[] visitedPath = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (!visited[i] &&
                    dfs(i, adj, visited, visitedPath)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int node, List<Integer>[] adj,
                        boolean[] visited, boolean[] visitedPath) {
        visited[node] = true;
        visitedPath[node] = true;

        for (int current : adj[node]) {
            if (!visited[current] &&
                    dfs(current, adj, visited, visitedPath)) {
                return true;
            } else if (visitedPath[current]) {
                return true;
            }
        }
        visitedPath[node] = false;
        return false;
    }

    // BFS
    public boolean isCyclicBFS(int N, List<Integer>[] adj) {
        // For BFS, we can use Topological sort, if answer size < N, true else false
        // topological sort is for Directed Acyclic graph, it should return size
        return false;
    }

}
