package com.mshaq.ds.set_a;

public class B_FloorAndCeil {

    public int[] floorAndCeil(int[] A, int k) {
        int floor = Integer.MIN_VALUE;
        int ceil = Integer.MAX_VALUE;

        for (int element : A) {
            if (element <= k && element > floor) floor = element;
            if (element >= k && element < ceil) ceil = element;
        }

        floor = (floor == Integer.MIN_VALUE) ? -1 : floor;
        ceil = (ceil == Integer.MAX_VALUE) ? -1 : ceil;

        return new int[]{floor, ceil};
    }
}

/**
 * Input: x = 7 , arr[] = [5, 6, 8, 9, 6, 5, 5, 6]
 * Output: 6, 8
 * Explanation: Floor of 7 is 6 and ceil of 7 is 8.
 */
