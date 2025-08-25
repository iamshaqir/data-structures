package linkedlist;

import org.junit.jupiter.api.Test;

public class LL15_ReverseLinkedListKGroups {

    private static final int[] A = {1, 2, 3, 4, 5};
    private static final int K = 1;

    @Test
    void reverseKGroup() {
        ListNode head = Util.print(A);
        ListNode resultNode = reverseKGroup(head, K);
        Util.print(resultNode);
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {

            // Get kth node, store and mark it's next as null
            ListNode kthNode = getKthNode(temp, k);
            if (kthNode == null) {
                if (prev != null) prev.next = temp;
                break;
            }
            ListNode nextNode = kthNode.next;
            kthNode.next = null;

            // Reverse each group
            reverse(temp);

            if (temp == head) {
                // if first group, kth node will be head
                head = kthNode;
            } else {
                // Link reversed group
                prev.next = kthNode;
            }

            prev = temp;
            temp = nextNode;
        }

        return head;
    }

    private void reverse(ListNode temp) {

        ListNode previous = null;
        while (temp != null) {
            ListNode next = temp.next;
            temp.next = previous;
            previous = temp;
            temp = next;
        }
    }

    private ListNode getKthNode(ListNode temp, int k) {
        k -= 1;

        while (temp != null && k > 0) {
            k -= 1;
            temp = temp.next;

        }
        return temp;
    }
}
/*
    Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

    k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a
    multiple of k then left-out nodes, in the end, should remain as it is.

    You may not alter the values in the list's nodes, only nodes themselves may be changed.

    Input: head = [1,2,3,4,5], k = 2
    Output: [2,1,4,3,5]
 */