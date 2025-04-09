package com.mshaq.sliding.window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class D_FruitsInBasket {

    public static int totalFruits(Integer[] A) {
        int length = A.length;
        int maxCount = 0;

        for (int i = 0; i < length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < length; j++) {
                set.add(A[j]);
                if (set.size() > 2) break;
                maxCount = Math.max(maxCount, j - i + 1);
            }
        }
        return maxCount;
    }

    public int totalFruitsBetter(int[] A) {
        int left = 0;
        int right = 0;
        int maxCount = 0;

        Map<Integer, Integer> map = new HashMap<>();
        while (right < A.length) {
            int currentFruit = A[right];
            map.put(currentFruit, map.getOrDefault(currentFruit, 0) + 1);
            if (map.size() > 2) {
                while (map.size() > 2) {
                    int leftFruit = A[left];
                    map.put(leftFruit, map.get(leftFruit) - 1);
                    if (map.get(leftFruit) == 0) map.remove(leftFruit);
                    left++;
                }
            }
            maxCount = Math.max(maxCount, right - left + 1);
            right++;
        }
        return maxCount;
    }

    public int totalFruitsBest(int[] A) {
        int left = 0;
        int right = 0;
        int maxCount = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < A.length) {
            int currentFruit = A[right];
            map.put(currentFruit, map.getOrDefault(currentFruit, 0) + 1);

            if (map.size() > 2) {
                int leftFruit = A[left];
                map.put(leftFruit, map.get(leftFruit) - 1);
                if (map.get(leftFruit) == 0) map.remove(leftFruit);
                left++;
            }

            if (map.size() <= 2) maxCount = Math.max(maxCount, right - left + 1);
            right++;
        }
        return maxCount;
    }

}
