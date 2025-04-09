package com.ms.data.structures.stacks;

import java.util.HashMap;
import java.util.Map;

public class NextGreaterElement {

    public int[] nextGreaterElementBrute(int[] A1, int[] A2) {
        int[] result = new int[A1.length];

        for (int i = 0; i < A1.length; i++) {
            int nextGreaterElement = -1, j = A2.length - 1;
            // A1[i] != A2[j] this condition make sure it shouldn't track left of current element,
            // question says to find next greater what if we had greater element on left
            while (j >= 0 && A1[i] != A2[j]) {
                if (A2[j] > A1[i]) {
                    nextGreaterElement = A2[j];
                }
                j--;
            }
            result[i] = nextGreaterElement;
        }
        return result;
    }

    public int[] nextGreaterElementBetter(int[] A1, int[] A2) {
        int[] result = new int[A1.length];
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : A2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        for (int i = 0; i < A1.length; i++) {
            result[i] = map.getOrDefault(A1[i], -1);
        }

        return result;
    }


}
