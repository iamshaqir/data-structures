package org.mshaq.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode: <a href="https://leetcode.com/problems/merge-intervals/description/">Merge Intervals</a>
 */
public class M08_MergeIntervals {
    public static void main(String[] args) {
        int[][] input = {{1, 3}, {2, 6}, {8, 10}, {8, 9}, {9, 11}, {15, 18}, {2, 4}, {16, 17}};
        int[][] result = mergeIntervals(input);
        for (int[] element : result) {
            System.out.print(Arrays.toString(element) + ", ");
        }
    }

    /**
     * imp test case:-
     * [[1,3],[2,6],[8,10],[15,18]]
     * [[1,4],[4,5]]
     * [[1,4],[0,0]]
     * [[1,3], [2,6] ,[8,10] ,[8,9], [9,11],[15,18], [2,4] ,[16,17]]
     */
    public static int[][] mergeIntervals(int[][] intervals) {

        // sort intervals in Ascending order
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> resultList = new ArrayList<>();
        int[] previous = intervals[0];
        resultList.add(previous);

        for (int[] current : intervals) {
            if (current[0] > previous[1]) {
                previous = current;
                resultList.add(current);
            } else {
                previous[1] = Math.max(previous[1], current[1]);
            }
        }

        return resultList.toArray(new int[resultList.size()][]);
    }
}

/*
    Merge Intervals:
    ------------------------
    - Need to sort the intervals start element in Ascending order to make the interval ranges inline.
    - if current intervals start interval is > previous intervals end interval, then there is no overlapping, just add
      current interval to result.
    - if not get the maximum from previous intervals end interval and current intervals end interval, change the previous
      intervals end intervals
    - previous element has already been added to result so it will update interval in its reference
 */
