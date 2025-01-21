package org.mshaq.ds.greedy;

import java.util.Arrays;

public class D_ValidParenthesis {


    public boolean isValid(String s, int n) {
        int min = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                min++;
                max++;
            } else if (ch == ')') {
                min--;
                max--;
            } else {
                min--;
                max++;
            }

            if (max < 0) return false;
            if (min < 0) min = 0;
        }
        return min == 0;
    }

    public boolean isValid(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(s, 0, 0, dp);
    }


    // ()**()
    private boolean f(String s, int index, int range) {
        if (range < 0) {
            return false;
        }

        if (index == s.length()) {
            return range == 0;
        }

        char ch = s.charAt(index);
        boolean result = false;
        if (ch == '(') {
            result = f(s, index + 1, range + 1);
        } else if (ch == ')') {
            result = f(s, index + 1, range - 1);
        } else {
            for (int i = -1; i <= 1; i++) {
                result = result || f(s, index + 1, range + i);
            }
        }
        return result;
    }

    private boolean f(String s, int index, int range, int[][] dp) {
        if (range < 0) {
            return false;
        }

        if (index == s.length()) {
            return range == 0;
        }

        if (dp[index][range] != -1) {
            return dp[index][range] == 1;
        }

        char ch = s.charAt(index);
        boolean result = false;
        if (ch == '(') {
            result = f(s, index + 1, range + 1, dp);
        } else if (ch == ')') {
            result = f(s, index + 1, range - 1, dp);
        } else {
            for (int i = -1; i <= 1; i++) {
                result = result || f(s, index + 1, range + i, dp);
            }
        }
        dp[index][range] = result ? 1 : 0;
        return result;
    }
}
