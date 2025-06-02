package slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem Statement: Given an array of integers nums and an array goodNumbers, return the maximum number of
 * <b>consecutive</b> "good" numbers in nums. A number is "good" if it is present in the goodNumbers array.
 * <p>
 * Input: nums = [1, 2, 3, 5, 4, 5, 1], goodNumbers = [3, 5]
 * <p>
 * Output: 2
 * <p>
 * Explanation: [1, 2, 3, 5, 4, 5, 1] the underlined numbers are all good numbers and give the maximum length.
 * <p>
 * TUF: <a href="https://takeuforward.org/plus/dsa/problems/maximum-consecutive-good-numbers">Maximum Consecutive Good Numbers</a>
 */
public class SW1_MaxConsecutiveGoodNums {

    public int maxConsecutiveGoodNumbersOptimal(int[] N, int[] G) {
        Set<Integer> hashSet = new HashSet<>(G.length);
        for (int goodNumbers : G) {
            hashSet.add(goodNumbers);
        }

        int maxConsecutive = 0, consecutive = 0;
        for (int number : N) {
            if (!hashSet.contains(number)) {
                consecutive = 0;
                continue;
            }
            consecutive += 1;
            maxConsecutive = Math.max(maxConsecutive, consecutive);
        }
        return maxConsecutive;
    }

    public int maxConsecutiveGoodNumbersBetter(int[] N, int[] G) {
        Set<Integer> set = new HashSet<>(G.length);
        for (int goodNumber : G) {
            set.add(goodNumber);
        }

        int maxConsecutive = 0;
        for (int i = 0; i < N.length; i++) {
            int consecutive = 0;
            for (int j = i; j < N.length; j++) {
                if (!set.contains(N[j])) break;
                consecutive++;
            }
            maxConsecutive = Math.max(maxConsecutive, consecutive);
        }
        return maxConsecutive;
    }

    public int maxConsecutiveGoodNumbersBruteForce(int[] nums, int[] goodNumbers) {
        Set<Integer> goodNumSet = new HashSet<>(2);
        for (int goodNumber : goodNumbers) {
            goodNumSet.add(goodNumber);
        }
        int maxConsecutive = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                boolean isGoodNumber = true;
                for (int k = i; k <= j; k++) {
                    if (!goodNumSet.contains(nums[k])) {
                        isGoodNumber = false;
                        break;
                    }
                }

                if (isGoodNumber) {
                    maxConsecutive = Math.max(maxConsecutive, j - i + 1);
                }
            }
        }
        return maxConsecutive;
    }
}

/*
    Saw two arrays and wondered how it could be solved
    Couldn't think of using set initially
    Must consider solving Max Consecutive ones first

    Sliding window with one pass,
    keep sliding window until true, once false reset window
    search where to start other window

    nums = [1, 2, 10, 11, 3, 4, 20, 21, 22]
    goodNumbers = [10, 11, 20, 21, 22]

    nums = [5, 5, 5, 5, 5]
    goodNumbers = [5]

    nums = [1, 2, 3, 4, 5]
    goodNumbers = [3, 5, 3]
 */
