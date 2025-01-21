package org.mshaq.ds.spanning_tree;

import java.util.HashMap;
import java.util.Map;

public class RemoveStones {

    public int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxColumn = 0;
        int n = stones.length;
        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxColumn = Math.max(maxColumn, stone[1]);
        }

        DisJointSet ds = new DisJointSet(maxRow + maxColumn + 1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int row = stones[i][0];
            int column = stones[i][1] + maxRow + 1;
            ds.unionBySize(row, column);
            map.put(row, 1);
            map.put(column, 1);
        }

        int connectedCompCnt = 0;
        for (Integer key : map.keySet()) {
            int uParent = ds.findUltimateParent(key);
            if (uParent == key) {
                connectedCompCnt++;
            }
        }
        return n - connectedCompCnt;
    }
}
