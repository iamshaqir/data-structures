package org.mshaq.ds.greedy;

import java.util.Arrays;

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
