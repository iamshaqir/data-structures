package org.mshaq.ds;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// Similar to N meetings one room
public class M15_MaxLengthChainPairs {

    public static int maxChainLength(int[][] pairs) {
        List<Pair> list = getPairs(pairs);
        int maxChain = 0;
        Pair previous = list.get(0);
        for (Pair current : list) {
            if (current.start > previous.end) {
                maxChain++;
                previous = current;
            }
        }
        return maxChain;
    }

    private static List<Pair> getPairs(int[][] A) {
        return Arrays.stream(A)
                .map(element -> new Pair(element[0], element[1]))
                .sorted(Comparator.comparingInt((Pair pair) -> pair.end)
                        .thenComparing(pair -> pair.start))
                .collect(Collectors.toList());

    }

    private static class Pair {
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
