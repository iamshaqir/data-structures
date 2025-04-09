package com.ms.data.playground.revision.binarytree;

import com.ms.data.structures.trees.binarytree.TreeNode;

import java.util.*;

public class TopView {

    public List<Integer> topView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, root));
        while (!q.isEmpty()) {
            Node top = q.poll();
            TreeNode treeNode = top.treeNode;
            int vertex = top.vertex;
            if (!map.containsKey(vertex)) {
                map.put(vertex, treeNode.val);
            }

            if (treeNode.left != null) {
                q.add(new Node(vertex - 1, treeNode.left));
            }

            if (treeNode.right != null) {
                q.add(new Node(vertex + 1, treeNode.left));
            }
        }
        result.addAll(map.values());
        return result;
    }

    static class Node {
        int vertex;

        TreeNode treeNode;

        public Node(int vertex, TreeNode treeNode) {
            this.vertex = vertex;
            this.treeNode = treeNode;
        }
    }
}
