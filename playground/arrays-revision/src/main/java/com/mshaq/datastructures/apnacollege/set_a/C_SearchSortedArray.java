package com.mshaq.datastructures.apnacollege.set_a;

public class C_SearchSortedArray {

    // only unique numbers
    public int search(int[] A, int target) {
        int si = 0, ei = A.length - 1;

        while (si <= ei) {
            int mi = si + (ei - si) / 2;
            if (A[mi] == target) return mi;

            // Identify sorted part, could be either first or second
            if (A[si] <= A[mi]) {
                if (A[si] <= target && A[mi] > target) {
                    ei = mi - 1;
                } else {
                    si = mi + 1;
                }
            } else {
                if (A[mi] < target && A[ei] >= target) {
                    si = mi + 1;
                } else {
                    ei = mi - 1;
                }
            }
        }
        return -1;
    }

    // First solve rotated sort array and dry run
    public int searchWithDuplicates(int[] A, int target) {
        int si = 0, ei = A.length - 1;

        while (si <= ei) {
            int mi = si + (ei - si) / 2;
            if (A[mi] == target) return mi;

            // If three elements are equal, how can we assure which part is sorted??
            // move si and mi to their respective positions
            if (A[si] == A[mi] && A[mi] == A[ei]) {
                si++;
                ei--;
                continue;
            }

            // Identify sorted part, could be either first or second
            if (A[si] <= A[mi]) {
                if (A[si] <= target && A[mi] > target) {
                    ei = mi - 1;
                } else {
                    si = mi + 1;
                }
            } else {
                if (A[mi] < target && A[ei] >= target) {
                    si = mi + 1;
                } else {
                    ei = mi - 1;
                }
            }
        }
        return -1;
    }
}
