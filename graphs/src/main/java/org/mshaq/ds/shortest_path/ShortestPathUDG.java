package org.mshaq.ds.shortest_path;

import java.util.*;

public class ShortestPathUDG {

    public int[] shortestPath(int V, int E, int src, int[][] edges) {

        List<List<Integer>> adj = graph(V, edges);
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        while (!q.isEmpty()) {
            int current = q.poll();
            for (int neighbour : adj.get(current)) {
                if (distance[current] + 1 < distance[neighbour]) {
                    distance[neighbour] = distance[current] + 1;
                    q.add(neighbour);
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1;
            }
        }
        return distance;
    }

    private List<List<Integer>> graph(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);

        }
        return adj;
    }
}
