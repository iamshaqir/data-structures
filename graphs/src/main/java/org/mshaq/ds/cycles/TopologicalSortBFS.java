package org.mshaq.ds.cycles;

import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortBFS {

    public int[] topologicalBFS(int[][] grid) {

        int V = grid.length;
        int[] inDegree = new int[V];
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[V];
        // Create an In Degree for the Adjacency List
        for (int i = 0; i < V; i++) {
            for (int j : grid[i]) {
                inDegree[j]++;
            }
        }

        // Add Elements with zero in degree in Queue
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        // Perform BFS, add top element to answer
        // Keep reducing in degree for top node, if zero add to Queue
        int index = 0;
        while (!q.isEmpty()) {
            int top = q.poll();
            result[index++] = top;
            for (int i : grid[top]) {
                inDegree[i]--;
                if (inDegree[i] == 0) {
                    q.add(i);
                }
            }
        }

        return result;
    }
}
