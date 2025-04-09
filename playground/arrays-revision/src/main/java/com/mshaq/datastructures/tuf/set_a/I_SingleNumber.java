package com.mshaq.datastructures.tuf.set_a;

public class I_SingleNumber {

    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }
}
