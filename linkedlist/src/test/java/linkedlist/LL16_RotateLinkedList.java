package linkedlist;

public class LL16_RotateLinkedList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int length = 1;
        ListNode temp = head;
        while (temp.next != null) {
            length += 1;
            temp = temp.next;
        }

        if (length % k == 0) return head;

        k = k % length;
        temp.next = head;
        int rotations = length - k;
        while (rotations-- > 0) {
            temp = temp.next;
        }

        head = temp.next;
        temp.next = null;

        return head;
    }
}
/*
    Given the head of a linked list, rotate the list to the right by k places.

    Input: head = [1,2,3,4,5], k = 2
    Output: [4,5,1,2,3]
 */