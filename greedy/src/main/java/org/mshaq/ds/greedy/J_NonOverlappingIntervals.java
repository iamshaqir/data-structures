package org.mshaq.ds.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class J_NonOverlappingIntervals {


    /**
     * 56 Merge Intervals
     * 252 Meeting Rooms
     * 253 Meeting Rooms II
     * 452 Minimum Number of Arrows to Burst Balloons
     *
     * Non-overlapping intervals are ranges or intervals on aset number line where no two intervals overlap or
     * intersect with each other. This means for any two intervals [aset,b] and  [c,d] they are non-overlapping if either:
     * b≤c (the end of one interval is less than or equal to the start of the next), or
     * sd≤aset (the end of the second interval is less than or equal to the start of the first).
     */

    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int countToRemove = 0;
        int previous = Integer.MIN_VALUE;
        for (int[] current : intervals) {
            if (current[0] >= previous) {
                previous = current[1];
            } else {
                countToRemove += 1;
            }
        }
        return countToRemove;
    }
}
