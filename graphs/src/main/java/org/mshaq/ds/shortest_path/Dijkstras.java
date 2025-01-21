package org.mshaq.ds.shortest_path;

import java.util.*;

public class Dijkstras {

    private static class WithPriorityQueue {
        /**
         * The main reason for using distance in Pair is to sort it ascending order in PQ
         * or else we could have only used node and took travelled distance from distance array
         */
        public int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {

            Queue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.distance));
            pq.add(new Pair(0, S));
            int[] distance = new int[V];
            Arrays.fill(distance, Integer.MAX_VALUE);

            while (!pq.isEmpty()) {
                Pair top = pq.poll();
                int currentDistance = top.distance;
                int current = top.node;

                for (List<Integer> neighbours : adj.get(current)) {
                    int neighbour = neighbours.get(0);
                    int weight = neighbours.get(1);

                    if (currentDistance + weight < distance[neighbour]) {
                        distance[neighbour] = currentDistance + weight;
                        pq.add(new Pair(distance[neighbour], neighbour));
                    }
                }
            }

            return distance;

        }

        static class Pair {
            int distance;
            int node;

            public Pair(int distance, int node) {
                this.distance = distance;
                this.node = node;
            }
        }
    }


}
