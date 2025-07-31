package linkedlist;

import org.junit.jupiter.api.Test;

import static linkedlist.Util.arrayToLinkedList;
import static linkedlist.Util.print;

/**
 * Leetcode: <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/">19. Remove Nth Node From End of List</a>
 */
public class LL05_RemoveNthNodeBack {

    int[] A = {1, 2, 3, 4, 5};

    @Test
    void removeNthNodeFromEnd() {
        ListNode head = arrayToLinkedList(A);
        print(head);

        ListNode result = removeNthFromEndBrute(head, 5);
        print(result);

    }

    @Test
    void removeNthFromEnd() {
        ListNode head = arrayToLinkedList(A);
        print(head);

        ListNode result = removeNthFromEnd(head, 3);
        print(result);

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if (fast == null) return head.next;

        // Make sure to do it only until last node(L), because slow will point to previous of node to be removed(L-n)
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public ListNode removeNthFromEndBrute(ListNode head, int n) {

        int numberOfNodes = 0;
        ListNode temp = head;
        while (temp != null) {
            numberOfNodes += 1;
            temp = temp.next;
        }

        if (numberOfNodes == n) return head.next;
        ListNode previous = head;
        int counter = 0;
        while (counter++ < numberOfNodes - n - 1) {
            previous = previous.next;
        }
        previous.next = previous.next.next;
        return head;
    }
}

/*
    Given the head of a linked list, remove the nth node from the end of the list and return its head

    Input: head = [1,2,3,4,5], n = 2
    Output: [1,2,3,5]
 */