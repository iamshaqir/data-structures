package org.mshaq.ds.arrays;

public class RepeatAndMissingNumber {

    // 3, 1, 2, 5, 3
    // 0, 1, 2, 3, 4, 5
    //    1  1  2     1
    public static int[] get(int[] array, int n) {
        int missingNumber = 0;
        int repeatingNumber = 0;
        int[] tempArray = new int[n + 1];
        for (int i = 0; i < n; i++) {
            tempArray[array[i]]++;
        }

        for (int i = 1; i < tempArray.length; i++) {
            if (tempArray[i] == 0) {
                missingNumber = i;
            } else if (tempArray[i] > 1) {
                repeatingNumber = i;
            }
        }
        return new int[]{missingNumber, repeatingNumber};
    }
}
