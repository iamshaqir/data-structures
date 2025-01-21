package com.ms.data.structures.trees.binarytree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumWidth {

    public static int getWidthDFS(TreeNode root) {
        List<Integer> leftMostIndexes = new ArrayList<>();
        int[] res = new int[1];
        getWidthDFSHelper(root, 1, 0, leftMostIndexes, res);
        return res[0];
    }

    private static void getWidthDFSHelper(TreeNode root, int level, int currentNodeIndex, List<Integer> leftMostIndexes, int[] res) {
        if (root == null) {
            return;
        }
        if (level > leftMostIndexes.size()) {
            leftMostIndexes.add(currentNodeIndex);
        }
        int currWidth = currentNodeIndex - leftMostIndexes.get(level - 1) + 1;
        res[0] = Math.max(res[0], currWidth);
        getWidthDFSHelper(root.left, level + 1, 2 * currentNodeIndex + 1, leftMostIndexes, res);
        getWidthDFSHelper(root.right, level + 1, 2 * currentNodeIndex + 2, leftMostIndexes, res);
    }

    public static int getWidth(TreeNode root) {
        int res = Integer.MIN_VALUE;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            int min = q.peek().index; // To avoid stack overflow when Tree is huge while multiplying with root nodes index
            int start = 0, end = 0;
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                int index = node.index;
                int nodeIndex = index - min;
                TreeNode treeNode = node.treeNode;
                if (i == 0) {
                    start = nodeIndex;
                }

                if (i == size - 1) {
                    end = nodeIndex;
                }
                if (treeNode.left != null) {
                    q.add(new Node(treeNode.left, (2 * nodeIndex) + 1));
                }

                if (treeNode.right != null) {
                    q.add(new Node(treeNode.right, (2 * nodeIndex) + 2));
                }
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }

    static class Node {
        TreeNode treeNode;
        int index;

        public Node(TreeNode treeNode, int index) {
            this.treeNode = treeNode;
            this.index = index;
        }
    }
}
