package linkedlist;

public class Util {
    public static void print(ListNode listNode) {
        ListNode tempListNode = listNode;
        while (tempListNode != null) {
            System.out.print(tempListNode.val + " -> ");
            tempListNode = tempListNode.next;
        }
        System.out.println("null");
    }

    public static ListNode arrayToLinkedList(int[] A) {
        ListNode head = new ListNode(A[0]);

        ListNode previous = head;
        for (int i = 1; i < A.length; i++) {
            ListNode newListNode = new ListNode(A[i], null, previous);
            previous.next = newListNode;
            previous = newListNode;
        }
        return head;
    }

    public static ListNode print(int[] A) {
        ListNode head = arrayToLinkedList(A);
        print(head);
        return head;
    }
}
