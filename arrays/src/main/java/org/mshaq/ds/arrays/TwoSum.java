package org.mshaq.ds.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    // 2 7 11 15
    public static int[] twoSumSorted(int[] nums, int target) {
        int si = 0;
        int ei = nums.length - 1;
        while (si <= ei) {
            int sum = nums[si] + nums[ei];
            if (sum == target) {
                return new int[]{si, ei};
            }

            if (sum < target) {
                si++;
            } else {
                ei--;
            }
        }
        return null;
    }
}
