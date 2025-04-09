package com.mshaq.datastructures.apnacollege.set_a;

public class A_MaximumSubArraySum {

    /**
     * Using merge sort algorithm to divide,<code></code> then add individual element and find maximum of sub array
     *
     * @param A
     * @return maximumSum
     */
    public static int maxSubArray(int[] A) {
        return mergeSort(A, 0, A.length - 1);
    }

    private static int mergeSort(int[] A, int start, int end) {
        if (start == end) {
            return A[start];
        }

        int middle = start + (end - start) / 2;
        int left = mergeSort(A, start, middle);
        int right = mergeSort(A, middle + 1, end);
        int maxSum = merge(A, start, middle, end);

        return Math.max(Math.max(left, right), maxSum);
    }

    private static int merge(int[] A, int start, int middle, int end) {

        int sum = 0;
        int leftMax = Integer.MIN_VALUE;

        for (int i = middle; i >= start; i--) {
            sum += A[i];
            leftMax = Math.max(leftMax, sum);
        }

        sum = 0;
        int rightMax = Integer.MIN_VALUE;

        for (int i = middle + 1; i <= end; i++) {
            sum += A[i];
            rightMax = Math.max(rightMax, sum);
        }

        return leftMax + rightMax;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSubArray = maxSubArray(nums);
        System.out.printf("Max Subarray Sum: %s%n", maxSubArray);
    }

    /**
     *
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
     */
}
