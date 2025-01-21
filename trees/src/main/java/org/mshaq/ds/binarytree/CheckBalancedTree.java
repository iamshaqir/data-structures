package com.ms.data.structures.trees.binarytree;

/**
 * <a href="https://leetcode.com/problems/balanced-binary-tree/description/">Balanced Binary Tree</a>
 */
public class CheckBalancedTree {

    public boolean isBalancedOpt(TreeNode root) {
        return isBalancedHelper(root) != -1;
    }

    public static int isBalancedHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = isBalancedHelper(root.left);
        if (left == -1) return left;
        int right = isBalancedHelper(root.right);
        if (right == -1) return right;
        if (Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }

    public static boolean checkBalancedBrute(TreeNode root) {

        if (root == null) {
            return true;
        }

        int leftHeight = getLeftHeight(root.left);
        int rightHeight = getLeftHeight(root.right);
        int result = Math.abs(leftHeight - rightHeight);
        if (result > 1) {
            return false;
        }
        boolean left = checkBalancedBrute(root.left);
        boolean right = checkBalancedBrute(root.right);
        return left || right;
    }

    private static int getLeftHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getLeftHeight(root.left);
        int rightHeight = getLeftHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
