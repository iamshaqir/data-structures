package com.ms.data.structures.linked_list.linkedlist;

import java.util.NoSuchElementException;

public class DoublyLinkedList<T> {

    private static int size;
    private DoublyNode<T> head;
    private DoublyNode<T> tail;

    public DoublyNode<T> getHead() {
        return head;
    }

    public void addFirst(T data) {
        DoublyNode<T> newNode = new DoublyNode<>(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addLast(T data) {
        if (head == null) {
            addFirst(data);
            return;
        }

        DoublyNode<T> newNode = new DoublyNode<>(data);
        size++;

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public T removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException("TreeNode not found.");
        }
        T data = head.data;
        if (size == 1) {
            head = tail = null;
            size = 0;
            return data;
        }

        head = head.next;
        head.prev = null;
        size--;
        return data;
    }

    public T removeLast() {
        if (size == 0) {
            throw new NoSuchElementException("TreeNode not found.");
        }

        if (size == 1) {
            return removeFirst();
        }
        T data = tail.data;
        tail = tail.prev;
        tail.next = null;
        size--;
        return data;
    }

    public void add(int idx, T data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }

        if (idx == size - 1) {
            addLast(data);
            return;
        }
        DoublyNode<T> newNode = new DoublyNode<>(data);
        size++;

        DoublyNode<T> tempNode = head;
        int tempIdx = 0;
        while (tempIdx < idx - 1) {
            tempNode = tempNode.next;
            tempIdx++;
        }
        DoublyNode<T> next = tempNode.next;
        newNode.next = next;
        newNode.prev = tempNode;
        tempNode.next = newNode;
        next.prev = newNode;
    }

    public T remove(int idx) {

        if (size == 0) {
            throw new NoSuchElementException("TreeNode not found.");
        }

        if (idx == 0) {
            return removeFirst();
        }

        if (idx == size - 1) {
            return removeLast();
        }

        DoublyNode<T> tempNode = head;
        int tempIdx = 0;
        while (tempIdx < idx - 1) {
            tempNode = tempNode.next;
            tempIdx++;
        }
        DoublyNode<T> nodeToBeRem = tempNode.next;
        T data = nodeToBeRem.data;
        tempNode.next = nodeToBeRem.next;
        nodeToBeRem.next.prev = tempNode;
        size--;
        return data;
    }

    public void print() {
        DoublyNode<T> tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.data + " -> ");
            tempNode = tempNode.next;
        }
        System.out.println("null");
    }

    public void printTail() {
        DoublyNode<T> tempNode = tail;
        while (tempNode != null) {
            System.out.print(tempNode.data + " -> ");
            tempNode = tempNode.prev;
        }
        System.out.println("null");
    }

    public void print(DoublyNode<T> head) {
        DoublyNode<T> tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.data + " -> ");
            tempNode = tempNode.next;
        }
        System.out.println("null");
    }
}
