package org.mshaq.ds.binarytree;

import org.mshaq.ds.TreeNode;

import java.util.Stack;

public class FlattenTreeToLinkedList {


    static TreeNode prev = null;

    public static void flatten(TreeNode root) {

        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public static void flattenStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();

            if (top.right != null) {
                stack.push(top.right);
            }
            if (top.left != null) {
                stack.push(top.left);
            }
            if (!stack.isEmpty()) {
                top.right = stack.peek();
            }
            top.left = null;
        }
    }

    public static void flattenMorris(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode curr = root;
        while (curr != null) {

            if (curr.left != null) {
                TreeNode prev = curr.left;
                while (prev.right != null) {
                    prev = prev.right;
                }

                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}
