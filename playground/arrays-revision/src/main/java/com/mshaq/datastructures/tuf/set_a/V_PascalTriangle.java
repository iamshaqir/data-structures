package com.mshaq.datastructures.tuf.set_a;

import java.util.ArrayList;
import java.util.List;

public class V_PascalTriangle {


    // Given Row and Column position get element
    static class Variety1 {

        public int getValue(int row, int column) {
            return getNcR(row - 1, column - 1);
        }

        private int getNcR(int n, int r) {
            int result = 1;
            for (int i = 0; i < r; i++) {
                result = result * (n - i);
                result = result / i + 1;
            }
            return result;
        }
    }

    // Given Row number get Row elements
    static class Variety2 {
        public List<Integer> get(int row) {
            List<Integer> list = new ArrayList<>();
            int result = 1;
            list.add(result);
            for (int column = 1; column < row; column++) {
                result = result * (row - column);
                result = result / column;
                list.add(result);
            }
            return list;
        }
    }

    // Get the Pascal tree for given number of row
    static class Variety3 {

        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 1; i <= numRows; i++) {
                result.add(get(i));
            }
            return result;
        }

        private List<Integer> get(int row) {
            List<Integer> list = new ArrayList<>();
            int result = 1;
            list.add(result);
            for (int column = 1; column < row; column++) {
                result = result * (row - column);
                result = result / column;
                list.add(result);
            }
            return list;
        }
    }
}
