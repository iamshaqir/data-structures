package com.ms.data.structures.trees.binarytree;


public class CountNodesOpt {

    public static int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getLeftHeight(root.left);
        int right = getRightHeight(root.right);
        if (left == right) {
            return (1 << left) - 1;
        }
        return count(root.left) + count(root.right) + 1;
    }

    private static int getRightHeight(TreeNode root) {
        int count = 0;
        while (root != null) {
            count += 1;
            root = root.left;
        }
        return count;
    }

    private static int getLeftHeight(TreeNode root) {
        int count = 0;
        while (root != null) {
            count += 1;
            root = root.left;
        }
        return count;
    }
}
