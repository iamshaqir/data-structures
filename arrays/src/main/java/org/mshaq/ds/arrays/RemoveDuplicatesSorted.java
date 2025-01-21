package org.mshaq.ds.arrays;

public class RemoveDuplicatesSorted {


    // 1 1 2
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

    // 0 0 1 2 3 3 4
    // 0 1 2 3 4

    public int removeDuplicatesOt(int[] nums) {
        int i = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[j - 1]) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}
