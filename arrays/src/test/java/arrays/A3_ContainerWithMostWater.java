package arrays;

import org.junit.jupiter.api.Test;

/**
 * <a href="https://leetcode.com/problems/container-with-most-water/">Container With Most Water</a>
 */
public class A3_ContainerWithMostWater {

    int[] H1 = {1, 8, 6, 2, 5, 4, 8, 3, 7}; // 49
    int[] H2 = {1,2,1}; // 2
    int[] H3 = {1,2,4,3}; // 4
    int[] H4 = {1, 1}; // 1
    int[] H = {0, 0}; // 0

    @Test
    void mostWaterBetter() {
        int mostWaterBetter = mostWaterBetter(H);
        System.out.println("Max water Better: " + mostWaterBetter);
    }

    int mostWaterBetter(int[] H) {
        int maxWater = 0;
        int left = 0, right = H.length - 1;

        while (left < right) {
            int distance = right - left;
            int minHeight = Math.min(H[left], H[right]);
            maxWater = Math.max(maxWater, minHeight * distance);

            if (H[left] < H[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }

    @Test
    void mostWaterBrute() {
        int mostWaterBrute = mostWaterBrute(H);
        System.out.println("Max water brute: " + mostWaterBrute);
    }

    int mostWaterBrute(int[] H) {
        int maxWater = 0;
        for (int i = 0; i < H.length; i++) {
            for (int j = i + 1; j < H.length; j++) {

                int containerDistance = j - i;
                int minHeight = Math.min(H[i], H[j]);
                maxWater = Math.max(maxWater, minHeight * containerDistance);
            }
        }
        return maxWater;
    }
}

/*
    You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of
    the ith line are (i, 0) and (i, height[i]).

    Find two lines that together with the x-axis form a container, such that the container contains the most water.
    Return the maximum amount of water a container can store.
    Notice that you may not slant the container.

    Input: height = [1,8,6,2,5,4,8,3,7]
    Output: 49
    Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of
    water (blue section) the container can contain is 49

 */