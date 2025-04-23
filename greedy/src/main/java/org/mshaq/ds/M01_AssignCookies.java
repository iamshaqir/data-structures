package org.mshaq.ds;

import java.util.Arrays;

public class M01_AssignCookies {

    public static void main(String[] args) {

        int[] greed = {5, 6, 7, 10};
        int[] cookies = {7, 7, 9, 9, 10};
        int result = get(greed, cookies);
        System.out.println(result);
    }

    private static int get(int[] greed, int[] cookies) {

        Arrays.sort(greed);
        Arrays.sort(cookies);

        int p1 = 0, p2 = 0;
        while (p1 < greed.length && p2 < cookies.length) {
            if (cookies[p2] >= greed[p1]) {
                p1++;
            }
            p2++;
        }
        return p1;
    }
}
