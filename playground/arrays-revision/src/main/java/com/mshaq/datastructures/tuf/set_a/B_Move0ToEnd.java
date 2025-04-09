package com.mshaq.datastructures.tuf.set_a;

public class B_Move0ToEnd {

    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i++] = nums[j];
            }
        }

        for (int j = i; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

    public void moveZeroesO(int[] A) {
        int i = -1;
        for (int j = 0; j < A.length; j++) {
            if (A[j] == 0 && i == -1) {
                i = j;
            } else if (A[j] != 0 && i != -1) {
                A[i] = A[j];
                A[j] = 0;
                i++;
            }
        }
    }
}
