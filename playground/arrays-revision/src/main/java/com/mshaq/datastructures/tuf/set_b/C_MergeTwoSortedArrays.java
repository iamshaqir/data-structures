package com.mshaq.datastructures.tuf.set_b;

import java.util.Arrays;

public class C_MergeTwoSortedArrays {


    public void mergeBrute(int[] A, int m, int[] B, int n) {
        int index = 0;
        int p1 = 0, p2 = 0;
        int[] tempArr = new int[m + n];

        while (p1 < m && p2 < n) {
            if (A[p1] <= B[p2]) {
                tempArr[index++] = A[p1++];
            } else {
                tempArr[index++] = A[p2++];
            }
        }

        while (p1 < m) {
            tempArr[index++] = A[p1++];
        }

        while (p2 < n) {
            tempArr[index++] = A[p2++];
        }

        System.arraycopy(tempArr, 0, A, 0, tempArr.length);
    }

    public void mergeBetter(int[] A, int m, int[] B, int n) {

        // Arrays are sorted so, compare second arrays first element with first arrays last element, until
        // array elements are in correct arrays
        int p1 = m - 1, p2 = 0;
        while (p1 >= 0 && p2 < n) {

            if (A[p1] < B[p2]) {
                break;
            }
            swap(A, B, p1, p2);
            p1--;
            p2++;
        }

        Arrays.sort(A, 0, m);
        Arrays.sort(B);
        System.arraycopy(B, 0, A, m, n);
    }

    // using Shell sort Gap method
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
        System.out.println(Arrays.toString(A));
        System.arraycopy(B, 0, A, m, n);
    }

    private static void swapIfGreater(int[] A, int[] B, int left, int right) {
        if (A[left] > A[right]) {
            swap(A, B, left, right);
        }
    }

    private static void swap(int[] A, int[] B, int p1, int p2) {
        int temp = A[p1];
        A[p1] = B[p2];
        B[p2] = temp;
    }
    public void mergeO(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        int n1 = m - 1;
        int n2 = n - 1;

        while (n2 >= 0) {
            if (n1 >= 0 && nums1[n1] > nums2[n2]) {
                nums1[i] = nums1[n1];
                n1--;
            } else {
                nums1[i] = nums2[n2];
                n2--;
            }
            i--;
        }
    }
}
