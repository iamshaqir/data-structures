package com.ms.data.structures.trees.binarytree;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/">103. Binary Tree Zigzag Level Order Traversal</a>
 */
public class ZigZagTree {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;
        while (!q.isEmpty()) {
            int size = q.size();
            Integer[] list = new Integer[size];
            for (int i = 0; i < size; i++) {
                TreeNode top = q.poll();
            /*
                if(leftToRight) {
                    list.add(top.val);
                } else {
                    list.addFirst(0, top.val);
                }
            */
                int index = leftToRight ? i : (size - 1 - i);
                list[index] = top.val;
                if (top.left != null) {
                    q.add(top.left);
                }
                if (top.right != null) {
                    q.add(top.right);
                }
            }
            result.add(Arrays.asList(list));
            leftToRight = !leftToRight;
        }
        return result;
    }
}
