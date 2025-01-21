package org.mshaq.ds.arrays;

public class ContainerWithMostWater {

    public static int getContainerWithMostWater(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int containersDis = j - i;
                int minContainerHeight = Math.min(nums[i], nums[j]);
                result = Math.max(result, minContainerHeight * containersDis);
            }
        }
        return result;
    }

    public static int getContainerWithMostWaterO(int[] nums) {
        int result = Integer.MIN_VALUE;
        int p1 = 0;
        int p2 = nums.length - 1;
        while (p1 < p2) {
            int containersDis = p2 - p1;
            int minContainerHeight = Math.min(nums[p1], nums[p2]);
            result = Math.max(result, minContainerHeight * containersDis);

            if (p1 < p2) {
                p1++;
            } else {
                p2--;
            }
        }
        return result;
    }
}
