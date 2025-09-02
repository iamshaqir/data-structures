package linkedlist;

import org.junit.jupiter.api.Test;

public class LL18_FlatteningLinkedList {

    public static void printOriginalLinkedList(ListNode head, int depth) {
        while (head != null) {
            System.out.print(head.val);

            /* If child exists, recursively
             print it with indentation */
            if (head.child != null) {
                System.out.print(" -> ");
                printOriginalLinkedList(head.child, depth + 1);
            }

            // Add vertical bars for each level in the grid
            if (head.next != null) {
                System.out.println();
                for (int i = 0; i < depth; ++i) {
                    System.out.print("| ");
                }
            }
            head = head.next;
        }
    }

    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.child;
        }
        System.out.println();
    }

    @Test
    void flattenLinkedList() {

        ListNode head = new ListNode(5);
        head.child = new ListNode(14);

        head.next = new ListNode(10);
        head.next.child = new ListNode(4);

        head.next.next = new ListNode(12);
        head.next.next.child = new ListNode(20);
        head.next.next.child.child = new ListNode(13);

        head.next.next.next = new ListNode(7);
        head.next.next.next.child = new ListNode(17);

        // Print the original linked list structure
        System.out.println("Original linked list:");
        printOriginalLinkedList(head, 0);

        ListNode flattened = flattenLinkedList(head);

        System.out.print("\nFlattened linked list: ");
        printLinkedList(flattened);
    }

    public ListNode flattenLinkedList(ListNode head) {

        ListNode temp = head;
        ListNode list1 = temp;
        while (temp.next != null) {
            ListNode list2 = temp.next;
            list1 = merge(list1, list2);
            temp = temp.next;
        }
        return list1;
    }

    public ListNode flattenLinkedListRec(ListNode head) {
        if (head == null || head.next == null) {
            return head; // Return head
        }
        ListNode mergedHead = flattenLinkedListRec(head.next);
        return merge(head, mergedHead);
    }

    private ListNode merge(ListNode l1, ListNode l2) {

        ListNode head, tail = null;

        if (l1.val <= l2.val) {
            head = tail = l1;
            l1 = l1.child;
        } else {
            head = tail = l2;
            l2 = l2.child;
        }
        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                tail.child = l1;
                l1 = l1.child;
            } else {
                tail.child = l2;
                l2 = l2.child;
            }
            tail = tail.child;
        }

        if (l1 != null) {
            tail.child = l1;
        }

        if (l2 != null) {
            tail.child = l2;
        }

        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode child;

        ListNode() {
            val = 0;
            next = null;
            child = null;
        }

        ListNode(int data) {
            val = data;
            next = null;
            child = null;
        }

        ListNode(int data, ListNode next1, ListNode next2) {
            val = data;
            next = next1;
            child = next2;
        }
    }
}
/*
    Given a special linked list containing n head nodes where every node in the linked list contains two pointers:

    ‘Next’ points to the next node in the list
    ‘Child’ pointer to a linked list where the current node is the head
    Each of these child linked lists is in sorted order and connected by a 'child' pointer.

    Flatten this linked list such that all nodes appear in a single sorted layer connected by the 'child' pointer and
    return the head of the modified list.
 */
