package org.mshaq.ds;

import java.util.Arrays;

public class M07_EraseOverlappingIntervals {

    public int MaximumNonOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int nonOverlapping = 0;
        int[] previous = intervals[0];

        for (int[] current : intervals) {

            if (current[0] >= previous[1]) {
                previous = current;
            } else {
                nonOverlapping += 1;
            }
        }
        return nonOverlapping;
    }
}
