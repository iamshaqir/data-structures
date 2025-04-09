package com.mshaq.datastructures.tuf.set_b;

import java.util.HashMap;
import java.util.Map;

public class A_SubArrayEqualsXOR {


    public int getXOR(int[] A, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int count = 0;
        int xor = 0;

        for (int element : A) {
            xor = xor ^ element;
            // Calculate if  it makes equals to k XOR
            int x = xor ^ k;

            if (map.containsKey(x)) {
                count += map.get(x);
            }
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        return count;
    }
}
