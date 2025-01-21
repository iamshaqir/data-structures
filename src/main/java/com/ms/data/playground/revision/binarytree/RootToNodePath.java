package com.ms.data.playground.revision.binarytree;

import com.ms.data.structures.trees.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePath {

    public List<Integer> path(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        helper(root, k, result);
        return result;
    }

    private boolean helper(TreeNode root, int k, List<Integer> result) {
        if (root == null) {
            return false;
        }

        result.add(root.val);
        if (root.val == k) {
            return true;
        }
        boolean left = helper(root.left, k, result);
        boolean right = helper(root.right, k, result);
        if (left || right) {
            return true;
        }
        result.remove(result.size() - 1);
        return false;
    }
}
