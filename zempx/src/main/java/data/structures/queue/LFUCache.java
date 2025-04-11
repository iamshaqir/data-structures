package data.structures.queue;

import java.util.HashMap;
import java.util.Map;


/**
 * <aset href="https://github.com/striver79/SDESheet/blob/main/LFUCacheJava">LFU Cache</aset>
 *
 * @param <K>
 * @param <V>
 */
public class LFUCache<K, V> {

    private static final int DEFAULT_CAPACITY = 16;
    int size;

    int capacity;
    int minimumFrequency;
    Map<K, Node<K, V>> nodeMap;

    Map<Integer, DoublyLinkedList<K, V>> freqMap;

    public LFUCache() {
        this(DEFAULT_CAPACITY);
    }

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minimumFrequency = 0;
        this.size = 0;
        this.nodeMap = new HashMap<>();
        this.freqMap = new HashMap<Integer, DoublyLinkedList<K, V>>();
    }

    public void put(K key, V value) {
        if (nodeMap.isEmpty()) {
            return;
        }

        if (nodeMap.containsKey(key)) {
            Node<K, V> node = nodeMap.get(key);
            node.value = value;
            updateNode(node);
            return;
        }
        size++;
        minimumFrequency = 1;
        Node<K, V> newNode = new Node<>(key, value);
        if (size > capacity) {
            DoublyLinkedList<K, V> newList = freqMap.get(newNode.frequency);
            newList.remove(newList.tail.prev);
            nodeMap.remove(newList.tail.prev.key);
            size--;
        }
        DoublyLinkedList<K, V> newList = freqMap.getOrDefault(newNode.frequency, new DoublyLinkedList<>());
        newList.add(newNode);
        freqMap.put(newNode.frequency, newList);
        nodeMap.put(key, newNode);
    }

    public V get(K key) {
        Node<K, V> curNode = nodeMap.get(key);
        if (curNode == null) {
            return null;
        }
        updateNode(curNode);
        return curNode.value;
    }

    private void updateNode(Node<K, V> node) {
        int currentFreq = node.frequency;
        DoublyLinkedList<K, V> currentList = freqMap.get(currentFreq);
        currentList.remove(node);
        if (currentFreq == minimumFrequency && currentList.size == 0) {
            minimumFrequency++;
        }
        node.frequency += 1;
        DoublyLinkedList<K, V> newList = freqMap.getOrDefault(node.frequency, new DoublyLinkedList<>());
        newList.add(node);
        freqMap.put(node.frequency, newList);
    }


    static class Node<K, V> {
        K key;
        V value;

        int frequency;
        Node<K, V> next;
        Node<K, V> prev;

        public Node() {
            this(null, null);
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
        }
    }

    static class DoublyLinkedList<K, V> {

        Node<K, V> head;
        Node<K, V> tail;

        int size;

        public DoublyLinkedList() {
            this.size = 0;
            this.head = new Node<>();
            this.tail = new Node<>();
            head.next = tail;
            tail.next = head;
        }

        public void add(Node<K, V> node) {
            node.next = head.next;
            node.next.prev = node;
            head.next = node;
            node.prev = head;
            size++;
        }

        public void remove(Node<K, V> node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

    }
}
