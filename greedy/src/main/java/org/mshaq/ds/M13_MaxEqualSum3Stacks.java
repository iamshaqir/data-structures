package org.mshaq.ds;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class M13_MaxEqualSum3Stacks {


    public static int maxSum(int[] A, int[] B, int[] C) {
        int aSum = IntStream.of(A).sum();
        int bSum = IntStream.of(B).sum();
        int cSum = IntStream.of(C).sum();

        int aIdx = 0, bIdx = 0, cIdx = 0;

        while (true) {
            // If one stack is finished no Max sum found
            if (aIdx == A.length || bIdx == B.length || cIdx == C.length) return 0;

            if (aSum == bSum && bSum == cSum) return aSum;

            // Remove the top element of the stack having the maximum sum among three of stacks.
            if (aSum >= bSum && aSum >= cSum) {
                aSum -= A[aIdx++];
            } else if (bSum >= aSum && bSum >= cSum) {
                bSum -= B[bIdx++];
            } else {
                cSum -= C[cIdx++];
            }
        }
    }

    public static int maxSumUsingSuffixSum(int[] A, int[] B, int[] C) {

        int temp = 0;
        Set<Integer> aSuffixSum = new HashSet<>();
        for (int i = A.length - 1; i >= 0; i--) {
            temp += A[i];
            aSuffixSum.add(temp);
        }

        temp = 0;
        Set<Integer> bSuffixSum = new HashSet<>();
        for (int i = B.length - 1; i >= 0; i--) {
            temp += A[i];
            bSuffixSum.add(temp);
        }

        int n = C.length;
        int[] cSuffix = new int[n];
        cSuffix[n - 1] = C[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            cSuffix[i] = C[i] + cSuffix[i + 1];
        }

        for (int element : cSuffix) {
            if (aSuffixSum.contains(element) && bSuffixSum.contains(element)) return element;
        }
        return 0;
    }
}
