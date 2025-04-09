package com.mshaq.datastructures.tuf.set_a;

import java.util.ArrayList;

public class E_UnionTwoSortedArray {


    // Input: a[] = [1, 2, 3, 4, 5], b[] = [1, 2, 3, 6, 7]
    // Output: 1 2 3 4 5 6 7
    public static ArrayList<Integer> findUnion(int[] A, int[] B) {
        ArrayList<Integer> res = new ArrayList<>();

        int n1 = A.length;
        int n2 = B.length;

        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (A[i] <= B[j]) {
                if (res.isEmpty() || res.get(res.size() - 1) != A[i]) {
                    res.add(A[i]);
                }
                i++;
            } else {
                if (res.isEmpty() || res.get(res.size() - 1) != B[j]) {
                    res.add(B[j]);
                }
                j++;
            }
        }

        while (i < n1) {
            if (res.get(res.size() - 1) != A[i]) {
                res.add(A[j]);
            }
            i++;
        }

        while (j < n2) {
            if (res.get(res.size() - 1) != B[j]) {
                res.add(B[j]);
            }
            j++;
        }
        return res;
    }
}
