package arrays;

/**
 * Leetcode: <a href="https://leetcode.com/problems/maximum-subarray/description/">Maximum Subarray</a>
 */
public class A4_MaximumSubArraySum {

    int[] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

    int maxSubarraySumBrute(int[] A) {
        int maxSum = 0;
        int[] prefix = new int[A.length];
        prefix[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            prefix[i] = prefix[i - 1] + A[i];
        }

        // Outer loop will have sum till i
        // Inner loop will have sum till j
        // Sum till j - sum till i, will give sum of that subarray.
        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                int currentSum = (i == 0) ? prefix[j] : prefix[j] - prefix[i - 1];
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        return maxSum;
    }
}

/*
    Given an integer array nums, find the subarray with the largest sum, and return its sum.

    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6
    Explanation: The subarray [4,-1,2,1] has the largest sum 6.

    1 <= nums.length <= 105
    -104 <= nums[i] <= 104
 */
