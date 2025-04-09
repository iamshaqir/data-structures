package com.mshaq.datastructures.tuf.set_a;

import java.util.HashMap;
import java.util.Map;

public class U_SubArrayEqualsSum {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for (int num : nums) {
            sum += num;

            // Similar to Two Sum, Total - k = diff
            int diff = sum - k;
            count += map.getOrDefault(diff, 0);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
