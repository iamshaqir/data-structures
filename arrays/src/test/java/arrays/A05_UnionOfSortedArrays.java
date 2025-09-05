package arrays;

public class A05_UnionOfSortedArrays {

    public int[] unionArray(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;

        int p1 = 0, p2 = 0;
        int counter = 0;
        int[] result = new int[n + m];
        while (p1 < n && p2 < m) {
            if (nums1[p1] <= nums2[p2]) {
                if (result.length == 0 || result[result.length - 1] != nums1[p1]) {
                    result[counter++] = nums1[p1];
                }
                p1++;
            } else {
                if (result.length == 0 || result[result.length - 1] != nums2[p2]) {
                    result[counter++] = nums2[p2];
                }
                p2++;
            }
        }

        while (p1 < n) {
            if (result.length == 0 || result[result.length - 1] != nums1[p1]) {
                result[counter++] = nums1[p1];
            }
            p1++;
        }

        while (p2 < m) {
            if (result.length == 0 || result[result.length - 1] != nums2[p2]) {
                result[counter++] = nums2[p2];
            }
            p2++;
        }
        return result;
    }
}
/*
    Given two sorted arrays nums1 and nums2, return an array that contains the union of these two arrays. The elements
    in the union must be in ascending order.
    The union of two arrays is an array where all values are distinct and are present in either the first array, the
    second array, or both.

    Input: nums1 = [1, 2, 3, 4, 5], nums2 = [1, 2, 7]
    Output: [1, 2, 3, 4, 5, 7]
    Explanation: The elements 1, 2 are common to both, 3, 4, 5 are from nums1 and 7 is from nums2
 */