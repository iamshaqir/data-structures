package com.mshaq.datastructures.tuf.set_a;

public class G_MaxConsecutiveOnes {

    //Input: nums = [1,1,0,1,1,1]
    //Output: 3
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0;
        int tempSum = 0;
        for (int num : nums) {
            if (num == 0) {
                maxOnes = Math.max(maxOnes, tempSum);
                tempSum = 0;
                continue;
            }
            tempSum++;
        }
        return Math.max(maxOnes, tempSum);
    }
}
