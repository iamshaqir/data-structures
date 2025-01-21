package org.mshaq.ds.problems.cycledetection;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AlienDictionary {

    public static void main(String[] args) {
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        int n = 5, k = 4;
        String res = new DFS().findOrder(dict, n, k);
        System.out.println("Result: " + res);
    }

    private static class DFS {
        public String findOrder(String[] dict, int N, int K) {
            List<Integer>[] graph = new ArrayList[K];
            graph(dict, graph);
            Stack<Integer> letters = new Stack<>();
            int[] visited = new int[graph.length];
            for (int i = 0; i < graph.length; i++) {
                if (isCycle(i, visited, graph, letters)) {
                    return "";
                }
            }
            StringBuilder sb = new StringBuilder();
            int idx = 0;
            while (!letters.isEmpty()) {
                int top = letters.pop();
                sb.append((char) ('a' + top)).append(" ");
            }
            return sb.toString();
        }

        private boolean isCycle(int current, int[] visited, List<Integer>[] graph, Stack<Integer> letters) {
            if (visited[current] != 0) {
                return visited[current] != 2;
            }
            visited[current] = 1;
            for (int neighbour : graph[current]) {
                if (visited[neighbour] == 2) continue;
                if (isCycle(neighbour, visited, graph, letters)) {
                    return true;
                }
            }
            letters.add(current);
            visited[current] = 2;
            return false;
        }

        private void graph(String[] dict, List<Integer>[] graph) {

            for (int i = 0; i < graph.length; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < dict.length - 1; i++) {
                String s1 = dict[i];
                String s2 = dict[i + 1];
                int length = Math.min(s1.length(), s2.length());
                for (int j = 0; j < length; j++) {
                    if (s1.charAt(j) != s2.charAt(j)) {
                        graph[s1.charAt(j) - 'a'].add(s2.charAt(j) - 'a');
                        break;
                    }
                }
            }
        }

    }
}
