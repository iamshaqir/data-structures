package arrays;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class A2_ReverseArray {

    int[] A = {5, 4, 3, 1, 2};

    @Test
    void reverse() {
        int[] reversed = reverse(A);
        System.out.println(Arrays.toString(reversed));
    }

    int[] reverse(int[] A) {
        int[] temp = A.clone();
        reverseRec(temp, 0, A.length - 1);
        return temp;
    }

    private void reverseRec(int[] A, int si, int ei) {
        if (si >= ei) {
            return;
        }
        swap(A, si, ei);
        reverseRec(A, si + 1, ei - 1);
    }

    private void swap(int[] A, int si, int ei) {
        int temp = A[si];
        A[si] = A[ei];
        A[ei] = temp;
    }
}
