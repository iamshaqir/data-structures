package org.mshaq.ds;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class M14_FractionalKnapsack {

    public static void main(String[] args) {
        List<Integer> values = List.of(60, 100, 120);
        List<Integer> weights = List.of(10, 20, 30);
        int capacity = 50;
        double fractionalKnapsack = fractionalKnapsack(values, weights, capacity);
        System.out.println(fractionalKnapsack);
    }

    public static double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        List<Item> items = getItems(val, wt);
        double maxValue = 0;
        int currentWeight = 0;

        for (Item item : items) {
            if (currentWeight + item.weight <= capacity) {
                currentWeight += item.weight;
                maxValue += item.value;
            } else {
                int remaining = capacity - currentWeight;
                maxValue += (double) item.value / (double) item.weight * (double) remaining;
                break;
            }
        }

        return maxValue;
    }

    private static List<Item> getItems(List<Integer> val, List<Integer> wt) {
        return IntStream.range(0, Math.min(wt.size(), val.size()))
                .mapToObj(i -> new Item(val.get(i), wt.get(i)))
                .sorted(Comparator.comparingDouble((Item item) -> item.weight == 0
                                        ? Double.MAX_VALUE
                                        : (double) item.value / item.weight)
//                                : (double) item.weight / item.value) // Use weight/value to get in DESC order
                                .reversed()
                ).collect(Collectors.toList());
    }

    private static class Item {

        int value;
        int weight;

        public Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }
}
