package com.ms.data.structures.linked_list;

import com.ms.data.structures.linked_list.linkedlist.Node;

public class RemoveNthNodeFromLast {


    public Node<Integer> remove(Node<Integer> head, int idx) {

        // calculate size of linked list
        Node<Integer> tempNode = head;
        int size = 1;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
            size++;
        }

        if (size == 1 || idx == size) {
            head = head.next;
            return head;
        }

        int nodeToBeRemoved = size - idx;
        int currIdx = 1;
        Node<Integer> prev = head;
        while (currIdx < nodeToBeRemoved) {
            prev = prev.next;
            currIdx++;
        }

        prev.next = prev.next.next;
        return head;
    }

    public Node<Integer> removeOp(Node<Integer> head, int idx) {
        Node<Integer> fast = head;
        Node<Integer> slow = head;

        int i = 1;

        while (i <= idx) {
            fast = fast.next;
            i++;
        }

        if(fast == null) {
            return head.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;

    }
}
