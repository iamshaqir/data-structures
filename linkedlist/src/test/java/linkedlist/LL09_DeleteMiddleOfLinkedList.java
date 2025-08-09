package linkedlist;

/**
 * Leetcode: <a href="https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/">Delete the Middle Node of a Linked List</a>
 */
public class LL09_DeleteMiddleOfLinkedList {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
/*
    You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.
    The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing.

    Input: head = [1,3,4,7,1,2,6]
    Output: [1,3,4,1,2,6]
    Explanation:
    The above figure represents the given linked list. The indices of the nodes are written below.
    Since n = 7, node 3 with value 7 is the middle node, which is marked in red.
    We return the new list after removing this node.
 */