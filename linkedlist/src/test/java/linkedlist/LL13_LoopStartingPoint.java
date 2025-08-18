package linkedlist;

/**
 * Leetcode: <a href="https://leetcode.com/problems/linked-list-cycle-ii/description/">LL Loop Starting point</a>
 */
public class LL13_LoopStartingPoint {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean flag = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                flag = true;
                break;
            }
        }
        if (!flag) return null;
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
/*
    Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
    There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
    following the next pointer.

    Input: head = [3,2,0,-4], pos = 1
    Output: tail connects to node index 1
    Explanation: There is a cycle in the linked list, where tail connects to the second node.

    Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed).
    It is -1 if there is no cycle. Note that pos is not passed as a parameter.
 */