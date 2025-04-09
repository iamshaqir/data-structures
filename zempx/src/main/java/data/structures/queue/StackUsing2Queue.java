package com.ms.data.structures.queue;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class StackUsing2Queue {

    Queue<Integer> Q1 = new LinkedList<>();
    Queue<Integer> Q2 = new LinkedList<>();


    // Method 1 - add -> O(N), pop() and peek() -> O(1)
    public void add(int data) {
        Q2.offer(data);
        while (!Q1.isEmpty()) {
            Q2.offer(Q1.remove());
        }
        Queue<Integer> temp = Q2;
        Q2 = Q1;
        Q1 = temp;
    }

    public int remove() {
        if (Q1.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return Q1.poll();
    }

    public int peek() {
        if (Q1.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return Q1.peek();
    }

    // Method 2 - add -> O(1), pop() and peek() -> O(N)
    public void _add(int data) {
        Q1.add(data);
    }

    public int _remove() {
        if (Q1.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        while (Q1.size() != 1) {
            Q2.offer(Q1.remove());
        }

        int data = Q1.remove();
        Queue<Integer> tempQ = Q2;
        Q2 = Q1;
        Q1 = tempQ;
        return data;
    }

    public int _peek() {
        if (Q1.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        int data = _remove();
        Q1.offer(data);
        return data;
    }
}
