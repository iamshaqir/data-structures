package org.mshaq.ds.greedy.ac;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://www.geeksforgeeks.org/problems/-minimum-number-of-coins4426/1?
 * itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card">Minimum Denomination</a>
 */
public class B_MinimumDenominations {

    public static void main(String[] args) {


        int input = 200;
        List<Integer> integers = get(input);
        System.out.println(integers);
    }

    private static List<Integer> get(int N) {
        final int[] denominations = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
        List<Integer> list = new ArrayList<>();
        for (int i = denominations.length - 1; i >= 0; i--) {
            if (N == 0) break;
            while (N >= denominations[i]) {
                N -= denominations[i];
                list.add(denominations[i]);
            }
        }
        return list;
    }
}
