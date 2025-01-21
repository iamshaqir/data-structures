package org.mshaq.ds.traversals;

import java.util.ArrayList;
import java.util.List;

public class DFSTraversal {

    // Time Complexity - O(N) - traverse each node and for loop(calling its neighbours) is 2E(degree of node)
    public List<Integer> dfs(int V, List<List<Integer>> adjList) {
        List<Integer> result = new ArrayList<>();

        // Visited array is to keep track of visited vertex
        boolean[] visited = new boolean[V];
        visited[0] = true;
        dfsHelper(0, adjList, visited, result);
        return result;
    }

    private void dfsHelper(int V, List<List<Integer>> adjList, boolean[] visited, List<Integer> result) {
        visited[V] = true;
        result.add(V);
        for (int i : adjList.get(V)) {
            if (!visited[V]) {
                dfsHelper(i, adjList, visited, result);
            }
        }
    }
}
