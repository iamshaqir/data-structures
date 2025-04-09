package org.mshaq.ds.greedy;

import java.util.Arrays;

/**
 * GeeksForGeeks URL: <a href="https://www.geeksforgeeks.org/problems/shortest-job-first/1?
 * utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=shortest-job-first">Shortest Job first</a>
 */
public class I_ShortestJobFirst {

    public static int solve(int[] bt) {

        Arrays.sort(bt);

        int waitTime = 0;
        int executionTime = 0;

        for (int processTime : bt) {
            waitTime += executionTime;
            executionTime += processTime;
        }

        return waitTime / bt.length;
    }
}
