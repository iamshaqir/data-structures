package com.ms.data.structures.sorting;


public class BubbleSort {

    /**
     *
     * inputArray = {6, 2, 3, 4, 5, 1}
     */
    public int[] sortAscending(int[] input) {

        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i; j < input.length; j++) {
                if (input[i] > input[j]) {
                    swap(input, i, j);
                }
            }
        }
        return input;
    }

    public int[] sortDescending(int[] input) {

        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i; j < input.length; j++) {
                if (input[i] < input[j]) {
                    swap(input, i, j);
                }
            }
        }
        return input;
    }

    private void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

}
