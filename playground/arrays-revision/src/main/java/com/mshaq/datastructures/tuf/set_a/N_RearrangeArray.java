package com.mshaq.datastructures.tuf.set_a;

import java.util.ArrayList;
import java.util.List;

public class N_RearrangeArray {

    public int[] rearrangeArray(int[] A) {
        int length = A.length;
        int[] positive = new int[length / 2];
        int[] negative = new int[length / 2];

        // Separate positive and negative elements
        int p = 0, n = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) {
                negative[n++] = A[i];
            } else {
                positive[p++] = A[i];
            }
        }

        // Positive elements will be at even position
        for (int i = 0; i < length / 2; i++) {
            A[2 * i] = positive[i];
            A[2 * i + 1] = negative[i];
        }

        return A;
    }

    public int[] rearrangeArrayBetter(int[] A) {
        int length = A.length;
        int[] result = new int[length];

        int positive = 0, negative = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                result[positive] = A[i];
                positive += 2;
            } else {
                result[negative] = A[i];
                negative += 2;
            }
        }
        return result;
    }

    // Other variety when positives != negative
    public int[] rearrangeArrayPneN(int[] A) {
        int length = A.length;
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        // Separate positive and negative elements
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) {
                negative.add(A[i]);
            } else {
                positive.add(A[i]);
            }
        }

        int minSize = Math.min(positive.size(), negative.size());

        // Same elements
        for (int i = 0; i < minSize; i++) {
            A[2 * i] = positive.get(i);
            A[2 * i + 1] = negative.get(i);
        }

        // Left over Positives
        for (int i = minSize; i < positive.size(); i++) {
            A[i] = positive.get(i);
        }

        // Left over Negatives
            for (int i = minSize; i < negative.size(); i++) {
            A[i] = negative.get(i);
        }

        return A;
    }


    // Input: nums = [3,1,-2,-5,2,-4]
    // Output: [3,-2,1,-5,2,-4]
}
