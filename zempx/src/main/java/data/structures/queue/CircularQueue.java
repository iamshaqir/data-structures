package com.ms.data.structures.queue;


public class CircularQueue<T> {

    private static final int DEFAULT_SIZE = 10;
    private final Object[] A;
    private final int size;
    private int front;
    private int rear;

    public CircularQueue() {
        this(DEFAULT_SIZE);
    }

    public CircularQueue(int size) {
        this.size = size;
        this.front = -1;
        this.rear = -1;
        A = new Object[size];
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    public void add(T element) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }
        if (front == -1) {
            front = 0;
        }
        rear = (rear + 1) % size;
        A[rear] = element;
    }

    public T remove() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is full");
        }
        @SuppressWarnings("unchecked")
        T data = (T) A[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % size;
        }
        return data;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is full");
        }
        return (T) A[front];
    }
}
