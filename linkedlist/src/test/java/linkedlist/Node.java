package linkedlist;

public class Node<T> {
    T data;
    Node<T> next;
    Node<T> previous;

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Node<T> next, Node<T> previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }
}
