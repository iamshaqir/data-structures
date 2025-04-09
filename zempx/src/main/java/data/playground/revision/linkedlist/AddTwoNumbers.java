package com.ms.data.playground.revision.linkedlist;

import com.ms.data.structures.linked_list.ListNode;

public class AddTwoNumbers {

    public ListNode addTwoList(ListNode L1, ListNode L2) {

        ListNode head = new ListNode();
        ListNode tail = head;
        int carry = 0;
        while (L1 != null || L2 != null || carry == 1) {
            int sum = 0;

            if (L1 != null) {
                sum += L1.data;
                L1 = L1.next;
            }

            if (L2 != null) {
                sum += L2.data;
                L2 = L2.next;
            }

            sum += carry;
            carry = sum / 10;
            ListNode newNode = new ListNode(sum % 10);
            tail.next = newNode;
            tail = tail.next;
        }
        return head.next;
    }
}
