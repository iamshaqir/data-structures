package com.ms.data.playground.revision.binarytree;

import com.ms.data.structures.trees.binarytree.TreeNode;

public class HeightOfTree {

    public static int height(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return 1 + Math.max(left, right);
    }
}
