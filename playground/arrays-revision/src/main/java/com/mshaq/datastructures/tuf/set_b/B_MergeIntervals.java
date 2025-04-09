package com.mshaq.datastructures.tuf.set_b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B_MergeIntervals {

    public int[][] merge(int[][] A) {

        Arrays.sort(A, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> list = new ArrayList<>();
        int[] previous = A[0];
        list.add(previous);

        for (int[] current : A) {
            if (current[0] <= previous[1]) {
                previous[1] = Math.max(previous[1], current[1]);
            } else {
                previous = current;
                list.add(previous);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

}
