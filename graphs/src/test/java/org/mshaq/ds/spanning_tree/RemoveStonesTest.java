package org.mshaq.ds.spanning_tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveStonesTest {

    RemoveStones removeStones;

    @BeforeEach
    void setUp() {
        removeStones = new RemoveStones();
    }

    @Test
    void removeStones() {
//        int[][] input = {{0, 0}, {1, 1}, {2, 2}, {2, 3}, {2, 4}, {3, 2}};
        int[][] input = {{0, 0}, {0, 2}, {1, 3}, {3, 0}, {3, 2}, {4, 3}};
        int res = removeStones.removeStones(input);
    }
}