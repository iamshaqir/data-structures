package slidingwindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>Leetcode</b>: <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/description/">Length of longest substring</a>
 */
public class SW8_LengthOfLongestSubstring {

    @Test
    void driver() {
        String s = "abcde fgh!";
        int actual = lengthOfLongestSubstringOptimal(s);
        Assertions.assertEquals(10, actual);
    }

    int lengthOfLongestSubstringOptimal(String s) {
        int left = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char currentCharacter = s.charAt(right);
            if (map.containsKey(currentCharacter) &&
                    map.get(currentCharacter) >= left) {
                left = map.get(currentCharacter) + 1;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            map.put(currentCharacter, right);
        }

        return maxLength;
    }

    int lengthOfLongestSubstringBetter(String s) {
        int left = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char currentCharacter = s.charAt(right);
            if (map.containsKey(currentCharacter)) {
                int currentPos = map.get(currentCharacter);
                left = Math.max(left, currentPos + 1); // tricky point for testcase abcddabc
            }

            maxLength = Math.max(maxLength, right - left + 1);
            map.put(currentCharacter, right);
        }
        return maxLength;
    }
}

/*
    Problem Statement: Given a string s, find the length of the longest substring without repeating characters.

    Input : S = "abcddabac"
    Output : 4

    Input : S = "aaabbbccc"
    Output : 2

    Input: s = "abcde fgh!"
    Output: 10
 */
