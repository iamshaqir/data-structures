package com.mshaq.datastructures.tuf.set_a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_LeadersInArray {

    public List<Integer> leaders(int[] A) {
        int currMax = Integer.MIN_VALUE;
        List<Integer> result = new ArrayList<>();
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] > currMax) {
                result.add(A[i]);
                currMax = A[i];
            }
        }
        Collections.reverse(result);
        return result;
    }
}
