package linkedlist;

import org.junit.jupiter.api.Test;

/**
 * Leetcode: <a href="https://leetcode.com/problems/odd-even-linked-list/description/">Odd Even Linked List</a>
 */
public class LL03_OddEvenLinkedList {

    int[] A1 = {1, 2, 3, 4, 5};
    int[] A = {2, 1, 3, 5, 6, 4, 7};

    @Test
    public void oddEvenList() {
        ListNode head = Util.arrayToLinkedList(A);
        Util.print(head);

        ListNode oddEvenList = oddEvenList(head);
        Util.print(oddEvenList);
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
/*
    Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with
    even indices, and return the reordered list.

    The first node is considered odd, and the second node is even, and so on.
    Note that the relative order inside both the even and odd groups should remain as it was in the input.
    You must solve the problem in O(1) extra space complexity and O(n) time complexity.

    Input: head = [1,2,3,4,5]
    Output: [1,3,5,2,4]
    1 -> 2 -> 3 -> 4 -> 5 -> null
    1 -> 3 -> 5 -> 2 -> 4 -> null

    Input: head = [2,1,3,5,6,4,7]
    Output: [2,3,6,7,1,5,4]
    2 -> 1 -> 3 -> 5 -> 6 -> 4 -> 7 -> null
    2 -> 3 -> 6 -> 7 -> 1 -> 5 -> 4 -> null
 */
