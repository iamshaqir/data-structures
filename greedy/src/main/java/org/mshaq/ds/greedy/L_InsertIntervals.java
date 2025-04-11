package org.mshaq.ds.greedy;

import java.util.ArrayList;
import java.util.List;

public class L_InsertIntervals {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;
        int n = intervals.length;
        List<int[]> result = new ArrayList<>();

        //case:1 => Add non-overlapping intervals
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i++]);
        }

        // case:2 => Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        result.add(newInterval);

        // case:3 => All remaining intervals
        while (i < n) {
            result.add(intervals[i++]);
        }

        // Convert List to array
        return result.toArray(new int[result.size()][]);
    }

    public int[][] insertBinarySearch(int[][] intervals, int[] newInterval) {
        int start = 0;
        int end = intervals.length - 1;
        List<int[]> merged = new ArrayList<>();

        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (intervals[middle][0] < newInterval[0]) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        // Insert newInterval at the found position
        for (int i = 0; i < start; i++) {
            merged.add(intervals[i]);
        }
        merged.add(newInterval);
        for (int i = start; i < intervals.length; i++) {
            merged.add(intervals[i]);
        }

        int[] previous = null;
        List<int[]> result = new ArrayList<>();
        for (int[] current : merged) {
            if(result.isEmpty() || previous[1] < current[0]) {
                result.add(current);
                previous = current;
            } else {
                previous[1] = Math.max(previous[1], current[1]);
            }
        }
        // Convert List to array
        return result.toArray(new int[result.size()][]);

    }
}
