package org.mshaq.ds.dp_subsequences;

import java.util.Arrays;

public class PartitionMinDifference {

    // We can use subset sum k problem here, 2D dp array's
    // last index position will have the possible sum values of k elements
    private static class Tabulation {

        public int minimumDifference(int[] A) {

            int sum = Arrays.stream(A).sum();

            int n = A.length;
            int k = sum;
            boolean[] previous = new boolean[sum + 1];
            previous[0] = true;
            if (k >= A[0]) previous[A[0]] = true;

            // find positions for possible sum values
            for (int index = 1; index < n; index++) {
                boolean[] current = new boolean[k + 1];
                current[0] = true;
                for (int target = 1; target <= k; target++) {
                    boolean notInclude = previous[target];
                    boolean include = false;
                    if (target >= A[index]) {
                        include = previous[target - A[index]];
                    }
                    current[index] = include || notInclude;
                }
                previous = current;
            }

            // find minimum
            int minimum = Integer.MAX_VALUE;
            for (int i = 0; i < k / 2; i++) {
                if (previous[i]) {
                    minimum = Math.min(minimum, Math.abs(i - (sum - i)));
                }
            }

            return minimum;

        }
    }
}
