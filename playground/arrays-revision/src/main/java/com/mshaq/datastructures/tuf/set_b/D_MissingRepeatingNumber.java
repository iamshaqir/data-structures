package com.mshaq.datastructures.tuf.set_b;

import java.util.ArrayList;

public class D_MissingRepeatingNumber {


    ArrayList<Integer> findTwoElement(int[] arr) {

        int missingNumber = 0;
        int repeatingNumber = 0;
        ArrayList<Integer> resultList = new ArrayList<>(2);
        int[] hash = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }

        for (int i = 1; i < hash.length; i++) {
            if (hash[i] == 0) {
                missingNumber = i;
            } else if (hash[i] > 1) {
                repeatingNumber = i;
            }
        }

        resultList.add(repeatingNumber);
        resultList.add(missingNumber);
        return resultList;
    }

    ArrayList<Integer> findTwoElementO(int[] A) {

        int n = A.length;
        int sum = (n * (n + 1)) / 2;
        int squareSum = (n * (n + 1) * (2 * n + 1)) / 6;

        int arrSum = 0, arrSquareSum = 0;
        for (int element : A) {
            arrSum += element;
            arrSquareSum += element * element;
        }

        return getResultList(arrSum, sum, arrSquareSum, squareSum);
    }

    private static ArrayList<Integer> getResultList(int arrSum, int sum, int arrSquareSum, int squareSum) {
        int val1 = arrSum - sum; // X - Y
        int val2 = arrSquareSum - squareSum; // X^2 - Y^2

        // X^2 - Y^2  = val2
        // (X + Y)(X - Y) = val2
        // X + Y = val2 / (X - Y)

        val2 = val2 / val1; // X + Y

        // X - Y = val1
        // X + Y = val2
        // 2X = val1 + val2 => X = (val1 + val2) / 2

        int repeatingNumber = (val1 + val2) / 2; // X
        int missingNumber = repeatingNumber - val1; // Y, Using X - Y = val1

        ArrayList<Integer> resultList = new ArrayList<>(2);
        resultList.add(repeatingNumber);
        resultList.add(missingNumber);
        return resultList;
    }

    // Input: arr[] = [4, 3, 6, 2, 1, 1]
    // Output: [1, 5]
}
