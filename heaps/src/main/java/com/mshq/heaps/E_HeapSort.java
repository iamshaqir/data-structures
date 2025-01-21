package com.mshq.heaps;

public class E_HeapSort {

    public void heapSort(int[] nums) {

        buildMaxHeap(nums);

        int length = nums.length - 1;
        while (length > 0) {
            swap(nums, 0, length);
            length--;
            if (length > 0) {
                heapifyDown(nums, 0, length);
            }
        }

    }

    private void buildMaxHeap(int[] nums) {

        int internals = (nums.length / 2) - 1;
        for (int i = internals; i >= 0; i--) {
            heapifyDown(nums, i, nums.length - 1);
        }
    }

    private void heapifyDown(int[] A, int current, int last) {
        int largest = current;
        int left = 2 * current + 1;
        int right = 2 * current + 2;

        if (left <= last && A[left] > A[largest]) {
            largest = left;
        }

        if (right <= last && A[right] > A[largest]) {
            largest = right;
        }

        if (largest != current) {
            swap(A, current, largest);
            heapifyDown(A, largest, last);
        }
    }

    private void swap(int[] A, int current, int largest) {
        int temp = A[current];
        A[current] = A[largest];
        A[largest] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {-16,1};
        new E_HeapSort().heapSort(nums);
    }
}
