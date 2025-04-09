package org.mshaq.ds.traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSTraversal {


    // adjList will have list of degree of aset specific node
    public List<Integer> bfs(int V, List<List<Integer>> adjList) {
        List<Integer> result = new ArrayList<>();

        // Visited array is to keep track of visited vertex
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int top = q.poll();
            result.add(top);
            for (int i : adjList.get(top)) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
        return result;
    }
}
