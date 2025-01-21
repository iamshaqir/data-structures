package com.ms.data.structures.trees.binarytree;

public class CompareTwoTrees {

    public static boolean compare(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        boolean left = compare(p.left, q.left);
        boolean right = compare(p.right, q.right);
        return left && right;
    }
}
