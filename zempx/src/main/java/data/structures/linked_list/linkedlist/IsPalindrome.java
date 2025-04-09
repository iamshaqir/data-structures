package com.ms.data.structures.linked_list.linkedlist;

public class IsPalindrome {


    public boolean isPalindrome(Node<Character> head) {

        // Get middle TreeNode
        Node<Character> middle = getMiddleNode(head);

        // Reverse second part
        Node<Character> left = head;
        Node<Character> right = getReversedHead(middle);

        // Compare
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    private Node<Character> getReversedHead(Node<Character> middle) {


        Node<Character> current = middle;
        Node<Character> prev = null;
        Node<Character> next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    private Node<Character> getMiddleNode(Node<Character> head) {

        Node<Character> fast = head;
        Node<Character> slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
