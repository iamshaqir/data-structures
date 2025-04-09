package com.ms.data.structures.linked_list;

public class RotateLinkedListByK {


    public ListNode rotateLeft(ListNode head, int k) {

        int length = 1;
        ListNode temp = head;

        while (temp.next != null) {
            length += 1;
            temp = temp.next;
        }

        if (k > length && length != 0) {
            k %= length;
        }
        temp.next = head;
        k = length - k;
        while (k-- > 0) {
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;
        return head;

    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }

        int length = 1;
        ListNode temp = head;

        while (temp.next != null) {
            length += 1;
            temp = temp.next;
        }
        if (k > length && length != 0) {
            k %= length;
        }
        temp.next = head;
        while (k-- > 0) {
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;
        return head;
    }

}
