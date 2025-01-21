package org.mshaq.ds.leetcode.medium;

import com.ms.data.structures.trees.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseOddLevelsBT {


    // TC: O(n) -> Every node in the binary tree is visited
    // SC: O(h) -> where h is the height of the binary tree
    public TreeNode reverseOddLevelsDFS(TreeNode root) {
        if (root == null) {
            return null;
        }
        // Using DFS, Iterate Each tree Recursively and Independently using two arguments,
        // but make sure to swap first with last and respectively

        helper(root.left, root.right, true);
        return root;

    }

    private void helper(TreeNode left, TreeNode right, boolean isOddLevel) {
        if (left == null || right == null) {
            return;
        }
        if (isOddLevel) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }
        helper(left.left, right.right, !isOddLevel);
        helper(left.right, right.left, !isOddLevel);
    }

    public TreeNode reverseOddLevelsBFS(TreeNode root) {
        boolean isOddLevel = false;
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> nodeValues = new ArrayList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int qSize = q.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < qSize; i++) {
                TreeNode top = q.poll();
                if (isOddLevel) {
                    top.val = nodeValues.get(qSize - i - 1);
                }

                TreeNode left = top.left;
                if (left != null) {
                    temp.add(left.val);
                    q.add(left);
                }

                TreeNode right = top.right;
                if (right != null) {
                    temp.add(right.val);
                    q.add(right);
                }
            }
            isOddLevel = !isOddLevel;
            nodeValues = temp;
        }
        return root;
    }
}
