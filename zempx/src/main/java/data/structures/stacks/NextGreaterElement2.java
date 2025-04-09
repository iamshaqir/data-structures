package com.ms.data.structures.stacks;


import java.util.Arrays;

// Next Greater Element in circular Array
public class NextGreaterElement2 {

    public int[] nextGreaterCircular(int[] A) {
        int n = A.length;
        int[] result = new int[A.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n * 2; i++) {
            while (!stack.isEmpty() && A[i % n] > A[stack.peek()]) {
                result[stack.pop()] = A[i % n];
            }
            stack.push(i % n);
        }
        return result;
    }
}
