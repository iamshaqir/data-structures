package com.ms.data.playground.revision.binarytree;

import com.ms.data.structures.trees.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryTraversal {

    public List<Integer> boundary(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (!isLeafNode(root)) {
            res.add(root.val);
        }
        // make sure not to add leaf nodes
        addLeftNodes(root, res);
        addLeafNodes(root, res);
        addRightNodesReverse(root, res);
        return res;
    }


    private boolean isLeafNode(TreeNode root) {
        return root.left == null && root.right == null;
    }


    private void addLeftNodes(TreeNode root, List<Integer> res) {
        TreeNode curr = root.left;
        while (curr != null) {
            if (!isLeafNode(curr)) {
                res.add(curr.val);
            }
            if (root.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    private void addLeafNodes(TreeNode root, List<Integer> res) {
        if (isLeafNode(root)) {
            res.add(root.val);
        }

        if (root.left != null) {
            addLeftNodes(root.left, res);
        }

        if (root.right != null) {
            addLeftNodes(root.right, res);
        }
    }

    private void addRightNodesReverse(TreeNode root, List<Integer> res) {
        TreeNode curr = root.right;
        Stack<Integer> stack = new Stack<>();
        while (curr != null) {
            if (!isLeafNode(curr)) {
                stack.push(curr.val);
            }
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
    }
}
