package linkedlist.algo;

import java.util.NoSuchElementException;

public class DoublyLinkedList<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;

    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
        newNode.previous = head;
    }

    public void addLast(T element) {

        if (head == null) {
            addFirst(element);
            return;
        }
        Node<T> newNode = new Node<>(element);
        size++;

        tail.next = newNode;
        newNode.previous = tail;
        tail = newNode;
    }

    public void add(T element, int index) {
        if (index < 0) throw new RuntimeException("Invalid position");
        if (index == 0) {
            addFirst(element);
            return;
        }

        if (index == size - 1) {
            addLast(element);
            return;
        }

        int counter = 0;
        Node<T> previous = head;
        while (counter++ < index - 1) {
            previous = previous.next;
        }

        Node<T> newNode = new Node<>(element);
        size++;
        Node<T> nextNode = previous.next;
        newNode.next = nextNode;
        newNode.previous = previous;
        previous.next = newNode;
        nextNode.previous = newNode;
    }

    public T removeFirst() {
        if (isEmpty()) throw new RuntimeException("No element to remove");
        T data = head.data;
        if (size == 1) {
            head = tail = null;
            size--;
            return data;
        }
        head = head.next;
        head.previous = null;
        size--;
        return data;
    }

    public T removeLast() {
        if (isEmpty()) throw new RuntimeException("No element to remove");
        if (size == 1) return removeFirst();

        T data = tail.data;
        tail = tail.previous;
        tail.next = null;
        size--;
        return data;
    }

    public T remove(int index) {
        if (index == 0) return removeFirst();
        if (index == size - 1) return removeLast();
        int counter = 0;
        Node<T> previous = head;
        while (counter++ < index - 1) {
            previous = previous.next;
        }
        Node<T> current = previous.next;
        T data = current.data;
        previous.next = current.next;
        current.next.previous = previous;
        size--;
        return data;
    }

    public boolean contains(T element) {
        if (isEmpty()) throw new NoSuchElementException("Empty list");
        Node<T> temp = head;
        // validating till temp not temp.next because we need to check last element as well
        while (temp != null) {
            if (temp.data.equals(element)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public boolean containsRec(T element) {
        if (isEmpty()) throw new NoSuchElementException("Empty list");
        return containsHelper(head, element);
    }

    private boolean containsHelper(Node<T> node, T element) {
        if (node == null) return false;

        if (node.data.equals(element)) return true;

        return containsHelper(node.next, element);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        Node<T> tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.data + " -> ");
            tempNode = tempNode.next;
        }
        System.out.println("null");
    }

    private static class Node<T> {

        T data;
        Node<T> next;
        Node<T> previous;

        public Node(T data) {
            this.data = data;
        }
    }
}
