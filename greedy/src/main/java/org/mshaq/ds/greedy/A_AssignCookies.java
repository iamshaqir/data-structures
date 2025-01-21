package org.mshaq.ds.greedy;

import java.util.Arrays;

//https://leetcode.com/problems/assign-cookies/editorial/
public class A_AssignCookies {

    public int findContentChildren(int[] G, int[] S) {
        Arrays.sort(G);
        Arrays.sort(S);
        int left = 0;
        int right = 0;
        int count = 0;
        while (left < G.length && right < S.length) {

            if (S[right] >= G[left]) {
                left++;
            }
            right++;
        }
        return left;
    }
}
