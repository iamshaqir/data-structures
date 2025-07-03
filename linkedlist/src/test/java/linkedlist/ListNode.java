package linkedlist;

public class ListNode {
    int val;
    ListNode next;
    ListNode previous;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next, ListNode previous) {
        this.val = val;
        this.next = next;
        this.previous = previous;
    }
}
