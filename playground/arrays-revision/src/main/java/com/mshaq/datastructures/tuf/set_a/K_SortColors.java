package com.mshaq.datastructures.tuf.set_a;

public class K_SortColors {

    // Count 0's, 1's and 2's and overwrite input array
    public void sortColorsBe(int[] A) {
        int zero = 0, one = 0, two = 0;

        for (int num : A) {
            if (num == 0) {
                zero++;
            } else if (num == 1) {
                one++;
            } else {
                two++;
            }
        }

        for (int i = 0; i < zero; i++) {
            A[i] = 0;
        }

        for (int i = zero; i < zero + one; i++) {
            A[i] = 1;
        }

        for (int i = zero + one; i < A.length; i++) {
            A[i] = 2;
        }
    }

    // using Dutch National Flag, three pointers
    // Input: nums = [2,0,2,1,1,0]
    // Output: [0,0,1,1,2,2]
    // [0,1,2,0,1,2,1,2,0,0,0,1]

    // Edge cases: If all the values are zeros, counting sort will perform better
    public void sortColors(int[] A) {
        int low = 0, mid = 0, high = A.length - 1;
        while (mid <= high) {

            if (A[mid] == 0) {
                swap(A, low, mid);
                low++;
                mid++;
            } else if (A[mid] == 1) {
                mid++;
            } else {
                swap(A, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] A, int start, int end) {
        int temp = A[start];
        A[start] = A[end];
        A[end] = temp;
    }
}
