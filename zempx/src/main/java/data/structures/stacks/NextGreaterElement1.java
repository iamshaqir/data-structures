package com.ms.data.structures.stacks;

import java.util.Arrays;

public class NextGreaterElement1 {

    public int[] nextGreaterElementBrute(int[] A) {
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] > A[i]) {
                    result[i] = A[j];
                    break;
                }
            }
        }
        return result;
    }

    public int[] nextGreaterElementBetter(int[] A) {
        int[] result = new int[A.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = A.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[i] >= A[stack.peek()]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = A[stack.peek()];
            }
            stack.push(i);
        }
        return result;
    }

    public int[] nextGreaterElementBetterOther(int[] A) {
        int[] result = new int[A.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && A[i] > A[stack.peek()]) {
                result[stack.pop()] = A[i];
            }
            stack.push(i);
        }
        return result;
    }
}
