package com.ms.data.structures.trees.binarytree;

import java.util.*;

public class TopViewTree {

    public static List<Integer> topViewOther(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(root, 0));
        int min = 0;
        int max = 0;
        while (!q.isEmpty()) {
            Node top = q.poll();
            TreeNode node = top.treeNode;
            int vertex = top.vertex;
            if (!map.containsKey(vertex)) {
                map.put(vertex, node.val);
            }
            if (top.treeNode.left != null) {
                q.add(new Node(top.treeNode.left, vertex - 1));
                min = Math.min(min, vertex - 1);
            }

            if (top.treeNode.right != null) {
                q.add(new Node(top.treeNode.right, vertex + 1));
                max = Math.max(max, vertex + 1);
            }
        }

        for (int k : map.keySet()) {
            res.add(map.get(k));
        }

        return res;
    }

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
            TreeNode node = top.treeNode;
            int vertex = top.vertex;
            if (!map.containsKey(vertex)) {
                map.put(vertex, node.val);
            }
            if (node.left != null) {
                q.add(new Node(node.left, vertex - 1));
            }

            if (node.right != null) {
                q.add(new Node(node.right, vertex + 1));
            }
        }

        res.addAll(map.values());

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
