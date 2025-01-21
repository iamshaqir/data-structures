package com.ms.data.structures.trees.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryTraversal {

    public static List<Integer> boundaryTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        if (!isLeafNode(root)) {
            res.add(root.val);
        }
        addLeftNodes(root, res);
        addLeafNodes(root, res);
        addRightNodesReverse(root, res);
        return res;
    }

    private static void addRightNodesReverse(TreeNode root, List<Integer> res) {
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

    private static void addLeafNodes(TreeNode root, List<Integer> res) {
        if (isLeafNode(root)) {
            res.add(root.val);
            return;
        }
        if (root.left != null) {
            addLeafNodes(root.left, res);
        }
        if (root.right != null) {
            addLeafNodes(root.right, res);
        }
    }


    private static void addLeftNodes(TreeNode root, List<Integer> res) {
        TreeNode curr = root.left;
        while (curr != null) {

            if (!isLeafNode(curr)) {
                res.add(curr.val);
            }

            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    private static boolean isLeafNode(TreeNode curr) {
        return curr.left == null && curr.right == null;
    }

}
