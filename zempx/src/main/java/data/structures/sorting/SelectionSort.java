package com.ms.data.structures.sorting;

/**
 * Selection Sort begins with the element in the 1st position of an unsorted array and scans through
 * subsequent elements to find the smallest element. Once found, the smallest element is swapped
 * with the element in the 1st position.
 */
public class SelectionSort {

    // inputArray = {6, 2, 3, 4, 5, 1}
    public int[] sortAscending(int[] inputArray) {
        for (int i = 0; i < inputArray.length - 1; i++) {
            int minElementIdx = i;
            for (int j = i + 1; j < inputArray.length; j++) {
                if (inputArray[minElementIdx] > inputArray[j]) {
                    minElementIdx = j;
                }
            }
            if (minElementIdx != i) {
                swap(inputArray, i, minElementIdx);
            }
        }
        return inputArray;
    }

    public int[] sortDescending(int[] inputArray) {
        for (int i = 0; i < inputArray.length - 1; i++) {
            int minElementIdx = i;
            for (int j = i + 1; j < inputArray.length; j++) {
                if (inputArray[minElementIdx] < inputArray[j]) {
                    minElementIdx = j;
                }
            }
            if (minElementIdx != i) {
                swap(inputArray, i, minElementIdx);
            }
        }
        return inputArray;
    }

    private void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
