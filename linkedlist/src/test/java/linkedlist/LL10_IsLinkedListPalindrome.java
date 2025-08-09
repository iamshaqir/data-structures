package linkedlist;

import org.junit.jupiter.api.Test;

/**
 * Leetcode: <a href="https://leetcode.com/problems/palindrome-linked-list/description/">Palindrome Linked List</a>
 */
public class LL10_IsLinkedListPalindrome {

    int[] A = {1, 2, 2, 1};

    @Test
    void isPalindrome() {
        ListNode head = Util.print(A);
        boolean result = isPalindrome(head);
        System.out.println("Is palindrome: " + result);
    }

    public boolean isPalindrome(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode first = head;
        ListNode second = reverse(slow.next);
        while (second != null) {
            if (first.val != second.val) return false;
            first = first.next;
            second = second.next;
        }

        return true;
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
}

/*
    Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

    Input: head = [1,2,2,1]
    Output: true
 */