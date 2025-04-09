package com.mshaq.ds.set_a;

public class F_FindKRotation {


    public int findKRotation(int[] A) {
        // Similar to find minimum approach, keep tract of index of minimum and return it
        int si = 0, ei = A.length - 1;
        int minimum = Integer.MAX_VALUE;
        int index = 0;
        while (si <= ei) {
            int mi = si + (ei - si) / 2;

            //Edge case, if array is already sorted
            if (A[si] <= A[ei]) {
                if (A[si] < minimum) {
                    minimum = A[si];
                    index = si;
                }
                break;
            }

            if (A[si] <= A[mi]) {
                if (A[si] < minimum) {
                    minimum = A[si];
                    index = si;
                }
                si = mi + 1;
            } else {
                if (A[mi] < minimum) {
                    minimum = A[mi];
                    index = mi;
                }
                ei = mi - 1;
            }
        }
        return index;
    }

    /**
     * Example-1: [4, 5, 6, 7, 0, 1, 2]
     * <p>
     * Example-2: [5, 6, 7, 0, 1, 2, 4]
     * <p>
     * Example-3: [5, 6, 1, 2, 3]
     *
     * Rotate right => remove from right and add in start of array
     */
}
