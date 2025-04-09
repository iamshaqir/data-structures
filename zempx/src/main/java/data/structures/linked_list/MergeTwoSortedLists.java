package com.ms.data.structures.linked_list;

import com.ms.data.structures.linked_list.linkedlist.Node;

public class MergeTwoSortedLists {

    public Node<Integer> merge(Node<Integer> list1, Node<Integer> list2) {

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        Node<Integer> head, tail = null;
        if (list1.data < list2.data) {
            head = tail = list1;
            list1 = list1.next;
        } else {
            head = tail = list2;
            list2 = list2.next;
        }


        while (list1 != null && list2 != null) {
            if (list1.data <= list2.data) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if (list1 != null) {
            tail.next = list1;
        }

        if (list2 != null) {
            tail.next = list2;
        }

        return head;
    }

    public Node<Integer> mergeOther(Node<Integer> l1, Node<Integer> l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.data > l2.data) {
            Node<Integer> temp = l2;
            l2 = l1;
            l1 = temp;
        }

        Node<Integer> head = l1;
        while (l1.next != null && l2 != null) {
            if (l1.next.data <= l2.data) {
                l1 = l1.next;
            } else {
                Node<Integer> temp = l1.next;
                l1.next = l2;
                l2 = l2.next;
                l1.next.next = temp;
                l1 = l1.next;
            }
        }

        if (l2 != null) {
            l1.next = l2;
        }

        return head;
    }
}
