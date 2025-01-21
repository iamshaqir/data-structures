package org.mshaq.ds.greedy;

import java.util.Arrays;

public class G_MinimumPlatform {

    public static int findPlatform(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int arrivalIdx = 0;
        int departureIdx = 0;

        int count = 0;
        int noOfPlatforms = 0;

        while (arrivalIdx < arr.length) {

            if (arr[arrivalIdx] <= dep[departureIdx]) {
                arrivalIdx++;
                count++;
            } else {
                departureIdx++;
                count--;
            }
            noOfPlatforms = Math.max(noOfPlatforms, count);
        }
        return noOfPlatforms;
    }
}
