package org.mshaq.ds.shortest_path;

import java.util.*;

public class PrintShortestPath {

    public List<Integer> shortestPath(int n, int m, int[][] edges) {

        int V = edges.length;
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            adj.get(u).add(new int[]{v, weight});
            adj.get(v).add(new int[]{u, weight});
        }

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, 1});

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;

        int[] parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            int currentDistance = current[0];
            int currentNode = current[1];

            for (int[] neighbours : adj.get(currentNode)) {

                int neighbour = neighbours[0];
                int weight = neighbours[1];

                if (currentDistance + weight < distance[neighbour]) {
                    distance[neighbour] = currentDistance + weight;
                    pq.add(new int[]{distance[neighbour], neighbour});
                    parent[neighbour] = currentNode;
                }
            }
        }

        if (distance[n] == Integer.MAX_VALUE) {
            return List.of(-1);
        }

        List<Integer> path = new ArrayList<>();
        int node = n;

        while (node != parent[node]) {
            path.add(node);
            node = parent[node];
        }

        path.add(1);
        path.add(distance[n]);
        Collections.reverse(path);

        return path;
    }
}
