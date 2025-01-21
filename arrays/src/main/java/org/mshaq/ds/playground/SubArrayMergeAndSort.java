package org.mshaq.ds.playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SubArrayMergeAndSort {

    public static void main(String[] args) {
        int[] a = {1, 32, 5, 6, 9, 3};
        int k = 2;
        int[] res = subArray(a, k);
        System.out.println(Arrays.toString(res));
    }

    // 1, 32, 5, 6, 9, 3
    public static int[] subArray(int[] a, int k) {
        List<Pair<Integer, Integer>> mergedList = new ArrayList<>();
        for (int i = 0; i < a.length; ) {
            int indexPos = i;
            int counter = 0;
            StringBuilder sb = new StringBuilder();
            while (counter < k) {
                sb.append(a[i]);
                counter++;
                i++;
            }
            Integer num = Integer.valueOf(sb.toString());
            mergedList.add(new Pair<>(num, indexPos));
        }
        mergedList.sort(Comparator.comparingInt(p -> p.key));
        int[] res = new int[a.length];
        int counter = 0;
        for (Pair<Integer, Integer> pair : mergedList) {
            int resIndexCounter = 0;
            int pairIdx = pair.value;
            while (resIndexCounter < k) {
                res[counter++] = a[pairIdx++];
                resIndexCounter++;
            }
        }
        return res;
    }

    static class Pair<K, V> {
        private final K key;
        private final V value;
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
