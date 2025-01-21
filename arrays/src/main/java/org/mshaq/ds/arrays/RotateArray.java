package org.mshaq.ds.arrays;

public class RotateArray {

    public void rotateLeftBrute(int[] input, int k) {

        while (k > 0) {
            int temp = input[input.length - 1];
            for (int i = input.length - 1; i > 0; i--) {
                input[i] = input[i - 1];
            }
            k--;
            input[0] = temp;
        }
    }

    public void rotateLeftOpt(int[] a, int k) {

        if (k < 0 || k > a.length) {
            return;
        }

        reverse(a, 0, a.length - 1);
        reverse(a, 0, k - 1);
        reverse(a, k, a.length - 1);
    }

    public void rotateRightOpt(int[] a, int k) {

        if (k < 0 || k > a.length) {
            return;
        }

        reverse(a, 0, a.length - 1);
        reverse(a, 0, a.length - k - 1);
        reverse(a, a.length - k, a.length - 1);
    }

    private void reverse(int[] a, int si, int ei) {

        while (si < ei) {
            swap(a, si, ei);
            ei--;
            si++;
        }
    }

    private void swap(int[] a, int si, int ei) {
        int temp = a[si];
        a[si] = a[ei];
        a[ei] = temp;
    }
}
