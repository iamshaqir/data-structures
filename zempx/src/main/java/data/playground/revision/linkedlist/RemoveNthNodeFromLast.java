package data.playground.revision.linkedlist;


import data.structures.linked_list.ListNode;

public class RemoveNthNodeFromLast {


    public ListNode removeNthNodeOpt(ListNode head, int n) {

        ListNode fast = head;
        ListNode slow = head;

        int i = 1;
        while (i <= n) {
            fast = fast.next;
            i++;
        }

        if (fast == null) {
            return head.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    public ListNode removeNthNode(ListNode head, int n) {

        // Find the size of linked-list
        ListNode tail = head;
        int size = 1;
        while (tail.next != null) {
            size += 1;
            tail = tail.next;
        }

        if (size == 1 || n == size) {
            head = head.next;
            return head;
        }

        int prevNodeIdx = size - n;
        ListNode prev = head;
        int currIdx = 1;
        while (currIdx < prevNodeIdx) {
            currIdx++;
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return head;
    }
}
