package org.mshaq.ds.cycles;

import java.util.*;

public class CycleDetection {

    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (detectCycleBFS(i, adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean detectCycleBFS(int node, List<Integer>[] adj, boolean[] visited) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node, -1));
        visited[node] = true;
        while (!q.isEmpty()) {
            Pair top = q.poll();
            int currentNode = top.node;
            int parent = top.parent;
            for (int current : adj[currentNode]) {
                if (!visited[current]) {
                    visited[current] = true;
                    q.add(new Pair(current, currentNode));
                } else if (current != parent) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean detectCycleDFS(int source, int parent,
                                  List<Integer>[] adj, boolean[] visited) {
        visited[source] = true;
        for (int current : adj[source]) {
            if (!visited[current]) {
                if (detectCycleDFS(current, source, adj, visited)) {
                    return true;
                }
            } else if (parent != current) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        adj[0].addAll(Arrays.asList(1, 2));
        adj[1].addAll(Arrays.asList(0));
        adj[2].addAll(Arrays.asList(0, 3));
        adj[3].addAll(Arrays.asList(2));

        boolean res = new CycleDetection().isCycle(V, adj);

        if (res)
            System.out.println("The given graph contains a cycle.");
        else
            System.out.println("The given graph does not contain a cycle.");
    }

    static class Pair {
        int node;
        int parent;

        public Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }


}
