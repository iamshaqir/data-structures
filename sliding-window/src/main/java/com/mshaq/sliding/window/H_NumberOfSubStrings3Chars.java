package com.mshaq.sliding.window;

import java.util.HashSet;
import java.util.Set;

public class H_NumberOfSubStrings3Chars {

    public int numberOfSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                set.add(s.charAt(j));
                if (set.size() == 3) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public int numberOfSubstringsOpt(String s) {
        int count = 0;

        int[] hash = {-1, -1, -1};
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a'] = i;

            if (hash[0] != -1 &&
                    hash[1] != -1 &&
                    hash[2] != -1) {
                count += Math.min(Math.min(hash[0], hash[1]), hash[2]) + 1;
            }
        }

        return count;
    }


}
