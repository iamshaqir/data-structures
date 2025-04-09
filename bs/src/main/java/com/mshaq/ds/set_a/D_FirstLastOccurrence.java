package com.mshaq.ds.set_a;

public class D_FirstLastOccurrence {
    public int[] searchRange(int[] nums, int target) {

        int first = firstOccurrence(nums, target);
        if (first == -1) return new int[]{-1, -1};
        int last = lastOccurrence(nums, target);
        return new int[]{first, last};
    }

    private int firstOccurrence(int[] A, int target) {
        int first = -1;
        int si = 0, ei = A.length - 1;
        while (si <= ei) {
            int mi = si + (ei - si) / 2;
            if (A[mi] == target) {
                first = mi;
                ei = mi - 1;
            } else if (A[mi] < target) {
                si = mi + 1;
            } else {
                ei = mi - 1;
            }
        }
        return first;
    }

    private int lastOccurrence(int[] A, int target) {
        int last = -1;
        int si = 0, ei = A.length - 1;
        while (si <= ei) {
            int mi = si + (ei - si) / 2;
            if (A[mi] == target) {
                last = mi;
                si = mi + 1;
            } else if (A[mi] < target) {
                si = mi + 1;
            } else {
                ei = mi - 1;
            }
        }
        return last;
    }

}
