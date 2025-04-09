package com.mshaq.datastructures.tuf.set_b;

public class F_CountInversion {


    public int countInversion(int[] A) {
        return mergeSort(A, 0, A.length - 1);
    }

    private int mergeSort(int[] A, int si, int ei) {
        int count = 0;
        if (si < ei) {
            int middle = si + (ei - si) / 2;
            count += mergeSort(A, si, middle);
            count += mergeSort(A, middle + 1, ei);
            count += merge(A, si, middle, ei);
        }

        return count;
    }

    private int merge(int[] A, int si, int mi, int ei) {
        int[] tempArray = new int[ei - si + 1];

        int tempIdx = 0;
        int srcArrIdx = si;
        int destArrIdx = mi + 1;

        int count = 0;
        while (srcArrIdx <= mi && destArrIdx <= ei) {
            if (A[srcArrIdx] <= A[destArrIdx]) {
                tempArray[tempIdx++] = A[srcArrIdx++];
            } else {
                tempArray[tempIdx++] = A[destArrIdx++];
                count += (mi - srcArrIdx + 1);
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

        return count;
    }

}
