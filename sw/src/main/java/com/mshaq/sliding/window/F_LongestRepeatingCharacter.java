package com.mshaq.sliding.window;

public class F_LongestRepeatingCharacter {

    public int characterReplacementBrute(String S, int K) {
        int maxLength = 0;
        int maxFrequency = 0;
        for (int i = 0; i < S.length(); i++) {
            int[] hash = new int[26];
            for (int j = i; j < S.length(); j++) {
                char rightChar = S.charAt(j);
                hash[rightChar - 'A']++;
                maxFrequency = Math.max(maxFrequency, hash[rightChar - 'A']);
                int charReplacement = (j - i + 1) - maxFrequency;
                if (charReplacement > K) break;
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }
        return maxLength;
    }

    public int characterReplacementBetter(String S, int k) {
        int maxLength = 0;
        int maxFrequency = 0;

        int left = 0, right = 0;
        int[] hash = new int[26];
        while (right < S.length()) {
            char rightChar = S.charAt(right);
            int charFreq = hash[rightChar - 'A'];
            charFreq++;
            // calculate max frequency
            maxFrequency = Math.max(maxFrequency, charFreq);
            int charReplacement = (right - left + 1) - maxFrequency;
            while (charReplacement > k) {
                char leftChar = S.charAt(left);
                hash[leftChar - 'A']--;
                maxFrequency = 0;
                for (int i = 0; i < 26; i++) {
                    maxFrequency = Math.max(maxFrequency, hash[i]);
                }
                left++;
                charReplacement = (right - left + 1) - maxFrequency;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }

    public int optimal(String S, int k) {
        int maxLength = 0;
        int maxFrequency = 0;
        int left = 0, right = 0;
        int[] hash = new int[26];
        while (right < S.length()) {
            char rightChar = S.charAt(right);
            int charFreq = hash[rightChar - 'A'];
            charFreq++;
            maxFrequency = Math.max(maxFrequency, charFreq);
            int replacement = (right - left + 1) - maxFrequency;
            if (replacement > k) {
                hash[S.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }


}
