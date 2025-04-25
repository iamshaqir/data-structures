package org.mshaq.ds;


import java.util.Arrays;

/**
 * GeeksForGeeks:<a href="https://www.geeksforgeeks.org/problems/smallest-number5829/1">Smallest number</a>
 */
public class M16_SmallestNumber {


    /**
     * Given two numbers s and d
     * Find the smallest number such that sum of it is s and number of digits in it are d
     */
    public static void main(String[] args) {
        // Input s = 20 and d = 4
        int s = 4, d = 5;
        String smallestNumber = smallestNumber(s, d);
        System.out.println(smallestNumber);
    }

    public static String smallestNumber(int s, int d) {
        // Edge case, example maximum sum can be only 36 for 4 digits 9*4=36
        if (s < 1 || s > 9 * d) return "-1";

        char[] smallestNum = new char[d];
        Arrays.fill(smallestNum, '0');
        // First digit will always be 1, so reduce 1 and add at the end using `1`
        s--;

        for (int i = d - 1; i > 0; i--) {
            if (s > 9) {
                smallestNum[i] = '9';
                s -= 9;
            } else {
                smallestNum[i] = (char) ('0' + s);
                s = 0;
            }
        }
        smallestNum[0] = (char) ('1' + s);
        return String.valueOf(smallestNum);
    }

}