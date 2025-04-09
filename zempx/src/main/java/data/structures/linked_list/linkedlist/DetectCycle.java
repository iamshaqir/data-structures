package com.ms.data.structures.linked_list.linkedlist;

public class DetectCycle {

    public boolean isCycle(Node<Integer> head) {

        Node<Integer> fast = head;
        Node<Integer> slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)) {
                return true;
            }
        }
        return false;
    }
}
