package org.mshaq.ds.shortest_path;

import java.util.*;

public class CheapestFlightsKStops {

    private static class BFS_DIJKSTRAS {

        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

            List<List<int[]>> adjList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<>());
            }

            for (int[] flight : flights) {
                int u = flight[0];
                int v = flight[1];
                int weight = flight[2];
                adjList.get(u).add(new int[]{v, weight});
            }

            int[] disArr = new int[n];
            Arrays.fill(disArr, Integer.MAX_VALUE);
            disArr[src] = 0;

            Queue<Tuple> q = new LinkedList<>();
            q.add(new Tuple(0, src, 0));

            while (!q.isEmpty()) {
                Tuple current = q.poll();

                int stops = current.stops;
                int node = current.node;
                int distance = current.distance;

                if (stops > k) continue;

                for (int[] neighbours : adjList.get(node)) {
                    int neighbour = neighbours[0];
                    int weight = neighbours[1];

                    if (distance + weight < disArr[neighbour]) {
                        disArr[neighbour] = distance + weight;
                        q.add(new Tuple(stops + 1, neighbour, disArr[neighbour]));
                    }
                }
            }

            return (disArr[dst] == Integer.MAX_VALUE) ? -1 : disArr[dst];

        }

        static class Tuple {
            int stops;
            int node;
            int distance;

            public Tuple(int stops, int node, int distance) {
                this.stops = stops;
                this.node = node;
                this.distance = distance;
            }
        }
    }
}
