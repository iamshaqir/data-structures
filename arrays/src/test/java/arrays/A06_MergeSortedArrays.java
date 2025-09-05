package arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class A06_MergeSortedArrays {

    private int[] A = {1, 2, 3, 5, 7, 9, 0, 0, 0, 0, 0, 0};
    private int[] B = {2, 4, 6, 7, 8, 10};
    private int m = 6;
    private int n = 6;

    @Test
    public void merge() {
        merge(A, m, B, n);
        System.out.println(Arrays.toString(A));
    }

    public void merge(int[] A, int m, int[] B, int n) {
        int length = m + n;
        int gap = (length / 2) + (length % 2);

        while (gap > 0) {
            int left = 0, right = left + gap;
            while (right < length) {
                // Need to follow 3 Conditions, which will sort the two array in Ascending order

                // When one pointer in left array & other in right array
                if (left < m && right >= m) {
                    swapIfGreater(A, B, left, right - m);
                } else if (left >= m) { // When two pointer in right array
                    swapIfGreater(B, B, left - m, right - m);
                } else { // When two pointers in left arrays
                    swapIfGreater(A, A, left, right);
                }
                left++;
                right++;
            }
            if (gap == 1) break;
            gap = (gap / 2) + (gap % 2);
        }
        System.arraycopy(B, 0, A, m, n);
    }

    private void swapIfGreater(int[] A, int[] B, int left, int right) {
        if (A[left] > B[right]) {
            swap(A, B, left, right);
        }
    }

    public void merge_brute(int[] A, int m, int[] B, int n) {

        // Now that arrays or sorted, compare A's last with B's first and swap, using two pointers
        int p1 = A.length - n - 1;
        int p2 = 0;

        while (p1 >= 0 && p2 < n) {
            // there is no point to check if B's first element is greater than A's last
            if (A[p1] < B[p2]) break;
            swap(A, B, p1, p2);
            p1--;
            p2++;
        }

    }

    private void swap(int[] A, int[] B, int p1, int p2) {
        int temp = A[p1];
        A[p1] = B[p2];
        B[p2] = temp;
    }
}
/*
    You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
    representing the number of elements in nums1 and nums2 respectively.

    Merge nums1 and nums2 into a single array sorted in non-decreasing order.

    The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To
    accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
    and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

    Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    Output: [1,2,2,3,5,6]
    Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
    The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 */