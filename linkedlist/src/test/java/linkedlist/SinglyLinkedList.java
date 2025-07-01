package linkedlist;

public class SinglyLinkedList<T> {
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
    }

    public void addLast(T element) {
        if (head == null) {
            addFirst(element);
            return;
        }
        Node<T> newNode = new Node<>(element);
        size++;
        tail.next = newNode;
        tail = newNode;
    }

    public void add(int index, T element) {
        if (index == 0) {
            addFirst(element);
            return;
        }

        if (index == size - 1) {
            addLast(element);
            return;
        }

        Node<T> newNode = new Node<>(element);
        size++;

        int counter = 0;
        Node<T> temp = head;
        while (counter < index - 1) {
            temp = temp.next;
            counter++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public T removeFirst() {
        if (size == 0) throw new RuntimeException("No element to remove");
        T data = head.data;
        if (size == 1) {
            head = tail = null;
            size--;
            return data;
        }
        head = head.next;
        size--;
        return data;
    }

    public T removeLast() {
        if (size == 0) throw new RuntimeException("No element to remove");
        if (size == 1) return removeFirst();
        int counter = 0;
        Node<T> tempNode = head;
        while (counter++ < size - 2) {
            tempNode = tempNode.next;
        }
        T data = tempNode.next.data;
        tempNode.next = null;
        tail = tempNode;
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
        T data = previous.next.data;
        previous.next = previous.next.next;
        size--;
        return data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }
}
