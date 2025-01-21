package com.mshq.heaps;

public class B_HeapFromArray {

    public static class MinHeap {

        public int[] build(int[] A) {
            int internalNodes = (A.length / 2) - 1;
            for (int i = internalNodes; i >= 0; i--) {
                heapifyDown(A, i);
            }
            return A;
        }

        private void heapifyDown(int[] A, int index) {
            int smallest = index;
            int left = 2 * index + 1, right = 2 * index + 2;

            if (left < A.length && A[left] < A[smallest]) {
                smallest = left;
            }

            if (right < A.length && A[right] < A[smallest]) {
                smallest = right;
            }

            if (smallest != index) {
                swap(A, smallest, index);
                heapifyDown(A, smallest);
            }
        }

        private void swap(int[] A, int smallest, int idx) {
            int temp = A[smallest];
            A[smallest] = A[idx];
            A[idx] = temp;
        }
    }
}
