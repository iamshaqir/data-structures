package com.ms.data.structures.stacks;

public class StockSpan {

    public int[] stockSpanBrute(int[] A) {
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int j = i;
            int prevHigh = 0;
            while (j >= 0 && A[j] <= A[i]) {
                prevHigh += 1;
                j--;
            }
            result[i] = prevHigh;
        }
        return result;
    }

    public int[] stockSpanBetter(int[] A) {
        int[] result = new int[A.length];
        Stack<Integer> stack = new Stack<>();
        result[0] = 1;
        stack.push(0);
        for (int i = 1; i < A.length; i++) {

            while (!stack.isEmpty() && A[i] >= A[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = i + 1;
            } else {
                result[i] = i - stack.peek();
            }
            stack.push(i);

        }
        return result;
    }

    public int[] stockSpanBetterOther(int[] A) {
        int[] result = new int[A.length];
        Stack<Integer> stack = new Stack<>();
        for (int currentDayIdx = 0; currentDayIdx < A.length; currentDayIdx++) {

            while (!stack.isEmpty() && A[currentDayIdx] >= A[stack.peek()]) {
                stack.pop();
            }
            int previousDayIdx = (stack.isEmpty()) ? -1 : stack.peek();
            result[currentDayIdx] = currentDayIdx - previousDayIdx;
            stack.push(currentDayIdx);

        }
        return result;
    }

    public int[] stockSpanBetterOther1(int[] A) {
        int[] result = new int[A.length];
        Stack<Integer> stack = new Stack<>();
        for (int currentDayIdx = 0; currentDayIdx < A.length; currentDayIdx++) {

            while (!stack.isEmpty() && A[currentDayIdx] >= A[stack.peek()]) {
                stack.pop();
            }
            int previousDayIdx = (stack.isEmpty()) ? -1 : stack.peek();
            result[currentDayIdx] = currentDayIdx - previousDayIdx;
            stack.push(currentDayIdx);

        }
        return result;
    }
}
