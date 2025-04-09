package com.ms.data.structures.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int reidx = 0;
        int[] R = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {

            if (!deque.isEmpty() && deque.peek() == i - k) {
                deque.poll();
            }

            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offer(i);
            if (i >= k - 1) {
                R[reidx++] = nums[deque.peek()];
            }
        }
        return R;
    }
}
