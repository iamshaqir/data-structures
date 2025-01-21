package com.ms.data.structures.trees.binarytree;

public class ChildrenSumProperty {

    public static void childrenSumProperty(TreeNode root) {
        if (root == null) {
            return;
        }
        int childSum = 0;
        if (root.left != null) childSum += root.left.val;
        if (root.right != null) childSum += root.right.val;

        if (childSum >= root.val) {
            root.val = childSum;
        } else {
            if (root.left != null) root.left.val = root.val;
            if (root.right != null) root.right.val = root.val;
        }

        childrenSumProperty(root.left);
        childrenSumProperty(root.right);

        int rootSum = 0;
        if (root.left != null) rootSum += root.left.val;
        if (root.right != null) rootSum += root.right.val;
        if (root.left != null || root.right != null) root.val = rootSum;
    }
}
