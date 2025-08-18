package linkedlist;

/**
 * Leetcode: <a href="https://leetcode.com/problems/intersection-of-two-linked-lists/description/">Intersection of Two Linked Lists</a>
 */
public class LL11_IntersectionPointLinkedList {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;

        while (tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;

            if (tempA == tempB) return tempA;

            if (tempA.next == null) tempA = headB;
            if (tempB.next == null) tempB = headA;
        }
        return tempA;
    }

    public ListNode getIntersectionNodeBetter(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;

        int n1 = 0, n2 = 0;

        while (tempA != null) {
            n1++;
            tempA = tempA.next;
        }

        while (tempB != null) {
            n2++;
            tempB = tempB.next;
        }

        if (n1 < n2) {
            return findCollision(headA, headB, n2 - n1);
        }

        return findCollision(headB, headA, n2 - n1);

    }

    private ListNode findCollision(ListNode smallest, ListNode longest, int longestHeadStart) {
        ListNode tempA = smallest;
        ListNode tempB = longest;
        int counter = 0;
        while (counter < longestHeadStart) {
            tempB = tempB.next;
            counter++;
        }
        while (tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;
        }

        return tempB;
    }

    // TC O(N X N)
    public ListNode getIntersectionNodeBrute(ListNode headA, ListNode headB) {

        ListNode tempA = headA;
        ListNode tempB = headB;

        while (tempA != null) {

            while (tempB != null) {
                if (tempA.val == tempB.val) return tempB;
                tempB = tempB.next;
            }
            tempA = tempA.next;
        }
        return null;
    }
}
/*
    Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the
    two linked lists have no intersection at all, return null.
    The test cases are generated such that there are no cycles anywhere in the entire linked structure.

    Note that the linked lists must retain their original structure after the function returns.

 */