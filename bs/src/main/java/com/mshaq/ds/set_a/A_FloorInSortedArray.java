package com.mshaq.ds.set_a;

public class A_FloorInSortedArray {

    public int floor(int[] A, int k) {

        int si = 0, ei = A.length - 1;
        int floor = -1;
        while (si <= ei) {
            int mi = si + (ei - si) / 2;
            if (A[mi] <= k) {
                floor = mi;
                si = mi + 1;
            } else {
                ei = mi - 1;
            }
        }
        return floor;
    }
}

/**
 * Input: arr[] = [1, 2, 8, 10, 11, 12, 19], k = 5
 * Output: 1
 * Explanation: Largest Number less than 5 is 2 , whose index is 1.
 */
