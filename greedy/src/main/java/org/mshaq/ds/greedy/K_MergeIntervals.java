package org.mshaq.ds.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class K_MergeIntervals {

    private static int compare(int[] a, int[] b) {
        return Integer.compare(a[0], b[0]);
    }

    public int[][] merge(int[][] intervals) {


        // Sort the array's second element in Ascending order
        Arrays.sort(intervals, K_MergeIntervals::compare);

        List<int[]> result = new ArrayList<>();
        int[] previous = intervals[0];
        result.add(previous);
        for (int[] current : intervals) {
            if (current[0] <= previous[1]) {
                previous[1] = Math.max(previous[1], current[1]);
            } else {
                previous = current;
                result.add(previous);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
