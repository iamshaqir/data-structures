package com.mshaq.datastructures.tuf.set_a;

public class A_RemoveDuplicatesSortedArray {

    // In place
    public int removeDuplicates(int[] A) {
        int j = 1;

        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[i - 1]) {
                A[j] = A[i];
                j++;
            }
        }
        return j;
    }
}
