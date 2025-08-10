package org.mshaq.ds;

import java.util.Arrays;

/**
 * TUF: <a href="https://takeuforward.org/plus/dsa/greedy-algorithms/scheduling-and-interval-problems/shortest-job-first">Shortest Job Sequence</a>
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
/*
    A software engineer is tasked with using the shortest job first (SJF) policy to calculate the average waiting time
    for each process. The shortest job first also known as shortest job next (SJN) scheduling policy selects the
    waiting process with the least execution time to run next.

    Given an array of n integers representing the burst times of processes, determine the average waiting time for all
    processes and return the closest whole number that is less than or equal to the result.

    Input : bt = [4, 1, 3, 7, 2]
    Output : 4
    Explanation : The total waiting time is 20.
    So the average waiting time will be 20/5 => 4.
 */