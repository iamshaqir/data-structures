package org.mshaq.ds.traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b,
 * and city b is connected directly with city c, then city a is connected indirectly with city c.
 * <p>
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 * <p>
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly
 * connected, and isConnected[i][j] = 0 otherwise.
 * <p>
 * Return the total number of provinces.
 */
public class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        List<List<Integer>> adjlist = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adjlist.add(new ArrayList<>());
        }
        for (int i = 1; i < V; i++) {
            for (int j = 1; j < V; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    adjlist.get(i).add(j);
                    adjlist.get(j).add(i);
                }
            }
        }

        boolean[] visited = new boolean[V];
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, adjlist, visited);
                bfs(i, adjlist, visited);
            }
        }
        return count;
    }

    private void bfs(int node, List<List<Integer>> adjlist, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        visited[node] = true;
        q.add(node);
        while (!q.isEmpty()) {
            int top = q.poll();
            for (int curNode : adjlist.get(top)) {
                if (!visited[curNode]) {
                    q.add(curNode);
                    visited[curNode] = true;
                }
            }
        }
    }

    private void dfs(int node, List<List<Integer>> adjlist, boolean[] visited) {
        visited[node] = true;
        for (int curNode : adjlist.get(node)) {
            if (!visited[curNode]) {
                dfs(curNode, adjlist, visited);
            }
        }
    }

    public int findCircleNum_(int[][] isConnected) {
        int V = isConnected.length;
        boolean[] visited = new boolean[V];
        int cnt = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                cnt++;
                dfs_(i, isConnected, visited);
            }
        }
        return cnt;
    }

    private void dfs_(int node, int[][] isConnected, boolean[] visited) {
        visited[node] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[node][i] == 1 && !visited[i]) {
                dfs_(i, isConnected, visited);
            }
        }
    }

}
