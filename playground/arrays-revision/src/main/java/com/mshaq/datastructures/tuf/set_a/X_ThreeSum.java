package com.mshaq.datastructures.tuf.set_a;

import java.util.*;

public class X_ThreeSum {


    public List<List<Integer>> threeSumB(int[] A) {
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            Set<Integer> hash = new HashSet<>();

            for (int j = i + 1; j < A.length; j++) {

                // this is the third element, if found
                int k = -(A[i] + A[j]);
                if (hash.contains(k)) {
                    List<Integer> list = Arrays.asList(A[i], A[j], k);
                    list.sort(Comparator.naturalOrder());
                    set.add(list);
                }

                // if not found add previous, it could be third for next elements
                hash.add(A[j]);
            }

        }
        return new ArrayList<>(set);
    }


    // Input: {2,-2,0,1,2,-2,0,1,2,-2,0,1,2}

    public List<List<Integer>> threeSum(int[] A) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(A);
        // -2,-2,-2,0,0,0,1,1,1,2,2,2,2

        for (int i = 0; i < A.length; i++) {
            //skip duplicates
            if (i != 0 && A[i] == A[i - 1]) continue;
            int j = i + 1;
            int k = A.length - 1;

            while (j < k) {
                int sum = A[i] + A[j] + A[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    set.add(List.of(A[i], A[j], A[k]));
                    j++;
                    k--;

                    // Skip duplicates
                    while (j < k && A[j] == A[j - 1]) j++;
                    while (j < k && A[k] == A[k + 1]) k--;
                }
            }
        }
        return new ArrayList<>(set);
    }
}
