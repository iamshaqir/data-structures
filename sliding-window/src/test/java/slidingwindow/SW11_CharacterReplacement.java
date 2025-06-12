package slidingwindow;

/**
 * Leetcode: <a href="https://leetcode.com/problems/longest-repeating-character-replacement/">Character replacement</a>
 */
public class SW11_CharacterReplacement {


    int characterReplacementBest(String s, int k) {
        int maxFreq = 0;
        int maxLength = 0;
        int[] hash = new int[26];

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char charAtRight = s.charAt(right);
            hash[charAtRight - 'A']++;
            maxFreq = Math.max(maxFreq, hash[charAtRight - 'A']);
            int replacementCount = (right - left + 1) - maxFreq;
            if (replacementCount > k) {
                hash[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    // B A A B A A B B B A A A
    int characterReplacementBetter(String s, int k) {
        int maxFreq = 0;
        int maxLength = 0;
        int[] hash = new int[26];

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char charAtRight = s.charAt(right);
            hash[charAtRight - 'A']++;
            maxFreq = Math.max(maxFreq, hash[charAtRight - 'A']);
            int replacementCount = (right - left + 1) - maxFreq;
            while (replacementCount > k) {
                char charAtLeft = s.charAt(left);
                hash[charAtLeft - 'A']--;
                maxFreq = 0;
                for (int i = 0; i < 26; i++) {
                    maxFreq = Math.max(maxFreq, hash[i]);
                }
                replacementCount = (right - left + 1) - maxFreq;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    int characterReplacementBrute(String s, int k) {
        int maxFreq = 0;
        int maxLength = 0;
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                char currentChar = s.charAt(j);
                hash[currentChar - 'A']++;
                maxFreq = Math.max(maxFreq, hash[currentChar - 'A']);
                int replacementCount = (j - i + 1) - maxFreq;
                if (replacementCount > k) break;
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }
        return maxLength;
    }
}

/*
    Input: s = "BAABAABBBAAA", k = 2
    Output = 6

    Input: s = "AABABBA", k = 1
    Output: 4
 */
