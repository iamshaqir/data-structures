package linkedlist;

/**
 * TUF: <a href="https://takeuforward.org/plus/dsa/linked-list/faqs--medium/length-of-loop-in-ll">Length of loop in LL</a>
 */
public class LL14_LengthOfLoop {

    public int findLengthOfLoop(ListNode head) {

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

        if (!flag) return 0;

        int counter = 1;
        fast = fast.next;
        while (slow != fast) {
            fast = fast.next;
            counter++;
        }

        return counter;
    }
}
/*
    Given the head of a singly linked list, find the length of the loop in the linked list if it exists. Return the
    length of the loop if it exists; otherwise, return 0.

    Input: head -> 1 -> 2 -> 3 -> 4 -> 5, pos = 1
    Output: 4
    Explanation: 2 -> 3 -> 4 -> 5 - >2, length of loop = 4
 */