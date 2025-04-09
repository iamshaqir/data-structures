package com.ms.data.structures.linked_list;

import com.ms.data.structures.linked_list.linkedlist.DoublyNode;
import com.ms.data.structures.linked_list.linkedlist.Node;

public class ReverseLinkedList<T> {


    public Node<T> reverse(Node<T> head) {
        Node<T> current = head;
        Node<T> previous = null;
        Node<T> next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public DoublyNode<T> reverseDoubly(DoublyNode<T> head) {
        DoublyNode<T> current = head;
        DoublyNode<T> next = null;
        DoublyNode<T> previous = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            current.prev = next;
            previous = current;
            current = next;
        }
        return previous;
    }
}
