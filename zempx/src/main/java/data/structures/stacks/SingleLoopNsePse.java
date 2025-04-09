package com.ms.data.structures.stacks;

import java.util.Arrays;

public class SingleLoopNsePse {

    // This is for comparing equal elements i.e., if 1 == 1, PSE/NSE wil be 1
    public static void singleLoopPSEqualENSE(int[] A) {
        int n = A.length;
        int[] NSE = new int[n];
        int[] PSE = new int[n];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(NSE, n);
        Arrays.fill(PSE, -1);
        // 6 5 2 3 5 6
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                NSE[stack.pop()] = A[i];
            }

            // Previous small or equal element
            if (!stack.isEmpty()) {
                PSE[i] = A[stack.peek()];
            }
            stack.push(i);
        }
        System.out.println("Next Smaller Element: " + Arrays.toString(NSE));
        System.out.println("Previous Smaller Element" + Arrays.toString(PSE));
    }

    // This is for comparing equal elements i.e., if 9 == 9, PGE/NGE wil be 9
    public static void singleLoopPGEqualENGE(int[] A) {
        int n = A.length;
        int[] NGE = new int[n];
        int[] PGE = new int[n];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(NGE, n);
        Arrays.fill(PGE, -1);
        // 6 5 2 3 5 6
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                NGE[stack.pop()] = A[i];
            }

            // Previous greater or equal element
            if (!stack.isEmpty()) {
                PGE[i] = A[stack.peek()];
            }
            stack.push(i);
        }
        System.out.println("Next Greater Element: " + Arrays.toString(NGE));
        System.out.println("Previous Greater Element" + Arrays.toString(PGE));
    }
}
