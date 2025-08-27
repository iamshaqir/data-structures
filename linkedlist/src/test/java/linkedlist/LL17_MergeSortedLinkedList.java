package linkedlist;


import org.junit.jupiter.api.Test;

public class LL17_MergeSortedLinkedList {

    int[] L1 = {2, 2, 4, 4};
    int[] L2 = {1, 3, 4, 5 , 6};

    @Test
    void mergeTwoLists_better() {
        ListNode list1 = Util.print(L1);
        ListNode list2 = Util.print(L2);

        ListNode result = mergeTwoLists_better(list1, list2);
        Util.print(result);
    }

    @Test
    void mergeTwoLists_optimized() {
        ListNode list1 = Util.print(L1);
        ListNode list2 = Util.print(L2);

        ListNode result = mergeTwoLists_optimized(list1, list2);
        Util.print(result);
    }

    public ListNode mergeTwoLists_optimized(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        if (list1.val > list2.val) {
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }

        ListNode head = list1;
        while (list1.next != null && list2 != null) {

            if (list1.next.val > list2.val) {
                ListNode temp = list1.next;
                list1.next = list2;
                list2 = list2.next;
                list1.next.next = temp;
            }
            list1 = list1.next;
        }

        if (list2 != null) {
            list1.next = list2;
        }

        return head;
    }


    public ListNode mergeTwoLists_better(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode tail = null;

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        if (list1.val <= list2.val) {
            head = tail = list1;
            list1 = list1.next;
        } else {
            head = tail = list2;
            list2 = list2.next;
        }

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if (list1 != null) {
            tail.next = list1;
        }

        if (list2 != null) {
            tail.next = list2;
        }

        return head;
    }
}

/*
    You are given the heads of two sorted linked lists list1 and list2.

    Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two
    lists.

    Return the head of the merged linked list.

    Input: list1 = [1,2,4], list2 = [1,3,4]
    Output: [1,1,2,3,4,4]
 */