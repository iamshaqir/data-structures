package org.mshaq.ds.spanning_tree;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrimsAlgoMST {

    public int spanningTree(int V, List<List<List<Integer>>> adj) {
        Queue<Tuple> q = new PriorityQueue<>(Comparator.comparingInt(p -> p.weight));
        q.add(new Tuple(0, -1));

        boolean[] visited = new boolean[V];
        int sum = 0;
        while (!q.isEmpty()) {
            Tuple top = q.poll();
            int weight = top.weight;
            int node = top.node;
            if (visited[node]) continue;
            visited[node] = true;
            sum += weight;

            for (List<Integer> neighbours : adj.get(node)) {
                int nodeWeight = neighbours.get(0);
                int neighbour = neighbours.get(1);

                if (!visited[neighbour]) {
                    q.add(new Tuple(nodeWeight, neighbour));
                }
            }
        }
        return sum;
    }

    private static class Tuple {
        int weight;
        int node;

        public Tuple(int weight, int node) {
            this.weight = weight;
            this.node = node;
        }
    }
}
