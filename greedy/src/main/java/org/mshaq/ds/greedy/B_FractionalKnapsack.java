package org.mshaq.ds.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
public class FractionalKnapsack {

    public double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {

        List<Item> items = getItems(val, wt);
        items.sort(Comparator.comparingDouble((Item item) -> item.weight == 0 ?
                Double.MAX_VALUE :
                (double) item.weight / item.value).reversed());
//        items.sort(new ItemComparator());
        System.out.println(items);
        int currentWeight = 0;
        double finalValue = 0;
        for (Item item : items) {
            if (currentWeight + item.weight <= capacity) {
                currentWeight += item.weight;
                finalValue += item.value;
            } else {
                int remaining = capacity - currentWeight;
                finalValue += ((double) item.value / (double) item.weight) * (double) remaining;
                break;
            }
        }
        return finalValue;
    }

    private List<Item> getItems(List<Integer> val, List<Integer> wt) {
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < val.size(); i++) {
            items.add(new Item(val.get(i), wt.get(i)));
        }
        return items;
    }

    public static class Item {
        Integer value;
        Integer weight;

        public Item(Integer value, Integer weight) {
            this.value = value;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "value=" + value +
                    ", weight=" + weight +
                    '}';
        }
    }
}

class ItemComparator implements Comparator<FractionalKnapsack.Item> {
    @Override
    public int compare(FractionalKnapsack.Item o1, FractionalKnapsack.Item o2) {
        // Avoid division by zero
        double ratio1 = o1.weight == 0 ? Double.MAX_VALUE : (double) o1.value / o1.weight;
        double ratio2 = o2.weight == 0 ? Double.MAX_VALUE : (double) o2.value / o2.weight;
        // Descending order
        return Double.compare(ratio2, ratio1);
    }
}

