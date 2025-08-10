package org.mshaq.ds;

import java.util.Arrays;

/**
 * Leetcode: <a href="https://leetcode.com/problems/assign-cookies/description">Assign Cookies</a>
 */
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
/*
    Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at
    most one cookie.

    Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with; and
    each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be
    content. Your goal is to maximize the number of your content children and output the maximum number.

    Input: g = [1,2,3], s = [1,1]
    Output: 1
    Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
    And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is
    1 content.

    You need to output 1.

    # Intuition
    The goal is to maximize the number of students who can be satisfied with the given cookies. By sorting both the
    students' greed factors and the cookie sizes, we can efficiently assign the smallest available cookie that satisfies
    each student's greed. We iterate through the arrays, assigning cookies to students until we either run out of
    students or cookies, ensuring the maximum number of satisfied students.
 */