package slidingwindow;

/**
 * <a href="https://leetcode.com/problems/minimum-window-substring/description/">Minimum window String</a>
 */
public class SW12_MinimumWindowString {

    String minWindow(String s, String t) {
        int startIndex = -1;
        int minLength = Integer.MAX_VALUE;

        int[] hash = new int[52];
        for (int j = 0; j < t.length(); j++) {
            hash[t.charAt(j) - 'A']++;
        }

        int left = 0;
        int count = 0;
        for (int right = 0; right < s.length(); right++) {
            char charAtRight = s.charAt(right);
            if (hash[charAtRight - 'A'] > 0) count++;
            hash[charAtRight - 'A']--;

            while (count == t.length()) {
                minLength = Math.min(minLength, right - left + 1);
                startIndex = left;

                char charAtLeft = s.charAt(left);
                hash[charAtLeft - 'A']++;

                if (hash[charAtLeft - 'A'] > 0) count--;
                left++;
            }
        }
        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLength);
    }

    String minWindowBrute(String s, String t) {

        int startIndex = -1;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i++) {
            int[] hash = new int[52];
            for (int j = 0; j < t.length(); j++) {
                hash[t.charAt(j) - 'A']++;
            }

            int count = 0;
            for (int j = i; j < s.length(); j++) {
                char charAt = s.charAt(j);
                if (hash[charAt - 'A'] > 0) count++;
                hash[t.charAt(j) - 'A']--;

                if (count == t.length()) {
                    minLength = Math.min(minLength, j - i + 1);
                    startIndex = i;
                    break;
                }
            }
        }
        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLength);
    }
}

/*
    Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that
    every character in t (including duplicates) is included in the window. If there is no such substring,
    return the empty string "".

    Input: s = "ADOBECODEBANC", t = "ABC"
    Output: "BANC"
    Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

    CASE-1: "aaaaaaaaaaaabbbbbcdd", "abcdd" -> "abbbbbcdd"

    CASE-2: "cabwefgewcwaefgcf", ""cae"" -. DURING REVISION DO DRY-RUN -> "cwae"

    A: 65, B: 66, C: 67, D: 68, E: 69, F: 70, G: 71, H: 72, I: 73, J: 74, K: 75, L: 76, M: 77,
    N: 78, O: 79, P: 80, Q: 81, R: 82, S: 83, T: 84, U: 85, V: 86, W: 87, X: 88, Y: 89, Z: 90.

    a: 97, b: 98, c: 99, d: 100, e: 101, f: 102, g: 103, h: 104, i: 105, j: 106, k: 107, l: 108, m: 109,
    n: 110, o: 111, p: 112, q: 113, r: 114, s: 115, t: 116, u: 117, v: 118, w: 119, x: 120, y: 121, z: 122.

 */
