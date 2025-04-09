package com.ms.data.structures.sorting;

public class QuickSort {

    public void quickSort(int[] inputArr, int si, int ei) {
        if (si < ei) {
            int pivotIndex = getPivotIndexAsSi(inputArr, si, ei);
            quickSort(inputArr, si, pivotIndex - 1);
            quickSort(inputArr, pivotIndex + 1, ei);
        }
    }

    private int getPivotIndex(int[] inputArr, int si, int ei) {
        int pivot = inputArr[ei];
        int i = (si - 1);
        for (int j = si; j <= ei; j++) {
            if (inputArr[j] < pivot) {
                swap(inputArr, ++i, j);
            }
        }
        swap(inputArr, ++i, ei);
        return i;
    }

    private int getPivotIndexAsEi(int[] inputArr, int si, int ei) {
        int pivot = inputArr[ei];
        int i = si;
        for (int j = si; j < ei; j++) {
            if (inputArr[j] < pivot) {
                swap(inputArr, i++, j);
            }
        }
        swap(inputArr, i, ei);
        return i;
    }

    private int getPivotIndexAsSi(int[] arr, int si, int ei) {
        int pivot = arr[si];
        int i = ei;
        for (int j = ei; j > si; j--) {
            if (arr[j] < pivot) {
                swap(arr, i--, j);
            }
        }
        swap(arr, si, i);
        return i;
    }

    private void swap(int[] inputArr, int i, int j) {
        int temp = inputArr[i];
        inputArr[i] = inputArr[j];
        inputArr[j] = temp;
    }
}
