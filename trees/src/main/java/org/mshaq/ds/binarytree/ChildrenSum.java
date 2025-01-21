package com.ms.data.structures.trees.binarytree;


public class ChildrenSum {

    public static int isSumProperty(TreeNode root) {
        // add your code here
        return helper(root) ? 1 : 0;

    }

    private static boolean helper(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        int sum = 0;
        if (root.left != null) {
            sum += root.left.val;
        }

        if (root.right != null) {
            sum += root.right.val;
        }

        if (sum != root.val) {
            return false;
        }

        return helper(root.left) && helper(root.right);
    }
}
