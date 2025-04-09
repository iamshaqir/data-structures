package com.ms.data.structures.queue;

import com.ms.data.structures.stacks.Stack;

public class LargestRectangleInHistogram {


    public static int largestRectangleOptimal(int[] A) {
        int n = A.length;
        int rectangleArea = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= n; i++) {

            while (!stack.isEmpty() && (i == n || A[stack.peek()] > A[i])) {
                int height = A[stack.pop()];
                int nextSmallElement = i;
                int previousSmallElement = stack.peek();
                int width = 0;
                if (stack.isEmpty()) {
                    width = nextSmallElement;
                } else {
                    width = nextSmallElement - previousSmallElement - 1;
                }
                rectangleArea = Math.max(rectangleArea, height * width);
            }
            stack.push(i);
        }
        return rectangleArea;
    }

    private static int[] getNextSmallerLeft(int[] input) {
        int[] output = new int[input.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < input.length; i++) {
            int currentEle = input[i];
            while (!s.isEmpty() && currentEle <= input[s.peek()]) {
                s.pop();
            }

            if (s.isEmpty()) {
                output[i] = -1;
            } else {
                output[i] = s.peek();
            }
            s.push(i);
        }
        return output;
    }

    private static int[] getNextSmallerRight(int[] input) {
        int[] output = new int[input.length];
        Stack<Integer> s = new Stack<>();
        for (int i = input.length - 1; i >= 0; i--) {
            int curr = input[i];
            while (!s.isEmpty() && curr <= input[s.peek()]) {
                s.pop();
            }

            if (s.isEmpty()) {
                output[i] = input.length;
            } else {
                output[i] = s.peek();
            }
            s.push(i);
        }
        return output;
    }

    public static int getMaxArea(int[] arr) {

        int max = 0;
        int[] nsr = getNextSmallerRight(arr);
        int[] nsl = getNextSmallerLeft(arr);

        for (int i = 0; i < arr.length; i++) {
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            max = Math.max(max, currArea);
        }
        return max;
    }

    public int largestRectangleBrute(int[] H, int n) {

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                minHeight = Math.min(minHeight, H[j]);
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;
    }
}
