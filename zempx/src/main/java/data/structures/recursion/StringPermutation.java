package com.ms.data.structures.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringPermutation {

    public static void main(String[] args) {
        String str = "ABCF";
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        List<String> res = new ArrayList<>();
        List<Character> resChar = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[chars.length];
        permutationRecOth(chars, resChar, visited, sb);
    }

    private static void permutationRecOth(char[] chars, List<Character> ds, boolean[] visited, StringBuilder sb) {
        if (sb.length() == chars.length) {
            System.out.print(sb.toString() + " ");
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                ds.add(chars[i]);
                permutationRecOth(chars, ds, visited, sb.append(chars[i]));
                visited[i] = false;
                ds.remove(ds.size() - 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    private static void permutationRec(char[] chars, List<String> res, StringBuilder sb) {
        if (sb.length() == chars.length) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            while (i + 1 < chars.length && chars[i] == chars[i + 1]) {
                i++;
            }
            permutationRec(chars, res, sb.append(chars[i]));
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
