package com.mshaq.datastructures.tuf.set_b;

public class G_ReversePairs {


    public int reversePairs(int[] A) {
        return (int) mergeSort(A, 0, A.length - 1);
    }

    private long mergeSort(int[] A, int si, int ei) {
        long count = 0;
        if (si < ei) {
            int middle = si + (ei - si) / 2;
            count += mergeSort(A, si, middle);
            count += mergeSort(A, middle + 1, ei);
            count += countPairs(A, si, middle, ei);
            merge(A, si, middle, ei);
        }

        return count;
    }

    private long countPairs(int[] A, int si, int mi, int ei) {
        int right = mi + 1;
        long count = 0;
        for (int i = si; i <= mi; i++) {

            while (right <= ei && A[i] > (long) 2 * A[right]) right++;

            count += (right - mi + 1);
        }
        return count;
    }

    private void merge(int[] A, int si, int mi, int ei) {
        int[] tempArray = new int[ei - si + 1];

        int tempIdx = 0;
        int srcArrIdx = si;
        int destArrIdx = mi + 1;
        while (srcArrIdx <= mi && destArrIdx <= ei) {
            if (A[srcArrIdx] <= A[destArrIdx]) {
                tempArray[tempIdx++] = A[srcArrIdx++];
            } else {
                tempArray[tempIdx++] = A[destArrIdx++];
            }
        }

        while (srcArrIdx <= mi) {
            tempArray[tempIdx++] = A[srcArrIdx++];
        }

        while (destArrIdx <= ei) {
            tempArray[tempIdx++] = A[destArrIdx++];
        }

//        for (int i = 0, j = si; i < tempArray.length; i++, j++) {
//            A[j] = tempArray[i];
//        }

        System.arraycopy(tempArray, 0, A, si, ei - si + 1);
    }

}
