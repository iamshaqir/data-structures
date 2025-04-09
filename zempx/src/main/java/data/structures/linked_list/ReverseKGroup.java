package com.ms.data.structures.linked_list;

import com.ms.data.structures.linked_list.linkedlist.Node;

public class ReverseKGroup {


    public Node<Integer> reverseKGroupRec(Node<Integer> head, int k) {
        int count = 0;
        Node<Integer> current = head;
        while (current != null && count != k) {
            count += 1;
            current = current.next;
        }
        if (count == k) {
            current = reverseKGroupRec(current, k);

            while (count-- > 0) {
                Node<Integer> temp = head.next;
                head.next = current;
                current = head;
                head = temp;
            }
            head = current;
        }
        return head;
    }

    public Node<Integer> reverseKGroup(Node<Integer> head, int k) {

        Node<Integer> temp = new Node<>();
        temp.next = head;
        Node<Integer> prev = temp, next = temp, curr = temp;

        int count = -1;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        while (count >= k) {

            curr = prev.next;
            next = curr.next;
            for (int i = 1; i < k; i++) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            prev = curr;
            count -= k;
        }
        return temp.next;
    }
}
