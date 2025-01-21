package com.mshaq.sliding.window;

public class G_MinimumWindowSubString {

    public String nimWindowSubStringBrute(String s, String t) {
        String result = "";
        int startIndex = -1;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i++) {
            int[] hash = new int[52];
            for (int ch = 0; ch < t.length(); ch++) {
                hash[t.charAt(ch) - 'A']++;
            }
            int count = 0;
            for (int j = i; j < s.length(); j++) {

                int charFreq = s.charAt(j) - 'A';
                if (hash[charFreq] > 0) count++;
                hash[charFreq]--;

                if (count == t.length()) {
                    minLength = Math.min(minLength, j - i + 1);
                    startIndex = i;
                    break;
                }
            }

        }
        result = (startIndex == -1) ? "" : s.substring(startIndex, startIndex + minLength);
        return result;
    }

    public String nimWindowSubStringOptimal(String s, String t) {
        String result = "";
        int left = 0, right = 0, count = 0;
        int startIdx = -1, minLength = Integer.MAX_VALUE;
        int[] hash = new int[52];

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            hash[c - 'A']++;
        }

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (hash[rightChar - 'A'] > 0) count++;
            hash[rightChar - 'A']--;

            while (count == t.length()) {
                if (right - left + 1 < minLength) {
                    minLength = Math.min(minLength, right - left + 1);
                    startIdx = left;
                }
                char leftChar = s.charAt(left);
                hash[leftChar - 'A']++;

                // To Keep count in track with, other string length
                // Do dry run you will understand for
                // case: s = "ddaaabbca" and t = "abc"
                if (hash[leftChar - 'A'] > 0) count--;
                left++;
            }
            right++;
        }
        result = (startIdx == -1) ? "" : s.substring(startIdx, startIdx + minLength);
        return result;
    }
}

/**
 * TEST CASES:
 * <p>
 * CASE-1: "aaaaaaaaaaaabbbbbcdd", "abcdd" -> "abbbbbcdd"
 *
 * CASE-2: "cabwefgewcwaefgcf", ""cae"" -. DURING REVISION DO DRY-RUN -> "cwae"
 */
