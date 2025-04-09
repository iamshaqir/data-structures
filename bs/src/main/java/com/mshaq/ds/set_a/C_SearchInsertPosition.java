package com.mshaq.ds.set_a;

public class C_SearchInsertPosition {

    public int searchInsert(int[] A, int target) {
        int si = 0, ei = A.length - 1;
        int ans = A.length;
        while (si <= ei) {
            int mi = si + (ei - si) / 2;
            if (A[mi] >= target) {
                ans = mi;
                ei = mi - 1;
            } else {
                si = mi + 1;
            }
        }
        return ans;
    }
}

/**
 * Example 1:
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * <p>
 * Example 2:
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * <p>
 * Example 3:
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 */
