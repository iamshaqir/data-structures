package com.ms.data.playground.revision.linkedlist;

import com.ms.data.structures.linked_list.ListNode;

public class IntersectionOfLinkedList {

    public ListNode intersectionOpt(ListNode L1, ListNode L2) {
        ListNode H1 = L1;
        ListNode H2 = L2;

        while (H1 != H2) {
            H1 = (H1 == null) ? H2 : H1.next;
            H2 = (H2 == null) ? H1 : H2.next;
        }
        return H1;
    }

    public ListNode intersection(ListNode L1, ListNode L2) {

        ListNode H1 = L1;
        ListNode H2 = L2;

        int diff = getDifference(H1, H2);
        if (diff < 0) {
            while (diff != 0) {
                H2 = H2.next;
                diff++;
            }
        } else {
            while (diff != 0) {
                H1 = H1.next;
                diff--;
            }
        }

        while (H1 != null) {
            if (H1.equals(H2)) {
                return H1;
            }
            H1 = H1.next;
            H2 = H2.next;
        }
        return null;
    }

    private int getDifference(ListNode h1, ListNode h2) {

        int h1Size = 0;
        int h2Size = 0;
        while (h1 != null || h2 != null) {

            if (h1 != null) {
                h1 = h1.next;
                h1Size++;
            }

            if (h2 != null) {
                h2 = h2.next;
                h2Size++;
            }
        }
        return h1Size - h2Size;
    }
}
