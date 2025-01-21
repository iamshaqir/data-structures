package com.mshq.heaps;

public class D_IsMinHeap {

    public boolean isHeap(int[] A) {
        int internals = (A.length / 2) - 1;
        for (int i = 0; i <= internals; i++) {
            int left = 2 * i + 1, right = 2 * i + 2;

            if (left < A.length && A[left] < A[i]) {
                return false;
            }

            if (right < A.length && A[right] < A[i]) {
                return false;
            }
        }
        return true;
    }
}
