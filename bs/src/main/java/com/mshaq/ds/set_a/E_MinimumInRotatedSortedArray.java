package com.mshaq.ds.set_a;

public class E_MinimumInRotatedSortedArray {


    public int minimum(int[] A) {

        // use rotated sorted array approach, either left or right part won't be sorted
        // Make use of array being sorted
        int si = 0, ei = A.length - 1;
        int minimum = Integer.MAX_VALUE;

        while (si <= ei) {
            int mi = si + (ei - si) / 2;
            if (A[si] <= A[mi]) {
                minimum = Math.min(minimum, A[si]);
                si = mi + 1;
            } else {
                minimum = Math.min(minimum, A[mi]);
                ei = mi - 1;
            }
        }
        return minimum;
    }
}


/**
 * Example-1: [4, 5, 6, 7, 0, 1, 2]
 * <p>
 * Example-2: [5, 6, 7, 0, 1, 2, 4]
 * <p>
 * Example-3: [5, 6, 1, 2, 3]
 */
