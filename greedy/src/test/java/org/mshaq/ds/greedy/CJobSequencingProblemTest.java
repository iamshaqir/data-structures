package org.mshaq.ds.greedy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class CJobSequencingProblemTest {

    H_JobSequencingProblem CJobSequencingProblem;

    @BeforeEach
    void setUp() {
        CJobSequencingProblem = new H_JobSequencingProblem();
    }

    @Test
    void jobSequencing() {

        int[] id = {1, 2, 3, 4};
        int[] deadline = {4, 1, 1, 1};
        int[] profit = {20, 10, 40, 30};

        List<Integer> res = CJobSequencingProblem.JobSequencing(id, deadline, profit);
        System.out.println(res);
    }
}