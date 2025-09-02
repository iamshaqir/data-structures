package arrays;

public class A04_RemoveDuplicatesSortedArray {

    public int removeDuplicates(int[] nums) {
        int idx = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[idx] != nums[i]) {
                idx++;
                nums[idx] = nums[i];
            }
        }
        return idx;
    }
}
/*
    Given an integer array nums sorted in non-decreasing order, remove all duplicates in-place so that each unique
    element appears only once. Return the number of unique elements in the array.

    Input: nums = [0, 0, 3, 3, 5, 6]
    Output: 4
    Explanation: Resulting array = [0, 3, 5, 6, _, _]
    There are 4 distinct elements in nums and the elements marked as _ can have any value.
 */
