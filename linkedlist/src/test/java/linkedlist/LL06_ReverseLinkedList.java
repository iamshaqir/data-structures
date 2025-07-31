package linkedlist;

import org.junit.jupiter.api.Test;

import static linkedlist.Util.arrayToLinkedList;
import static linkedlist.Util.print;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list/description/">Reverse Linked List</a>
 */
public class LL06_ReverseLinkedList {

    int[] A = {1, 2, 3, 4, 5};

    @Test
    void reverseList() {
        ListNode head = print(A);
        ListNode result = reverseList(head);
        print(result);
    }

    public ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode previous = null;

        while (temp != null) {
            ListNode next = temp.next;
            temp.next = previous;
            previous = temp;
            temp = next;
        }
        return previous;
    }
}
/*
    Given the head of a singly linked list, reverse the list, and return the reversed list.

    Input: head = [1,2,3,4,5]
    Output: [5,4,3,2,1]
 */