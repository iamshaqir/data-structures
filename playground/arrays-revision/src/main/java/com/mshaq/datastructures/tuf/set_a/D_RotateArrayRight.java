package com.mshaq.datastructures.tuf.set_a;

public class D_RotateArrayRight {

    //  nums = [1,2,3,4,5,6,7], k = 3
    public void rotate(int[] A, int k) {
        // Make sure k is with Array's range i.e., k less than n
        int n = A.length;
        k = k % n;
        reverse(A, 0, n - 1);
        reverse(A, 0, k - 1);
        reverse(A, k, n - 1);
    }

    private void reverse(int[] A, int si, int ei) {
        while (si < ei) {
            swap(A, si, ei);
            si++;
            ei--;
        }
    }

    private void swap(int[] A, int si, int ei) {
        int temp = A[si];
        A[si] = A[ei];
        A[ei] = temp;
    }
}
