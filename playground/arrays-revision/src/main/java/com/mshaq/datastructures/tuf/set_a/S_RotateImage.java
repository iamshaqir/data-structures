package com.mshaq.datastructures.tuf.set_a;

public class S_RotateImage {

    public void rotate(int[][] A) {

        // Transpose of Matric
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                swap(A, i, j);
            }
        }

        // Reverse row
        for (int i = 0; i < A.length; i++) {
            reverse(A[i]);
        }
    }

    private void reverse(int[] A) {
        int si = 0, ei = A.length - 1;
        while (si < ei) {
            swap(A, si, ei);
            si++;
            ei--;
        }
    }

    private void swap(int[][] A, int i, int j) {
        int temp = A[i][j];
        A[i][j] = A[j][i];
        A[j][i] = temp;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
