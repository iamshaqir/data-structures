package com.ms.data.structures.trees.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MirrorTree {

    public static boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> q = new LinkedList();
        q.add(root.left);
        q.add(root.right);
        while (!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if (left == null && right == null)
                continue;
            if (left == null || right == null || left.val != right.val)
                return false;
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);

        }
        return true;
    }

    public static boolean isSymmetricRec(TreeNode root) {
        return root == null || isSymmetricHelper(root.left, root.right);
    }

    private static boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return (left == right);
        }
        if (left.val != right.val) {
            return false;
        }
        boolean leftFlag = isSymmetricHelper(left.left, right.right);
        boolean rightFlag = isSymmetricHelper(left.right, right.left);
        return leftFlag && rightFlag;
    }
}
