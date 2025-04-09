package com.mshaq.datastructures.tuf.set_a;

import java.util.HashMap;
import java.util.Map;

public class L_MajorityElements {


    // Input: nums = [2,2,1,1,1,2,2]
    // Output: 2
    public int majorityElementBe(int[] A) {
        // Hashing
        Map<Integer, Integer> map = new HashMap<>();
        for (int element : A) {
            map.put(element, map.getOrDefault(element, 0) + 1);
            if (map.get(element) > A.length / 2) {
                return element;
            }
        }
        return 0;
    }

    // Input: nums = [2,2,1,1,1,2,2]
    // Output: 2
    public int majorityElementBr(int[] A) {
        int majorityElement = 0;
        int count = 0;
        for (int element : A) {
            if (element == majorityElement) {
                count++;
            } else if (count == 0) {
                majorityElement = element;
                count = 1;
            } else {
                count--;
            }
        }

        int resultCount = 0;
        for (int element : A) {
            if (element == majorityElement) {
                resultCount++;
            }
        }

        if (resultCount > A.length / 2) {
            return majorityElement;
        }
        return 0;
    }

    // Input: nums = [2,2,1,1,1,2,2]
    // Output: 2
    public int majorityElement(int[] A) {
        // Using Boyer Moore voting algorithm
        int majorityElement = 0;
        int count = 0;

        for (int element : A) {
            if (count == 0) majorityElement = element;

            if (element == majorityElement) {
                count++;
            } else {
                count--;
            }
        }

        return majorityElement;
    }

}
