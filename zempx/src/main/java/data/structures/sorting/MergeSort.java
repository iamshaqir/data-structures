package com.ms.data.structures.sorting;

public class MergeSort {


    public void divide(int[] inputArr, int si, int ei) {
        if (si < ei) {
            int mi = si + (ei - si) / 2;
            divide(inputArr, si, mi);
            divide(inputArr, mi + 1, ei);
            conquer(inputArr, si, mi, ei);
        }
    }

    private void conquer(int[] inputArr, int si, int mi, int ei) {
        int[] tempArray = new int[ei - si + 1];

        int tempIdx = 0;
        int srcArrIdx = si;
        int destArrIdx = mi + 1;

        while (srcArrIdx <= mi && destArrIdx <= ei) {
            if (inputArr[srcArrIdx] <= inputArr[destArrIdx]) {
                tempArray[tempIdx++] = inputArr[srcArrIdx++];
            } else {
                tempArray[tempIdx++] = inputArr[destArrIdx++];
            }
        }

        while (srcArrIdx <= mi) {
            tempArray[tempIdx++] = inputArr[srcArrIdx++];
        }

        while (destArrIdx <= ei) {
            tempArray[tempIdx++] = inputArr[destArrIdx++];
        }

        for (int i = 0, j = si; i < tempArray.length; i++, j++) {
            inputArr[j] = tempArray[i];
        }
    }
}
