package org.mshaq.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M09_InsertIntervals {


    public static void main(String[] args) {
//        int[][] input = {{1, 3}, {6, 9}};
//        int[] newInterval = {2, 5};

        int[][] input = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};

        int[][] result = insertBs(input, newInterval);
        for (int[] element : result) {
            System.out.println(Arrays.toString(element));
        }
    }

    // Using Non-overlapping and Merge technique
    public static int[][] insert(int[][] A, int[] newInterval) {

        int current = 0;
        int end = A.length;

        List<int[]> resultList = new ArrayList<>();

        // Add non-overlapping intervals
        while (current < end && A[current][1] < newInterval[0]) {
            resultList.add(A[current++]);
        }

        // Merge overlapping intervals, assume newInterval as previous
        while (current < end && A[current][0] <= newInterval[1]) {
            newInterval[0] = Math.min(A[current][0], newInterval[0]);
            newInterval[1] = Math.max(A[current][1], newInterval[0]);
            current++;
        }
        resultList.add(newInterval);

        // Add remaining elements
        while (current < end) {
            resultList.add(A[current++]);
        }

        // Convert List to array
        return resultList.toArray(new int[resultList.size()][]);

    }

    // Using binary search
    public static int[][] insertBs(int[][] A, int[] newInterval) {
        int start = 0;
        int end = A.length - 1;

        // First find the place to add element
        while (start < end) {
            int middle = start + (end - start) / 2;

            if (A[middle][0] < newInterval[0]) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        List<int[]> mergedIntervals = new ArrayList<>();
        // Add all previous elements
        for (int i = 0; i < start; i++) {
            mergedIntervals.add(A[i]);
        }

        // Add new interval
        mergedIntervals.add(newInterval);

        // Add left out intervals
        for (int i = start; i < A.length; i++) {
            mergedIntervals.add(A[i]);
        }

        // Merge overlapping intervals
        List<int[]> result = new ArrayList<>();
        int[] previous = null;
        for (int[] current : mergedIntervals) {
            if (result.isEmpty() || current[0] > previous[1]) {
                previous = current;
                result.add(current);
            } else {
                previous[1] = Math.max(previous[1], current[1]);
            }
        }

        // Convert List to array
        return result.toArray(new int[result.size()][]);
    }
}
