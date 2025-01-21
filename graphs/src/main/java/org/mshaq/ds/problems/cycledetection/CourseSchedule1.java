package org.mshaq.ds.problems.cycledetection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule1 {

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{0, 1}};
        new CourseSchedule1.BFSV1().canFinish(numCourses, prerequisites);
    }

    // Using Topo sort
    private static class BFSV1 {
        public boolean canFinish(int numCourses, int[][] prerequisites) {

            List<List<Integer>> adjList = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                adjList.add(new ArrayList<>());
            }

            for (int i = 0; i < prerequisites.length; i++) {
                adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }

            int[] indegree = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                for (int j : adjList.get(i)) {
                    indegree[j]++;
                }
            }

            // Add Elements with zero in degree in Queue
            for (int i = 0; i < numCourses; i++) {
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }

            int count = 0;
            while (!q.isEmpty()) {
                int top = q.poll();
                count++;
                for (int i : adjList.get(top)) {
                    indegree[i]--;
                    if (indegree[i] == 0) {
                        q.add(i);
                    }
                }
            }

            return count == numCourses;
        }
    }

    private static class BFSV2 {

        public boolean canFinish(int V, int[][] prerequisites) {
            List<List<Integer>> adj = new ArrayList<>(V);
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            for (int[] c : prerequisites) {
                adj.get(c[1]).add(c[0]);
            }

            int[] indegree = new int[V];
            for (int i = 0; i < V; i++) {
                for (int j : adj.get(i)) {
                    indegree[j]++;
                }
            }

            // Add Elements with zero in degree in Queue
            for (int i : indegree) {
                if (i == 0) {
                    q.add(i);
                }
            }

            int count = 0;
            while (!q.isEmpty()) {
                int top = q.poll();
                count++;
                for (int i : adj.get(top)) {
                    if (--indegree[i] == 0) {
                        q.add(i);
                    }
                }
            }

            return count == V;


        }

    }
}
