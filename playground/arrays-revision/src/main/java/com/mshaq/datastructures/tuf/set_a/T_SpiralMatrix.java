package com.mshaq.datastructures.tuf.set_a;

import java.util.ArrayList;
import java.util.List;

public class T_SpiralMatrix {

    public List<Integer> spiralOrder(int[][] A) {

        int rowL = A.length;
        int columnL = A[0].length;

        List<Integer> L = new ArrayList<>(rowL * columnL);

        int top = 0, bottom = rowL - 1;
        int left = 0, right = columnL - 1;

        while (left <= right && top <= bottom) {

            // Left -> Right
            for (int i = left; i <= right; i++) {
                L.add(A[top][i]);
            }
            top++;

            // Top -> Bottom
            for (int i = top; i <= bottom; i++) {
                L.add(A[i][right]);
            }
            right--;

            // Right -> Left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    L.add(A[bottom][i]);
                }
                bottom--;
            }

            // Bottom -> Top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    L.add(A[i][left]);
                }
                left++;
            }
        }
        return L;
    }
}
