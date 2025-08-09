package linkedlist;

import org.junit.jupiter.api.Test;

/**
 * TUF: <a href="https://takeuforward.org/plus/dsa/linked-list/faqs--medium/add-one-to-a-number-represented-by-ll">Add One to LinkedList number</a>
 */
public class LL07_AddOne {

    int[] A = {4, 9, 9};

    @Test
    void addOne() {
        ListNode head = Util.print(A);
        ListNode result = addOne(head);
        Util.print(result);
    }

    private ListNode addOne(ListNode head) {
        head = reverse(head);
        ListNode current = head;
        int carry = 1;
        while (current != null) {
            int sum = current.val + carry;
            carry = sum / 10;
            current.val = sum % 10;

            if (carry == 0) break;
            if (current.next == null) {
                current.next = new ListNode(carry);
                break;
            }
            current = current.next;
        }
        head = reverse(head);
        return head;
    }

    private ListNode reverse(ListNode head) {

        ListNode previous = null, temp = head;
        while (temp != null) {
            ListNode next = temp.next;
            temp.next = previous;
            previous = temp;
            temp = next;
        }
        return previous;
    }

    @Test
    void addOneBrute() {
        ListNode head = Util.print(A);
        ListNode result = addOneBrute(head);
        Util.print(result);
    }

    private ListNode addOneBrute(ListNode head) {
        int sum = 0;
        ListNode temp = head;
        while (temp != null) {
            sum = sum * 10 + temp.val;
            temp = temp.next;
        }
        ListNode root = new ListNode(-1);
        ListNode tail = root;
        String number = String.valueOf(sum + 1);
        for (int i = 0; i < number.length(); i++) {
            char charAt = number.charAt(i);
            tail.next = new ListNode(charAt - '0');
            tail = tail.next;
        }

        return root.next;
    }
}
/*
    Given the head of a singly linked list representing a positive integer number. Each node of the linked list
    represents a digit of the number, with the 1st node containing the leftmost digit of the number and so on.
    The task is to add one to the value represented by the linked list and return the head of a linked list
    containing the final value.

    The number will contain no leading zeroes except when the value represented is zero itself.

    Input: head -> 1 -> 2 -> 3
    Output: head -> 1 -> 2 -> 4
    Explanation: The number represented by the linked list = 123.
    123 + 1 = 124.
 */
