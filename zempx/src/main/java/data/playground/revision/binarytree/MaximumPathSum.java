package com.ms.data.playground.revision.binarytree;

import com.ms.data.structures.trees.binarytree.TreeNode;

public class MaximumPathSum {

    public int getMaxPathSum(TreeNode root) {
        int[] sum = new int[1];
        getMaxPathSumHelper(root, sum);
        return sum[0];
    }

    private int getMaxPathSumHelper(TreeNode root, int[] sum) {
        if (root == null) {
            return 0;
        }

        int leftSum = Math.max(0, getMaxPathSumHelper(root.left, sum));
        int rightSum = Math.max(0, getMaxPathSumHelper(root.right, sum));
        sum[0] = Math.max(sum[0], leftSum + rightSum + root.val);
        return Math.max(leftSum, rightSum) + root.val;
    }
}
