package linkedlist;

import org.junit.jupiter.api.Test;

public class LL01_ArrayToLinkedList {

    int[] A = {1, 2, 3, 4, 5, 6};

    @Test
    void arrayToLinkedList() {
        ListNode head = arrayToLinkedList(A);
        Util.print(head);
    }

    ListNode arrayToLinkedList(int[] A) {
        ListNode head = new ListNode(A[0]);

        ListNode previous = head;
        for (int i = 1; i < A.length; i++) {
            ListNode newListNode = new ListNode(A[i], null, previous);
            previous.next = newListNode;
            previous = newListNode;
        }
        return head;
    }
}
