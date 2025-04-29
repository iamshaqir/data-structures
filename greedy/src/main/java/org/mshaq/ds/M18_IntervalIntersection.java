package org.mshaq.ds;


import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode: <a href="https://leetcode.com/problems/interval-list-intersections/">IntervalIntersection</a>
 */
public class M18_IntervalIntersection {

    // Using two pointers approach
    public int[][] intervalIntersection(int[][] A, int[][] B) {

        int left = 0, right = 0;
        List<int[]> result = new ArrayList<>();

        while (left < A.length && right < B.length) {

            // Find intersection between two intervals
            int startMax = Math.max(A[left][0], B[right][0]);
            int endMin = Math.min(A[left][1], B[right][1]);

            if (endMin >= startMax) result.add(new int[]{startMax, endMin});

            if (A[left][1] < B[right][1]) {
                left++;
            } else {
                right++;
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
