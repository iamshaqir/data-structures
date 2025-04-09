package com.ms.data.structures.linked_list;

import com.ms.data.structures.linked_list.linkedlist.Node;

public class AddTwoNumbers {

    public Node<Integer> add(Node<Integer> l1, Node<Integer> l2) {

        Node<Integer> head = new Node<>();

        Node<Integer> tail = head;

        int carry = 0;

        while (l1 != null || l2 != null || carry == 1) {

            int sum = 0;

            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }

            sum += carry;
            carry = sum / 10;
            Node<Integer> newNode = new Node<>(sum % 10);
            tail.next = newNode;
            tail = tail.next;
        }
        return head.next;
    }
}
