package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode:<a href="https://leetcode.com/problems/fruit-into-baskets/">Fruit Into Baskets</a>
 */
public class SW10_FruitsInBasket {

    int better(int[] A) {

        int left = 0;
        int maxFruits = 0;
        Map<Integer, Integer> fruitsMap = new HashMap<>();
        for (int right = 0; right < A.length; right++) {
            int currentFruit = A[right];
            fruitsMap.put(currentFruit, fruitsMap.getOrDefault(currentFruit, 0) + 1);

            if (fruitsMap.size() > 2) {
                int leftFruit = A[left];
                fruitsMap.put(leftFruit, fruitsMap.get(leftFruit) - 1);
                if (fruitsMap.get(leftFruit) == 0) fruitsMap.remove(leftFruit);
                left++;
            }

            if (fruitsMap.size() <= 2) {
                maxFruits = Math.max(maxFruits, right - left + 1);
            }
        }

        return maxFruits;
    }
}
