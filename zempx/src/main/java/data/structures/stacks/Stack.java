package com.ms.data.structures.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Stack<E> {

    List<E> stack;

    public Stack() {
        stack = new ArrayList<>();
    }

    public void push(E data) {
        stack.add(data);
    }

    public E pop() {
        int elementIdx = stack.size() - 1;
        if (elementIdx < 0) {
            throw new NoSuchElementException("Stack is empty.");
        }
        E data = stack.get(elementIdx);
        stack.remove(elementIdx);
        return data;
    }

    public E peek() {
        int elementIdx = stack.size() - 1;
        if (elementIdx < 0) {
            throw new NoSuchElementException("Stack is empty.");
        }
        return stack.get(elementIdx);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public void print() {
        System.out.println(stack);
    }
}
