package com.ms.data.structures.trees.binarytree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/description/">104. Maximum Depth of Binary Tree</a>
 */
public class HeightOfTree {


    // DFS - Recursive
    public static int getHeightDFSRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHeightDFSRec(root.left);
        int right = getHeightDFSRec(root.right);
        return 1 + Math.max(left, right);
    }

    // DFS - Iterative
    public static int getHeightDFSIte(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = 0;
        Deque<TreeHeight> stack = new LinkedList<>();
        stack.push(new TreeHeight(root, 1));
        while (!stack.isEmpty()) {
            int currDepth = stack.peek().depth;
            TreeNode curr = stack.pop().treeNode;
            maxDepth = Math.max(maxDepth, currDepth);
            if (curr.left != null) {
                stack.push(new TreeHeight(curr.left, currDepth + 1));
            }

            if (curr.right != null) {
                stack.push(new TreeHeight(curr.right, currDepth + 1));
            }
        }
        return maxDepth;
    }

    static class TreeHeight {
        TreeNode treeNode;
        int depth;

        public TreeHeight(TreeNode treeNode, int depth) {
            this.treeNode = treeNode;
            this.depth = depth;
        }
    }

    public static int getHeightBFS(TreeNode root) {
        int maxDepth = 0;
        Queue<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                TreeNode top = stack.poll();
                if (top.left != null) {
                    stack.add(top.left);
                }

                if (top.right != null) {
                    stack.add(top.right);
                }
            }
            maxDepth++;
        }
        return maxDepth;
    }
}
