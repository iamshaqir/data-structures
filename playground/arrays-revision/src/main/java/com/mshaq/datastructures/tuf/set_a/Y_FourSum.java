package com.mshaq.datastructures.tuf.set_a;

import java.util.*;

public class Y_FourSum {

    public List<List<Integer>> fourSum(int[] A, int target) {

        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(A);

        for (int i = 0; i < A.length; i++) {
            // Skip duplicates
            if (i != 0 && A[i] == A[i - 1]) continue;
            for (int j = i + 1; j < A.length; j++) {
                // Skip duplicates
                if (j != i + 1 && A[j] == A[j - 1]) continue;

                // Two pointers
                int k = j + 1;
                int l = A.length - 1;

                while (k < l) {
                    int sum = A[i] + A[j] + A[k] + A[l];
                    if (sum == target) {
                        set.add(Arrays.asList(A[i], A[j], A[k], A[l]));
                        k++;
                        l--;

                        // Skip duplicates
                        while (k < l && A[k] == A[k - 1]) k++;
                        while (k < l && A[l] == A[l + 1]) l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
}
