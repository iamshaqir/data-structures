package org.mshaq.ds;

public class M02_JumpGame2 {

    public static int jump(int[] A) {
        int jumps = 0;
        int left = 0, right = 0;

        while (right < A.length) {
            int farthest = Integer.MIN_VALUE;
            for (int i = left; i <= right; i++) {
                farthest = Math.max(farthest, i + A[i]);
            }
            left = right + 1;
            right = farthest;
            jumps += 1;
        }
        return jumps;
    }
}
