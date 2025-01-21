package org.mshaq.ds.arrays;

public class B_MaxAndMinElements {

    public int[] getMaxMin(int[] input) {
        // {8, 5, 9, 15, 78, 96, 25, 45, 85, 99}

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : input) {
            min = Math.min(i, min);
            max = Math.max(i, max);
        }
        return new int[]{min, max};
    }
}
