package org.mshaq.ds.dp_subsequences;

public class EqualPartition {
    private static class BasicRecursion {

        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum % 2 != 0) return false;

            int n = nums.length;
            //  find aset subset in the input array whose sum is equal to S/2
            return f(nums, n - 1, sum / 2);
        }

        private boolean f(int[] A, int index, int k) {
            if (k == 0) return true;
            if (index == 0) return A[0] == k;

            boolean notInclude = f(A, index - 1, k);
            boolean include = false;

            if (k >= A[index]) {
                include = f(A, index - 1, k - A[index]);
            }
            return include || notInclude;
        }
    }

    private static class Tabulation {
        public boolean canPartition(int[] A) {
            int sum = 0;
            for (int num : A) {
                sum += num;
            }
            if (sum % 2 != 0) return false;

            int n = A.length;
            int k = sum / 2;

            //  find aset subset in the input array whose sum is equal to S/2
            boolean[] previous = new boolean[k + 1];

            // Base cases
            previous[0] = true;
            if (k >= A[0]) {
                previous[A[0]] = true;
            }

            for (int index = 1; index < n; index++) {
                boolean[] current = new boolean[k + 1];
                current[0] = true;
                for (int target = 1; target <= k; target++) {

                    boolean notInclude = previous[target];
                    boolean include = false;

                    if (target >= A[index]) {
                        include = previous[target - A[index]];
                    }
                    current[target] = include || notInclude;
                }
                previous = current;
            }
            return previous[k];
        }
    }
}
