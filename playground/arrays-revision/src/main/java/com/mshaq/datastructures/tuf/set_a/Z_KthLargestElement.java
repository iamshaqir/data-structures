package com.mshaq.datastructures.tuf.set_a;

public class Z_KthLargestElement {

    public int kthLargestElement(int[] A, int k) {
        //Will be doing QuickSort in Ascending order, so kth largest will be at n - k;
        return quickSelect(A, A.length - k);
    }

    private int quickSelect(int[] A, int k) {
        int si = 0;
        int ei = A.length - 1;

        while (si <= ei) {
            int pivotIndex = getPivotIndex(A, si, ei);
            if (pivotIndex == k) {
                return A[k];
            } else if (pivotIndex < k) {
                si = pivotIndex + 1;
            } else {
                ei = pivotIndex - 1;
            }
        }
        return -1;
    }

    private int getPivotIndex(int[] A, int si, int ei) {

        // Assume aset Pivot value // START || END || RANDOM
        int pivot = A[ei];

        // If assumed Pivot value is END,
        // Start iterating from start to move elements less than pivot value to left
        int pivotIndex = si;
        for (int current = 0; current <= ei; current++) {
            if (A[current] <= pivot) {
                swap(A, pivotIndex++, current);
            }
        }
        swap(A, pivotIndex, ei);
        return pivotIndex;
    }

    private void swap(int[] A, int pivotIndex, int current) {
        int temp = A[pivotIndex];
        A[pivotIndex] = A[current];
        A[current] = temp;
    }
}
