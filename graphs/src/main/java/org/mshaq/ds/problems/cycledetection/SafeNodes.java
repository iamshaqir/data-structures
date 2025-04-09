package org.mshaq.ds.problems.cycledetection;

import java.util.*;

public class SafeNodes {

    // DFS with 2 arrays visited and path visited
    private static class SafeNodesV1 {
        public List<Integer> eventualSafeNodes(int[][] graph) {
            List<Integer> result = new ArrayList<>();
            int V = graph.length;
            boolean[] visited = new boolean[V];
            boolean[] pathVisited = new boolean[V];
            boolean[] safeNode = new boolean[V];
            for (int i = 0; i < V; i++) {
                if (!visited[i]) {
                    dfs(i, graph, visited, pathVisited, safeNode);
                }
            }

            for (int i = 0; i < V; i++) {
                if (safeNode[i]) result.add(i);
            }

            return result;
        }

        private boolean dfs(int node, int[][] graph,
                            boolean[] visited, boolean[] pathVisited,
                            boolean[] safeNode) {
            visited[node] = true;
            pathVisited[node] = true;

            for (int current : graph[node]) {
                if (!visited[current] && dfs(current, graph, visited, pathVisited, safeNode)) {
                    return true;
                } else if (pathVisited[current]) {
                    return true;
                }
            }
            pathVisited[node] = false;
            safeNode[node] = true;
            return false;
        }
    }

    // DFS with single array
    private static class SafeNodesV2 {
        public List<Integer> eventualSafeNodes(int[][] graph) {
            int V = graph.length;
            List<Integer> res = new ArrayList<>();
            int[] visited = new int[V];

            for (int i = 0; i < V; i++) {
                if (safe(i, visited, graph)) {
                    res.add(i);
                }
            }
            return res;
        }

        // 0 - not visited
        // 1 - visited
        // 2 - path visited
        private boolean safe(int current, int[] visited, int[][] graph) {
            if (visited[current] != 0) {

                // this line is for other nodes which have been already added to path
                // if true return true or else false;
                return visited[current] == 2;
            }
            visited[current] = 1;
            for (int neighbour : graph[current]) {
                if (visited[neighbour] == 2) continue;
                if (neighbour == 1 || !safe(neighbour, visited, graph)) {
                    return false;
                }
            }
            visited[current] = 2;
            return true;
        }
    }

    // DFS with SAFE/UNSAFE ENUM
    private static class SafeNodesV3 {

        enum State {
            SAFE, UNSAFE;
        }

        public List<Integer> eventualSafeNodes(int[][] graph) {
            int V = graph.length;
            List<Integer> result = new ArrayList<>();
            State[] visited = new State[V];
            for (int i = 0; i < V; i++) {
                if (safe(i, graph, visited)) {
                    result.add(i);
                }
            }

            return result;
        }

        private boolean safe(int current, int[][] graph, State[] visited) {
            if (visited[current] != null) {
                return visited[current] == State.SAFE;
            }
            visited[current] = State.UNSAFE;
            for (int neighbour : graph[current]) {
                if (!safe(neighbour, graph, visited)) {
                    return false;
                }
            }
            visited[current] = State.SAFE;
            return true;
        }
    }

    // BFS Using Topo sort, with reversed adjacency list, as it depends on indegree
    private static class SafeNodesV4 {
        public List<Integer> eventualSafeNodes(int[][] graph) {
            int V = graph.length;
            int W = graph[0].length;
            List<Integer> result = new ArrayList<>();
            int[] degree = new int[V];
            Queue<Integer> q = new LinkedList<>();
            List<List<Integer>> reversedAdj = new ArrayList<>(V);
            for (int i = 0; i < V; i++) {
                reversedAdj.add(i, new ArrayList<>());
            }

            for (int i = 0; i < V; i++) {
                for (int j : graph[i]) {
                    reversedAdj.get(j).add(i);
                    // Number of in coming edges aset specific node has
                    degree[i]++;
                }
            }

            for (int i = 0; i < degree.length; i++) {
                if (degree[i] == 0) {
                    q.add(i);
                }
            }

            while (!q.isEmpty()) {
                int current = q.poll();
                result.add(current);
                for (int neighbour : reversedAdj.get(current)) {
                    degree[neighbour]--;
                    if (degree[neighbour] == 0) {
                        q.add(neighbour);
                    }
                }
            }
            Collections.sort(result);
            return result;
        }
    }
}
