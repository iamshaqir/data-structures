package linkedlist;

import org.junit.jupiter.api.Test;

import static linkedlist.Util.arrayToLinkedList;
import static linkedlist.Util.print;

/**
 * TUF: <a href="https://takeuforward.org/plus/dsa/linked-list/logic-building/sort-a-ll-of-0's-1's-and-2's">Sort 0, 1, 2</a>
 */
class LL04_SortLinkedList012 {

    int[] A = {1, 2, 0, 1, 2, 0, 1};
    int[] A1 = {1, 0, 2, 0, 1};

    @Test
    public void sortList() {
        ListNode head = arrayToLinkedList(A);
        print(head);

        ListNode sortList = sortList(head);
        print(sortList);
    }

    public ListNode sortList(ListNode head) {

        ListNode zeroHead = new ListNode(-1);
        ListNode firstHead = new ListNode(-1);
        ListNode secondHead = new ListNode(-1);

        ListNode zero = zeroHead;
        ListNode first = firstHead;
        ListNode second = secondHead;
        ListNode temp = head;
        while (temp != null) {
            if (temp.val == 0) {
                zero.next = temp;
                zero = zero.next;
            } else if (temp.val == 1) {
                first.next = temp;
                first = first.next;
            } else {
                second.next = temp;
                second = second.next;
            }
            temp = temp.next;
        }

        zero.next = (firstHead.next != null) ? firstHead.next : secondHead.next;
        first.next = secondHead.next;
        second.next = null;
        return zeroHead.next;
    }

    public ListNode sortListBrute(ListNode head) {
        int c1 = 0, c2 = 0, c3 = 0;
        ListNode temp = head;
        while (temp != null) {
            if (temp.val == 0) {
                c1++;
            } else if (temp.val == 1) {
                c2++;
            } else {
                c3++;
            }
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            if (c1 > 0) {
                temp.val = 0;
                c1--;
            } else if (c2 > 0) {
                temp.val = 1;
                c2--;
            } else {
                temp.val = 2;
                c3--;
            }
            temp = temp.next;
        }
        return head;
    }
}
/*
    Given the head of a singly linked list consisting of only 0, 1 or 2. Sort the given linked list and return the head
    of the modified list. Do it in-place by changing the links between the nodes without creating new nodes.

    Input: head -> 1 -> 0 -> 2 -> 0 -> 1
    Output: head -> 0 -> 0 -> 1 -> 1 -> 2
    Explanation: The values after sorting are [0, 0, 1, 1, 2].
 */
