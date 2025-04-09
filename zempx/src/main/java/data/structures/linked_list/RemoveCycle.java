package com.ms.data.structures.linked_list;

import com.ms.data.structures.linked_list.linkedlist.Node;

public class RemoveCycle {

    public Node<Integer> removeCycle(Node<Integer> head) {

        Node<Integer> fast = head;
        Node<Integer> slow = head;
        boolean isCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow.equals(fast)) {
                isCycle = true;
                slow = head;
                break;
            }
        }

        if (!isCycle) {
            return head;
        }

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        while (fast.next != slow) {
            fast = fast.next;
        }
        fast.next = null;
        return head;
    }
}
