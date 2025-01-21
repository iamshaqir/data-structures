package com.mshq.heaps;

public class A_ReplaceIndexWithValue {

    public static class MaxHeap {

        public int[] replaceIdxWithVal(int[] A, int idx, int value) {

            A[idx] = value;
            // MAX HEAP => 50 > 30
            if (A[idx] > value) {
                heapifyDown(A, idx);
            } else {
                heapifyUp(A, idx);
            }
            return A;
        }

        private void heapifyUp(int[] A, int idx) {
            int parent = (idx - 1) / 2;
            if (parent > 0 && A[idx] > A[parent]) {
                swap(A, parent, idx);
                heapifyUp(A, parent);
            }
        }

        private void heapifyDown(int[] A, int idx) {
            int largest = idx;
            int leftChild = 2 * idx + 1, rightChild = 2 * idx + 2;
            if (leftChild < A.length &&
                    A[leftChild] > A[largest]) {
                largest = leftChild;
            }

            if (rightChild < A.length &&
                    A[rightChild] > A[largest]) {
                largest = rightChild;
            }

            if (largest != idx) {
                swap(A, largest, idx);
                heapifyDown(A, largest);
            }
        }

        private void swap(int[] A, int largest, int idx) {
            int temp = A[largest];
            A[largest] = A[idx];
            A[idx] = temp;
        }
    }

    public static class MinHeap {

        public int[] replaceIdxWithVal(int[] A, int idx, int value) {
            A[idx] = value;
            // MIN HEAP 50 > 10
            if (A[idx] > value) {
                heapifyUp(A, idx);
            } else {
                heapifyDown(A, idx);
            }
            return A;
        }

        private void heapifyDown(int[] A, int idx) {
            int parent = (idx / 2) - 1;
            if (parent > 0 && A[idx] < A[parent]) {
                swap(A, parent, idx);
                heapifyDown(A, parent);
            }
        }

        private void heapifyUp(int[] A, int idx) {
            int smallest = idx;
            int left = 2 * idx + 1, right = 2 * idx + 2;
            if (left < A.length && A[left] < A[smallest]) {
                smallest = left;
            }

            if (right < A.length && A[right] < A[smallest]) {
                smallest = right;
            }

            if (smallest != idx) {
                swap(A, smallest, idx);
                heapifyUp(A, smallest);
            }
        }

        private void swap(int[] A, int largest, int idx) {
            int temp = A[largest];
            A[largest] = A[idx];
            A[idx] = temp;
        }
    }
}
