package com.mshaq.sliding.window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class E_KDistinctCharacter {

    // aababbcaacc K = 2
    public int kDistinctCharacterBrute(String S, int k) {

        int maxLength = 0;
        for (int i = 0; i < S.length(); i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < S.length(); j++) {
                set.add(S.charAt(j));
                if (set.size() > k) break;
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }
        return maxLength;
    }

    public int kDistinctCharactersBetter(String S, int k) {
        int maxLength = 0;
        int left = 0, right = 0;

        Map<Character, Integer> map = new HashMap<>();

        while (right < S.length()) {
            char rightChar = S.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            if (map.size() > k) {
                while (map.size() > k) {
                    char leftChar = S.charAt(left);
                    map.put(leftChar, map.get(leftChar) - 1);
                    if (map.get(leftChar) == 0) map.remove(leftChar);
                    left++;
                }
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }

    public int kDistinctCharactersBest(String S, int K) {
        int maxLength = 0;
        int left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (right < S.length()) {
            map.put(S.charAt(right), map.getOrDefault(S.charAt(right), 0) + 1);
            if (map.size() > K) {
                char leftChar = S.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) map.remove(leftChar);
                left++;
            }
            if (map.size() <= K) maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }


}
