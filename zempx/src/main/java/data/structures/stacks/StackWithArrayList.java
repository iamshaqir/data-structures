package com.ms.data.structures.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class StackWithArrayList<E> {

    List<E> stack;

    public StackWithArrayList() {
        stack = new ArrayList<>();
    }

    public void push(E data) {
        stack.add(data);
    }

    public E pop() {
        int size = stack.size() - 1;
        if (size <= 0) {
            throw new NoSuchElementException("Stack is empty.");
        }
        E data = stack.get(size);
        stack.remove(size);
        return data;
    }

    public E peek() {
        int size = stack.size() - 1;
        if (size <= 0) {
            throw new NoSuchElementException("Stack is empty.");
        }
        return stack.get(size);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }
}
