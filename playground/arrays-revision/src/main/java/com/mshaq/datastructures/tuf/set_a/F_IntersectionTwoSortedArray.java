package com.mshaq.datastructures.tuf.set_a;

import java.util.ArrayList;
import java.util.List;

public class F_IntersectionTwoSortedArray {

    public List<Integer> intersection(int[] A, int[] B) {

        int n1 = A.length;
        int n2 = B.length;
        int i = 0, j = 0;

        List<Integer> result = new ArrayList<>();
        while (i < n1 && j < n2) {

            if (A[i] < B[j]) {
                i++;
            } else if (B[j] < A[i]) {
                j++;
            } else {
                result.add(A[i]);
                i++;
                j++;
            }
        }
        return result;
    }
}
