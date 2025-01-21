package org.mshaq.ds.shortest_path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathDAG {

    public static void main(String[] args) {

        int[][] edge = {
                {0, 2, 6},
                {0, 3, 7},
                {0, 4, 9},
                {0, 6, 8},
                {0, 7, 6},
                {1, 2, 6},
                {1, 3, 7},
                {1, 5, 10},
                {1, 6, 1},
                {1, 7, 4},
                {2, 3, 3},
                {2, 6, 10},
                {2, 8, 8},
                {2, 9, 10},
                {3, 5, 3},
                {3, 6, 10},
                {3, 7, 5},
                {5, 6, 9},
                {5, 7, 7},
                {6, 7, 7},
                {6, 8, 8},
                {6, 9, 8},
                {7, 9, 1},
                {8, 9, 6}};

        int V = 10, E = 24;
        int[] res = new ShortestPathDAG().shortestPath(V, E, edge);
        System.out.println(Arrays.toString(res));
    }

    public int[] shortestPath(int V, int E, int[][] edges) {
        List<List<Pair>> adj = graph(V, E, edges);

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topo(i, adj, visited, stack);
            }
        }

        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        while (!stack.empty()) {
            int current = stack.pop();
            if (distance[current] != Integer.MAX_VALUE) {
                for (Pair pair : adj.get(current)) {
                    int neighbour = pair.node;
                    int weight = pair.weight;
                    if (distance[current] + weight < distance[neighbour]) {
                        distance[neighbour] = weight + distance[current];
                    }
//                    distance[neighbour] = Math.min(distance[neighbour], weight + distance[current]);
                }
            }
        }
        return distance;
    }

    private void topo(int current, List<List<Pair>> adj,
                      boolean[] visited, Stack<Integer> stack) {

        visited[current] = true;
        for (Pair neighbour : adj.get(current)) {
            int node = neighbour.node;
            if (!visited[node]) {
                topo(node, adj, visited, stack);
            }
        }
        stack.push(current);
    }

    private static List<List<Pair>> graph(int V, int E, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int weight = edges[i][2];

            adj.get(u).add(new Pair(v, weight));
        }
        return adj;
    }

    static class Pair {
        int node;
        int weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}

