package com.ms.data.structures.linked_list;

import com.ms.data.structures.linked_list.linkedlist.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IntersectionOfTwoLinkedList {

    public Node<Integer> getIntersectionBrute(Node<Integer> head1, Node<Integer> head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        while (head1 != null) {
            Node<Integer> temp = head2;
            while (temp != null) {
                if (temp.equals(head1)) {
                    return head1;
                }
                temp = temp.next;
            }
            head1 = head1.next;
        }
        return null;
    }

    public Node<Integer> getIntersectionHashing(Node<Integer> a, Node<Integer> b) {

        Set<Node<Integer>> set = new HashSet<>();
        while (a != null) {
            set.add(a);
            a = a.next;
        }

        while (b != null) {
            if (set.contains(b)) {
                return b;
            }
            b = b.next;
        }

        return null;
    }

    public Node<Integer> getIntersectionLength(Node<Integer> list1, Node<Integer> list2) {
        Node<Integer> head1 = list1;
        Node<Integer> head2 = list2;
        int diff = getDifference(head1, head2);

        if (diff < 0) {
            while (diff != 0) {
                head2 = head2.next;
                diff++;
            }
        } else {
            while (diff != 0) {
                head1 = head1.next;
                diff--;
            }
        }

        while (head1 != null) {
            if (head1.equals(head2)) {
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        return null;

    }

    private int getDifference(Node<Integer> head1, Node<Integer> head2) {
        int list1Size = 0;
        int list2Size = 0;

        while (head1 != null || head2 != null) {
            if (head1 != null) {
                list1Size++;
                head1 = head1.next;
            }

            if (head2 != null) {
                list2Size++;
                head2 = head2.next;
            }
        }
        return list1Size - list2Size;
    }

    public Node<Integer> getIntersectionOpt(Node<Integer> head1, Node<Integer> head2) {
        Node<Integer> d1 = head1;
        Node<Integer> d2 = head2;

        while (d1 != d2) {
            d1 = d1 == null ? head2 : d1.next;
            d2 = d2 == null ? head1 : d2.next;
        }

        return d1;
    }
}
