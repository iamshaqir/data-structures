package com.mshaq.sliding.window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class B_LengthOfLongestSubstring {

    public int lengthOfLongestSubstringBrute(String s) {

        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                char currentChar = s.charAt(j);
                if (set.contains(currentChar)) {
                    maxLength = Math.max(maxLength, j - i);
                    break;
                }
                set.add(currentChar);
            }
        }

        return maxLength;
    }

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            char currentCharacter = s.charAt(right);
            if (map.containsKey(currentCharacter)) {
                int leftPosition = map.get(currentCharacter) + 1;
                left = Math.max(left, leftPosition);
            }
            maxLength = Math.max(maxLength, right - left + 1);
            map.put(currentCharacter, right++);
        }
        return maxLength;
    }

    public int lengthOfLongestSubstringO(String s) {
        int maxLength = 0;
        int left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            char currentCharacter = s.charAt(right);
            if (map.containsKey(currentCharacter) &&
                    map.get(currentCharacter) >= left) {
                left = map.get(currentCharacter) + 1;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            map.put(currentCharacter, right++);
        }
        return maxLength;
    }
}
