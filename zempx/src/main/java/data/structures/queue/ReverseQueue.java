package com.ms.data.structures.queue;

import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {


    public Queue<Integer> reverse(Queue<Integer> Q) {
        Stack<Integer> stack = new Stack<>();

        while (!Q.isEmpty()) {
            stack.push(Q.poll());
        }

        while (!stack.isEmpty()) {
            Q.offer(stack.pop());
        }

        return Q;
    }

    public Queue<Integer> rev(Queue<Integer> q) {
        //add code here.
        return recHelper(q, q.poll());

    }

    private Queue<Integer> recHelper(Queue<Integer> q, int data) {

        if (q.isEmpty()) {
            q.offer(data);
            return q;
        }
        recHelper(q, q.poll());
        q.offer(data);
        return q;
    }
}
