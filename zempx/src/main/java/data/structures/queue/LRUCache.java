package com.ms.data.structures.queue;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
    int size;
    Node<K, V> head;
    Node<K, V> tail;

    Map<K, Node<K, V>> map;

    public LRUCache(int size) {
        this.size = size;
        this.map = new HashMap<>();
        head = new Node<>();
        tail = new Node<>();
        head.next = tail;
        tail.prev = head;
    }

    public void put(K key, V value) {
        Node<K, V> newNode = new Node<>(key, value);
        if (map.containsKey(key)) {
            remove(map.get(key));
        }

        if (isFull()) {
            remove(tail.prev);
        }

        insert(newNode);
    }

    public V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }
        Node<K, V> node = map.get(key);
        remove(node);
        insert(node);
        return node.value;
    }

    private void insert(Node<K, V> node) {
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void remove(Node<K, V> node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private boolean isFull() {
        return map.size() == size;
    }

    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;
        Node<K, V> prev;

        public Node() {
            this(null, null);
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
