package com.ms.data.structures.stacks;

import java.util.NoSuchElementException;

public class StackWithLinkedList<E> {

    private int size = 0;
    Node<E> head;

    public StackWithLinkedList() {
        this.head = null;
    }

    public void push(E data) {
        Node<E> node = new Node<>(data);
        size++;
        if (head == null) {
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }

    public E pop() {
        if (size <= 0 || head == null) {
            throw new NoSuchElementException("Stack is empty.");
        }
        E data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public E peek() {
        if (size <= 0 || head == null) {
            throw new NoSuchElementException("Stack is empty.");
        }
        return head.data;
    }

    static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }
}
