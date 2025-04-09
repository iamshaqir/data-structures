package com.ms.data.structures.linked_list;

import com.ms.data.structures.linked_list.linkedlist.Node;

import java.util.HashMap;
import java.util.Map;

public class LinkedListCyclePoint {

    public Node<Integer> cyclePoint(Node<Integer> head) {

        Node<Integer> fast = head;
        Node<Integer> slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow.equals(fast)) {
                slow = head;
                break;
            }
        }

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public Node<Integer> getCycle(Node<Integer> head) {

        Node<Integer> tempNode = head;
        Map<Node<Integer>, Integer> map = new HashMap<>();

        while (tempNode != null) {
            if (map.containsKey(tempNode)) {
                return tempNode;
            }
            map.put(tempNode, tempNode.data);
            tempNode = tempNode.next;
        }
        return null;
    }
}
