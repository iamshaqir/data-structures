package com.mshq.heaps;

import java.util.PriorityQueue;
import java.util.Queue;

public class F_KthLargestElement {

    public static int getKthLargest(int[] A, int k) {

        Queue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            pq.add(A[i]);
        }

        for (int i = k; i < A.length - 1; i++) {
            if (pq.peek() < A[i]) {
                pq.poll();
                pq.add(A[i]);
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        getKthLargest(input, 2);
    }
}
