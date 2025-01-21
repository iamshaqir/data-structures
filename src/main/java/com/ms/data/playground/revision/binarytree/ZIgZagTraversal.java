package com.ms.data.playground.revision.binarytree;

import com.ms.data.structures.trees.binarytree.TreeNode;

import java.util.*;

public class ZIgZagTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        boolean leftToRight = true;
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            Integer[] subList = new Integer[size];
            for (int i = 0; i < size; i++) {
                TreeNode top = q.poll();
                int index = leftToRight ? i : (size - 1 - i);
                subList[index] = top.val;
                if (top.left != null) {
                    q.add(top.left);
                }
                if (top.right != null) {
                    q.add(top.right);
                }
            }
            leftToRight = !leftToRight;
            res.add(Arrays.asList(subList));
        }
        return res;
    }
}
