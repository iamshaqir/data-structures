package com.ms.data.structures.queue;


import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class StackUsingSingleQueue {
    Queue<Integer> q = new LinkedList<>();

    public void push(int data) {
        q.add(data);
        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.remove());
        }
    }

    public int pop() {
        if (q.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return q.remove();
    }

    public int peek() {
        if (q.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return q.peek();
    }
}
