package data.playground.revision.linkedlist;


import data.structures.linked_list.ListNode;

public class RemoveLinkedListCycle {

    public ListNode removeCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false;
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)) {
                isCycle = true;
                slow = head;
                break;
            }
        }

        if (!isCycle) {
            return head;
        }

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        while (fast.next != slow) {
            fast = fast.next;
        }
        fast.next = null;
        return head;
    }
}
