package com.ms.data.structures.stacks;

import java.util.Arrays;

public class SumSubArrayMinimum {

    public int brute(int[] A) {
        int module = (int) (1e9 + 7);
        int sum = 0;

        for (int i = 0; i < A.length; i++) {
            int minimum = A[i];
            for (int j = i; j < A.length; j++) {
                minimum = Math.min(A[j], minimum);
                sum = (sum + minimum) % module;
            }
        }
        return sum;
    }

    public static int getBetter(int[] A) {
        int n = A.length;
        int module = (int) (1e9 + 7);
        int[] nextSmallerElement = getNextSmallElement(A, n);
        int[] previousSmallerElement = getPreviousSmallElement(A, n);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int left = i - previousSmallerElement[i];
            int right = nextSmallerElement[i] - i;
            long tempSum = ((long) left * right * A[i]) % module;
            sum = (sum + tempSum) % module;
        }
        return (int) sum;
    }

    private static int[] getPreviousSmallElement(int[] A, int n) {

        Stack<Integer> stack = new Stack<>();
        int[] previousSmallerElement = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
                stack.pop();
            }
            previousSmallerElement[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return previousSmallerElement;
    }

    private int[] getPreviousSmallElementBetter(int[] A, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] previousSmallerElement = new int[n];
        Arrays.fill(previousSmallerElement, -1);
        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                previousSmallerElement[stack.pop()] = i;
            }
            stack.push(i);
        }

        return previousSmallerElement;
    }

    private static int[] getNextSmallElement(int[] A, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] nextSmallerElement = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                stack.pop();
            }
            nextSmallerElement[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return nextSmallerElement;
    }

    private int[] getNextSmallElementBetter(int[] A, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] nextSmallerElement = new int[n];
        Arrays.fill(nextSmallerElement, n);
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                nextSmallerElement[stack.pop()] = i;
            }
            stack.push(i);
        }
        return nextSmallerElement;
    }
}
