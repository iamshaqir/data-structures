package org.mshaq.ds.problems.cycledetection;

import java.util.*;

public class CourseSchedule2 {

    private static class BFS {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            List<List<Integer>> adj = new ArrayList<>();
            int[] indegree = new int[numCourses];
            graph(numCourses, prerequisites, adj, indegree);
            return bfs(indegree, adj);
        }

        private int[] bfs(int[] indegree, List<List<Integer>> adj) {
            int[] result = new int[indegree.length];
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < indegree.length; i++) {
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }

            int index = 0;
            while (!q.isEmpty()) {
                int top = q.poll();
                result[index++] = top;
                for (int j : adj.get(top)) {
                    if (--indegree[j] == 0) {
                        q.add(j);
                    }
                }
            }
            return index == indegree.length ? result : new int[0];
        }

        private static void graph(int numCourses, int[][] prerequisites, List<List<Integer>> adj, int[] indegree) {
            while (numCourses-- > 0) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < prerequisites.length; i++) {
                for (int[] C : prerequisites) {
                    adj.get(C[1]).add(C[0]);
                    indegree[C[0]]++;
                }
            }
        }
    }

    private static class DFS {

        enum State {
            SAFE, UNSAFE
        }


        // Using List<List<Integer>> as Adjacency list had an TIME LIMIT EXCEPTION
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            List<Integer>[] adj = new ArrayList[numCourses];
            State[] state = new State[numCourses];
            Stack<Integer> stack = new Stack<>();
            graph(numCourses, prerequisites, adj);
            int[] result = new int[adj.length];
            for (int i = 0; i < adj.length; i++) {
                if (isCycle(i, adj, state, stack)) {
                    return new int[0];
                }
            }

            int idx = 0;
            while (!stack.isEmpty()) {
                result[idx++] = stack.pop();
            }
            return result;
        }

        private boolean isCycle(int current, List<Integer>[] adj, State[] state, Stack<Integer> stack) {
            if (state[current] != null) {
                return state[current] != State.SAFE;
            }
            state[current] = State.UNSAFE;
            for (int neighbour : adj[current]) {
                if (isCycle(neighbour, adj, state, stack)) {
                    return true;
                }
            }
            state[current] = State.SAFE;
            stack.add(current);
            return false;
        }

        private void graph(int numCourses, int[][] prerequisites, List<Integer>[] adj) {
            for(int i = 0; i < numCourses; i++) {
                adj[i] = new ArrayList<>();
            }

            for (int[] C : prerequisites) {
                adj[C[1]].add(C[0]);
            }
        }
    }
}
