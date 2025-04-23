package org.mshaq.ds;


import java.util.Arrays;

/**
 * GeeksForGeeks: <a href="https://www.geeksforgeeks.org/find-maximum-height-pyramid-from-the-given-array-of-objects/">Maximum Height Pyramid</a>
 */
public class M12_MaxHeightPyramid {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int level = maxLevelBs(A);
        System.out.println(level);
    }

    /**
     * Given arrays of elements, find maximum levels can be formed,
     * - ith element should be < i + 1
     * - count if level i should be < i + 1
     */
    public static int maxLevel(int[] A) {

        Arrays.sort(A);

        int result = 0;
        int prev = A[0];
        int prevCount = 1;
        int current = 0;
        int currentCount = 0;
        for (int i = 1; i < A.length; i++) {

            current += A[i];
            currentCount += 1;

            if (current > prev && currentCount > prevCount) {
                result++;
                prev = current;
                prevCount = currentCount;

                current = 0;
                currentCount = 0;
            }
        }
        return result;
    }

    public static int maxLevelBs(int[] A) {
        int startIndex = 0, endIndex = A.length;
        int ans = 0;

        while (startIndex <= endIndex) {
            int middle = startIndex + (endIndex - startIndex) / 2;
            int reqElements = (middle * (middle + 1)) / 2;
            if (reqElements <= A.length) {
                ans = middle;
                startIndex = middle + 1;
            } else {
                endIndex = middle - 1;
            }
        }

        return ans;
    }
}
