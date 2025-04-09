package com.ms.data.structures.linked_list;

import com.ms.data.structures.linked_list.linkedlist.Node;

public class ListNode {

    public int data;
    public ListNode next;
    public ListNode bottom;

    public ListNode() {
    }

    public ListNode(int data) {
        this.data = data;
    }

    public void print(ListNode head) {
        ListNode tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.data + " -> ");
            tempNode = tempNode.next;
        }
        System.out.println("null");
    }

    public void printBottom(ListNode head) {
        ListNode tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.data + " -> ");
            tempNode = tempNode.bottom;
        }
        System.out.println("null");
    }
}
