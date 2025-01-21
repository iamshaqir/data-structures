package org.mshaq.ds.leetcode.easy;


import com.ms.data.structures.trees.binarytree.TreeNode;

/**
 * <a href="https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/">108. Convert Sorted Array to Binary Search Tree</a>
 */
public class SortedArrayToBST {

    public static TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private static TreeNode helper(int[] A, int si, int ei) {
        if (si > ei) {
            return null;
        }
        int middle = (ei + si) / 2;
        TreeNode root = new TreeNode(A[middle]);
        root.left = helper(A, si, middle - 1);
        root.right = helper(A, middle + 1, ei);
        return root;
    }
}
