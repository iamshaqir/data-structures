package com.mshq.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class C_ImplementMaxHeap {

    private static List<Integer> list;

    private static int counter;

    public C_ImplementMaxHeap() {
        list = new ArrayList<>();
        counter = 0;
    }

    public void initializeHeap() {
        list.clear();
        counter = 0;
    }
    public void insert(int key) {
        list.add(key);
        heapifyUp(counter);
        counter++;
    }

    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;

        if (index > 0 && list.get(index) > list.get(parent)) {
            swap(parent, index);
            heapifyUp(parent);
        }
    }

    private void swap(int smallest, int idx) {
        int temp = list.get(smallest);
        list.set(smallest, list.get(idx));
        list.set(idx, temp);
    }

    public void changeKey(int index, int newVal) {
        if (counter == 0) {
            throw new NoSuchElementException("Heap is empty");
        }
        list.set(index, newVal);
        if (list.get(index) > newVal) {
            list.set(index, newVal);
            heapifyDown(index);
        } else {
            list.set(index, newVal);
            heapifyUp(index);
        }


    }

    private void heapifyDown(int index) {
        int largest = index;
        int left = 2 * index + 1, right = 2 * index + 2;
        if (left < counter && list.get(left) > list.get(largest)) {
            largest = left;
        }

        if (right < counter && list.get(right) > list.get(largest)) {
            largest = right;
        }

        if (largest != index) {
            swap(largest, index);
            heapifyDown(largest);
        }
    }

    public void extractMax() {
        Integer topValue = list.get(0);
        swap(0, counter - 1);
        list.remove(counter - 1);
        counter--;
        if (counter > 0) heapifyDown(0);
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    public int getMax() {
        return list.get(0);
    }

    public int heapSize() {
        return counter;
    }

    public static void main(String[] args) {
        C_ImplementMaxHeap s = new C_ImplementMaxHeap();
        s.initializeHeap();
        s.insert(909);
        System.out.println(s.heapSize());
        s.insert(302);
        s.extractMax();
        s.extractMax();
        s.insert(651);
        s.insert(192);
        System.out.println(s.isEmpty());
        System.out.println(s.getMax());
        System.out.println(s.getMax());
        System.out.println(s.heapSize());
    }
}
