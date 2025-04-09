package com.ms.data.structures.linked_list.linkedlist;

import java.util.NoSuchElementException;

public class LinkedList<T> {
    private static int size = 0;
    private Node<T> head;
    private Node<T> tail;

    public Node<T> getHead() {
        return head;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
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
        Node<T> tempNode = head;
        int tempIdx = 0;
        while (tempIdx < size - 1) {
            tempNode = tempNode.next;
            tempIdx++;
        }
        T data = tempNode.data;
        tempNode.next = null;
        tail = tempNode;
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

        Node<T> newNode = new Node<>(data);
        size++;

        Node<T> tempNode = head;
        int tempIdx = 0;
        while (tempIdx < idx - 1) {
            tempNode = tempNode.next;
            tempIdx++;
        }
        newNode.next = tempNode.next;
        tempNode.next = newNode;
    }

    public T remove(int idx) {
        if (idx == 0) {
            return removeFirst();
        }

        if (idx == size - 1) {
            return removeLast();
        }

        Node<T> prev = head;
        int tempIdx = 0;
        while (tempIdx < idx - 1) {
            prev = prev.next;
            tempIdx++;
        }
        T data = prev.next.data;
        prev.next = prev.next.next;
        size--;
        return data;
    }

    public boolean contains(T data) {
        if (size == 0) {
            throw new NoSuchElementException("Data not found");
        }

        Node<T> tempNode = head;
        while (tempNode != null) {
            if (tempNode.data == data) {
                return true;
            }
            tempNode = tempNode.next;
        }
        return false;
    }

    public boolean containsRec(T data) {
        return containsHelper(head, data);
    }

    private boolean containsHelper(Node<T> node, T data) {

        if (node == null) {
            return false;
        }

        if (node.data == data) {
            return true;
        }

        return containsHelper(node.next, data);
    }

    public int size() {
        return size;
    }

    public void print() {
        Node<T> tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.data + " -> ");
            tempNode = tempNode.next;
        }
        System.out.println("null");
    }

    public void print(Node<T> head) {
        Node<T> tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.data + " -> ");
            tempNode = tempNode.next;
        }
        System.out.println("null");
    }

    public void reverse() {

        Node<T> curr = tail = head;
        Node<T> prev = null;
        Node<T> next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }


}
