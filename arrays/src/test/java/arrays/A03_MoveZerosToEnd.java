package arrays;

public class A03_MoveZerosToEnd {
    public void moveZeroes(int[] nums) {
        int idxPlaceholder = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, idxPlaceholder);
                idxPlaceholder++;
            }
        }
    }

    private void swap(int[] A, int si, int ei) {
        int temp = A[si];
        A[si] = A[ei];
        A[ei] = temp;
    }
}
/*
    Given an integer array nums, move all the 0's to the end of the array. The relative order of the other elements
    must remain the same. This must be done in place, without making a copy of the array.

    Input: nums = [0, 1, 4, 0, 5, 2]
    Output: [1, 4, 5, 2, 0, 0]

    Explanation: Both the zeroes are moved to the end and the order of the other elements stay the same
 */
