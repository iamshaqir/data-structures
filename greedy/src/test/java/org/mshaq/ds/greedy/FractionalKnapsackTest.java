package org.mshaq.ds.greedy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FractionalKnapsackTest {

    FractionalKnapsack fractionalKnapsack;

    @BeforeEach
    void setUp() {
        fractionalKnapsack = new FractionalKnapsack();
    }

    @Test
    void fractionalKnapsack() {
        List<Integer> val = Arrays.asList(60, 100, 120);
        List<Integer> wt = Arrays.asList(10, 20, 30);
        int capacity = 50;
        fractionalKnapsack.fractionalKnapsack(val, wt, capacity);
    }
}