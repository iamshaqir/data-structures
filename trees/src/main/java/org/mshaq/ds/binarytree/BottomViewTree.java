package com.ms.data.structures.trees.binarytree;

import java.util.*;

public class BottomViewTree {

    public static List<Integer> topView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(root, 0));
        while (!q.isEmpty()) {
            Node top = q.poll();
            TreeNode treeNode = top.treeNode;
            int vertex = top.vertex;
            map.put(vertex, treeNode.val);
            if (top.treeNode.left != null) {
                q.add(new Node(top.treeNode.left, vertex - 1));
            }

            if (top.treeNode.right != null) {
                q.add(new Node(top.treeNode.right, vertex + 1));
            }
        }
        return res;
    }

    static class Node {
        TreeNode treeNode;
        int vertex;

        public Node(TreeNode treeNode, int vertex) {
            this.treeNode = treeNode;
            this.vertex = vertex;
        }
    }
}
