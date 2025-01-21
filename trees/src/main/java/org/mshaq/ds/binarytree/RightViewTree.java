package com.ms.data.structures.trees.binarytree;

import java.util.*;

public class RightViewTree {


    public static void rightViewOpt(TreeNode root, List<Integer> res, int level) {
        if (root == null) {
            return;
        }

        if (res.size() == level) {
            res.add(root.val);
        }
        rightViewOpt(root.right, res, level + 1);
        rightViewOpt(root.left, res, level + 1);
    }

    public static List<Integer> rightViewOther(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode top = q.poll();

                if (size == 0) {
                    res.add(top.val);
                }

                if (top.left != null) {
                    q.offer(top.left);
                }
                if (top.right != null) {
                    q.offer(top.right);
                }
            }
        }
        return res;
    }

    public static List<Integer> rightView(TreeNode root) {
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
            int level = top.level;
            if (!map.containsKey(level)) {
                map.put(level, node.val);
            }

            if (top.treeNode.right != null) {
                q.add(new Node(top.treeNode.right, level + 1));
            }

            if (top.treeNode.left != null) {
                q.add(new Node(top.treeNode.left, level + 1));
            }
        }

        for (int k : map.keySet()) {
            res.add(map.get(k));
        }

        return res;
    }

    static class Node {
        TreeNode treeNode;
        int level;

        public Node(TreeNode treeNode, int level) {
            this.treeNode = treeNode;
            this.level = level;
        }
    }
}

