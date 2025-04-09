package com.mshaq.datastructures.tuf.set_a;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q_LongestSubsequence {

    public static int getLongestSubsequence(int[] A) {

        int count = 0;
        for (int i = 0; i < A.length; i++) {
            int currentCount = 1;
            int target = A[i];
            while (search(A, target + 1)) {
                currentCount = currentCount + 1;
                target = target + 1;
            }
            count = Math.max(count, currentCount);
        }
        return count;
    }

    private static boolean search(int[] A, int target) {
        for (int element : A) {
            if (element == target) return true;
        }
        return false;
    }

    public int longestConsecutive(int[] A) {
        if (A.length == 0) return 0;
        Arrays.sort(A);
        // {1, 1, 1, 2, 3, 4, 100, 101, 102}
        int longestCount = 1;
        int currentCount = 0;
        int smallerElement = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i] - 1 == smallerElement) {
                currentCount = currentCount + 1;
            } else if (A[i] != smallerElement) {
                currentCount = 1;
            }
            smallerElement = A[i];
            longestCount = Math.max(longestCount, currentCount);
        }
        return longestCount;
    }

    public int longestSubsequenceO(int[] A) {
        if (A.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (Integer element : A) {
            set.add(element);
        }
        int longest = 0;
        for (int element : A) {
            if (!set.contains(element - 1)) {
                int currentCount = 1;
                while (set.contains(element + currentCount)) {
                    currentCount = currentCount + 1;
                }
                longest = Math.max(longest, currentCount);
            }
        }
        return longest;
    }

    // Input nums = {102, 4, 100, 1, 101, 3, 2, 1, 1}
    // Output = 4

    public static void main(String[] args) {
        int[] A = {1, 3, 2, 4, 5, 6};
        int longestSubsequence = getLongestSubsequence(A);
    }
}

