package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums with positives and negatives and an integer k,
 * return the total number of subarrays whose sum equals to k.
 * <p>
 * TUF: <a href="https://takeuforward.org/plus/dsa/problems/count-subarrays-with-given-sum">Count subarrays with given sum</a>
 */
public class SW4_CountSubArraySumK {


    //[1, 2, 3], k = 3
    public int countSubarraySumK(int[] A, int targetSum) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        // if targetSum is 5 and the first element is 5, currentSum becomes 5. currentSum - targetSum would be 0.
        // Since map[0] is 1, count would correctly increment, identifying the subarray [5] as valid.
        map.put(0, 1);
        int currentSum = 0;

        for (int element : A) {
            currentSum += element;

            int diff = currentSum - targetSum;
            count += map.getOrDefault(diff, 0);

            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }

    // Only positives
    public int countSubarraySumKPositives(int[] A, int k) {

        int count = 0;
        int currentSum = 0;
        int windowStart = 0;

        for (int i = 0; i < A.length; i++) {
            currentSum += A[i];
            while (windowStart <= i && currentSum >= k) {
                if (currentSum == k) count++;
                currentSum -= A[windowStart++];
            }
        }
        return count;
    }
}

/*
    Input: nums = [1, 2, 3], k = 3
    Output: 2

    Input Array: [5, -2, 3, -5, 2, 1, -3, 4, -1, 6, -2, -1], Target Sum: 4
    Output: 10

    Input Array: [-2, -3, -1, -5, 0, -2, -1, -3, -4, -1, -2]. Target Sum: -6
    Output: 6
 */
