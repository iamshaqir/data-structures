package linkedlist;

import org.junit.jupiter.api.Test;

import static linkedlist.Util.print;

/**
 * Leetcode: <a href="https://leetcode.com/problems/middle-of-the-linked-list/description/">876. Middle of the Linked List-</a>
 */
public class LL08_MiddleOfLinkedList {

    int odd[] = {1, 2, 3, 4, 5};
    int even[] = {1, 2, 3, 4, 5, 6};

    @Test
    void middleNode() {
        ListNode oddHead = print(odd);
        ListNode middleNode = middleNode(oddHead);
        print(middleNode);

        System.out.println("------------------");

        ListNode evenHead = print(even);
        middleNode = middleNode(evenHead);
        print(middleNode);
    }

    public ListNode middleNode(ListNode head) {

        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return slowPointer;
    }
}