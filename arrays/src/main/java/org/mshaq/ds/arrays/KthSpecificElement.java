package org.mshaq.ds.arrays;

public class KthSpecificElement {

    public static int getKthLargest(int[] arr, int k) {
        int kthLargest = arr.length - k;
        return quickSelectKthElement(arr, k, kthLargest);
    }

    public static int getKthSmallest(int[] arr, int k) {
        int kthSmallest = k - 1;
        return quickSelectKthElement(arr, k, kthSmallest);
    }

    private static int quickSelectKthElement(int[] arr, int k, int kthSpecific) {
        int si = 0;
        int ei = arr.length - 1;
        while (si <= ei) {
            int pivotIndex = getPivotIndex(arr, si, ei);

            if (pivotIndex == kthSpecific) {
                return arr[pivotIndex];
            }

            if (pivotIndex < kthSpecific) {
                si = pivotIndex + 1;
            } else {
                ei = pivotIndex - 1;
            }

        }
        return -1;
    }
    private static int getPivotIndex(int[] arr, int si, int ei) {
        int pivot = arr[si];
        int i = ei;
        for (int j = ei; j > si; j--) {
            if (arr[j] > pivot) {
                swap(arr, i--, j);
            }
        }
        swap(arr, si, i);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
