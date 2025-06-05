package slidingwindow;

import java.util.Arrays;

/**
 * Problem Statement: Given a binary array data of length n (containing 0s and 1s). In one move, you can swap any two elements.
 * Find the minimum number of swaps required so that all the 1's in the array are grouped together (appear consecutively).
 * Return 0 if already grouped.
 * <p>
 * Understanding the Goal: We want all the '1's to form a contiguous block.
 * This block can be anywhere in the array. For example, [0, 0, 1, 1, 1, 0, 0] is a valid grouping.
 * <p>
 * Key Insight:
 * The crucial observation is that if we want to group all the '1's together, they will occupy a contiguous window of length
 * equal to the total count of '1's in the array. For example, if there are countOfOnes = 3 ones, they will eventually
 * form a block of [1, 1, 1] somewhere.
 * <p>
 * The minimum number of swaps to group ones is equivalent to finding a window of size countOfOnes that contains the maximum number of ones.
 * Why? Because if we find a window with maxOnesInWindow ones, then the number of zeros inside that window is countOfOnes - maxOnesInWindow.
 * These are the zeros that need to be swapped out of the window, and an equal number of ones need to be swapped into the window from outside.
 * Each such swap effectively brings one '1' into the desired window and moves one '0' out, contributing to the grouping. Therefore,
 * the minimum swaps will be totalCountOfOnes - maxOnesInWindow.
 */
public class SW6_MinSwapsToGroupOnes {

    public int minSwapsBruteBetter(int[] A) {
        int totalOnes = (int) Arrays.stream(A)
                .sum();

        if (totalOnes <= 1 || totalOnes == A.length) return 0;

        int maxWindowOnes = 0;
        int currentWindowOnes = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) {
                currentWindowOnes++;
            }

            if (i >= totalOnes - 1) {
                maxWindowOnes = Math.max(maxWindowOnes, currentWindowOnes);
                if (A[i - totalOnes + 1] == 1) {
                    currentWindowOnes--;
                }
            }
        }
        return totalOnes - maxWindowOnes;
    }

    // Time Complexity: O(N * totalOnes), where N is the length of data. In the worst case, totalOnes can be close to N, making it O(N^2).
    public int minSwapsBruteForce(int[] A) {
        int totalOnes = (int) Arrays.stream(A)
                .filter(bit -> bit == 1)
                .count();

        if (totalOnes <= 1 || totalOnes == A.length) return 0;

        int maxWindowOnes = 0;
        for (int i = 0; i <= A.length - totalOnes; i++) {
            int currentWindowOnes = 0;
            for (int j = i; j < i + totalOnes; j++) {
                if (A[j] == 1) {
                    currentWindowOnes++;
                }
                maxWindowOnes = Math.max(maxWindowOnes, currentWindowOnes);
            }
        }

        return totalOnes - maxWindowOnes;
    }
}
