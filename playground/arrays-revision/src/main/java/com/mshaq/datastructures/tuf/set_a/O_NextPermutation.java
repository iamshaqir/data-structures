package com.mshaq.datastructures.tuf.set_a;

public class O_NextPermutation {

    public void nextPermutation(int[] A) {
        int n = A.length;
        int highestPrefixIdx = -1;
        // Find the highest prefix
        for (int i = n - 2; i >= 0; i--) {
            if (A[i] < A[i + 1]) {
                highestPrefixIdx = i;
                break;
            }
        }

        // Edge case if the input is longest of all
        if (highestPrefixIdx == -1) {
            reverse(A, 0, n - 1);
            return;
        }
        // Find slight lowest version of highestPrefix and swap with the highest prefix
        for (int i = n - 1; i > highestPrefixIdx; i++) {
            if (A[i] > A[highestPrefixIdx]) {
                swap(A, i, highestPrefixIdx);
                break;
            }
        }
        // Reverse next part of the highest prefix
        reverse(A, highestPrefixIdx + 1, n - 1);
    }

    private void reverse(int[] A, int si, int ei) {
        while (si < ei) {
            swap(A, si, ei);
            si++;
            ei--;
        }
    }

    private void swap(int[] A, int a, int b) {
        int temp = a;
        A[a] = A[b];
        A[b] = temp;
    }

    // Example 1
    // Input: [2,3,6,5,4,1,0]
    // Expected Output: [2,4,0,1,3,5,6]

    // Example 2
    // Input: [3, 2, 1, 7, 6, 5, 4, 9, 8, 0]
    // Expected Output: [3, 2, 1, 7, 6, 5, 8, 0, 4, 9]
}
