package org.mshaq.ds.arrays;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class E_LongestConsecutiveSequence {

    public static int getBr(int[] nums) {

        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int tempLength = 1;
            while (isPresent(nums, x + 1)) {
                x++;
                tempLength++;
            }
            length = Math.max(tempLength, length);
        }
        return 0;
    }

    private static boolean isPresent(int[] nums, int i) {
        for (int num : nums) {
            if (num == i) {
                return true;
            }
        }
        return false;
    }

    public static int getBet(int[] nums) {
        Arrays.sort(nums);
        int p1 = 0;
        int p2 = 1;
        int length = 1;
        int tempLength = 1;
        if (nums.length == 0) {
            return 0;
        }

        while (p2 < nums.length) {

            int x = nums[p1];
            if (x + 1 == nums[p2]) {
                tempLength++;
                p1++;
            } else if (nums[p1] != nums[p2]) {
                tempLength = 1;
                p1 = p2;
            }
            p2++;
            length = Math.max(length, tempLength);
        }
        return length;
    }

    public static int getBEA(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int lastSmaller = Integer.MIN_VALUE;
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            int tempLength = 1;
            if (nums[i] - 1 == lastSmaller) {
                tempLength += 1;

            } else if (nums[i] != lastSmaller) {
                tempLength = 1;
            }
            lastSmaller = nums[i];
            length = Math.max(length, tempLength);
        }
        return length;
    }

    public static int getO(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        int length = 0;
        for (int num : nums) {
            int tempLength = 1;
            int x = num;
            while (set.contains(--x)) {
                tempLength++;
                set.remove(x);
            }

            x = num;
            while (set.contains(x++)) {
                tempLength++;
                set.remove(x);
            }
            length = Math.max(length, tempLength);
        }
        return length;
    }

}
