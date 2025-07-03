package linkedlist;

import org.junit.jupiter.api.Test;

/*
    Time Complexity: O(max(M, N))
    Space Complexity: O(max(M,N))
 */
public class LL02_AddTwoNumbers {

    int[] L11 = {2, 4, 3}, L21 = {5, 6, 4};
    int[] L12 = {9, 9, 9, 9, 9, 9, 9}, L22 = {9, 9, 9, 9};
    int[] L1 = {1, 8, 7}, L2 = {2, 6, 4};

    @Test
    void addTwoNumbers() {
        ListNode l1 = Util.arrayToLinkedList(L1);
        ListNode l2 = Util.arrayToLinkedList(L2);

        Util.print(l1);
        Util.print(l2);

        ListNode listNode = addTwoNumbers(l1, l2);
        Util.print(listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode tail = head;

        int carry = 0;
        while (l1 != null || l2 != null || carry == 1) {
            int sum = 0;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum = sum + carry;
            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;

        }
        return head.next;
    }
}
/*
    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
    order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Input: l1 = [2,4,3], l2 = [5,6,4]
    Output: [7,0,8]
    Explanation: 342 + 465 = 807.

    Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    Output: [8,9,9,9,0,0,0,1]

    NOTE: During revision check what is Borrow handling for subtraction
 */
