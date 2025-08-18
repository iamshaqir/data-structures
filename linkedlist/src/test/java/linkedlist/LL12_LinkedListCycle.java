package linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode: <a href="https://leetcode.com/problems/linked-list-cycle/description/">Linked List Cycle</a>
 */
public class LL12_LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }

        return false;
    }

    // SC: O(N)
    public boolean hasCycleBrute(ListNode head) {

        Map<ListNode, Integer> map = new HashMap<>();
        ListNode temp = head;

        while (temp != null) {
            if (map.containsKey(temp)) return true;
            map.put(temp, -1);
            temp = temp.next;
        }

        return false;
    }
}
/*
    Given head, the head of a linked list, determine if the linked list has a cycle in it.

    There is a cycle in a linked list if there is some node in the list that can be reached
    again by continuously following the next pointer.
    Return true if there is a cycle in the linked list. Otherwise, return false.

    Input: head = [3,2,0,-4], pos = 1
    Output: true
    Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed)

    Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed).
    It is -1 if there is no cycle. Note that pos is not passed as a parameter.
 */