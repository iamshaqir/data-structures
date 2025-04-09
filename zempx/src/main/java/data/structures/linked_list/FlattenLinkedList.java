package com.ms.data.structures.linked_list;

public class FlattenLinkedList {


    public ListNode flatten(ListNode root) {

        if (root == null || root.next == null) {
            return root;
        }
        flatten(root.next);
        root = merge(root, root.next);
        return root;
    }

    private ListNode merge(ListNode list1, ListNode list2) {

        ListNode head = null;
        ListNode tail = null;

        if (list1.data <= list2.data) {
            head = tail = list1;
            list1 = list1.bottom;
        } else {
            head = tail = list2;
            list2 = list2.bottom;
        }

        while (list1 != null && list2 != null) {

            if (list1.data <= list2.data) {
                tail.bottom = list1;
                list1 = list1.bottom;
            } else {
                tail.bottom = list2;
                list2 = list2.bottom;
            }
            tail = tail.bottom;
        }

        if (list1 != null) {
            tail.bottom = list1;
        }

        if (list2 != null) {
            tail.bottom = list2;
        }

        return head;
    }
}
