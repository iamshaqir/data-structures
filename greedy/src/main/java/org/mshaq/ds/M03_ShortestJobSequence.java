package org.mshaq.ds;

import java.util.Arrays;

/**
 * GeeksForGeeks: <a href="https://www.geeksforgeeks.org/problems/shortest-job-first/1?
 * utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=shortest-job-first">Shortest Job Sequence</a>
 */
public class M03_ShortestJobSequence {

    /**
     * <ul>
     *  <li>Sort the processes in ascending order</li>
     *  <li>Each process take certain wait time, initial process will take 0 wait time</li>
     *  <li>Other processes will wait until previous precesses are finished i.e., wait time and their process time</li>
     *  <li>Return Average of wait time</li>
     *  </ul>
     */
    public int scheduleSJF(int[] A) {

        Arrays.sort(A);

        int waitTime = 0;
        int executionTime = 0;

        for (int processTime : A) {
            waitTime += executionTime;
            executionTime += processTime;
        }

        return waitTime / A.length;
    }
}
