package com.ms.data.structures.trees.binarytree;


/**
 * <a href="https://leetcode.com/problems/binary-tree-maximum-path-sum/description/">124. Binary Tree Maximum Path Sum</a>
 */
public class MaximumPathSum {

    public static int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        return maxPathSumHelper(root, max);
    }

    private static int maxPathSumHelper(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, maxPathSumHelper(root.left, max));
        int right = Math.max(0, maxPathSumHelper(root.right, max));
        int currMax = root.val + left + right;
        max[0] = Math.max(max[0], currMax);
        return root.val + Math.max(left, right);
}
}
