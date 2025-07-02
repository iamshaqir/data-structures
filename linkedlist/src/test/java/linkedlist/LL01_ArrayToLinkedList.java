package linkedlist;

import org.junit.jupiter.api.Test;

public class LL01_ArrayToLinkedList {

    int[] A = {1, 2, 3, 4, 5, 6};

    @Test
    void arrayToLinkedList() {
        Node<Integer> head = arrayToLinkedList(A);
        Util.print(head);
    }

    Node<Integer> arrayToLinkedList(int[] A) {
        Node<Integer> head = new Node<>(A[0]);

        Node<Integer> previous = head;
        for (int i = 1; i < A.length; i++) {
            Node<Integer> newNode = new Node<>(A[i], null, previous);
            previous.next = newNode;
            previous = newNode;
        }
        return head;
    }
}
