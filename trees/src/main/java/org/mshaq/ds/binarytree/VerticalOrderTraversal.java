package org.mshaq.ds.binarytree;

import org.mshaq.ds.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class VerticalOrderTraversal {

    // If we are comparing only roots value
    public static List<List<Integer>> verticalUsingTreeMap(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Map<Integer, Map<Integer, Queue<Integer>>> map = new TreeMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(root, 0, 0));

        while (!q.isEmpty()) {
            Node top = q.poll();
            TreeNode treeNode = top.treeNode;
            int vertex = top.vertex;
            int level = top.level;
            map.putIfAbsent(vertex, new TreeMap<>());
            map.get(vertex).putIfAbsent(level, new PriorityQueue<>());
            map.get(vertex).get(level).add(treeNode.val);

            if (top.treeNode.left != null) {
                q.add(new Node(top.treeNode.left, vertex - 1, level + 1));
            }

            if (top.treeNode.right != null) {
                q.add(new Node(top.treeNode.right, vertex + 1, level + 1));
            }
        }

        for (Map<Integer, Queue<Integer>> nodes : map.values()) {
            List<Integer> list = new ArrayList<>();
            for (Queue<Integer> nodeQueue : nodes.values()) {
                while (!nodeQueue.isEmpty()) {
                    list.add(nodeQueue.poll());
                }
            }
            res.add(list);
        }
        return res;
    }

    // If we are comparing level(smaller level first) and roots value
    public static List<List<Integer>> vertical(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Map<Integer, List<Node>> map = new TreeMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(root, 0, 0));

        while (!q.isEmpty()) {
            Node top = q.poll();
            TreeNode treeNode = top.treeNode;
            int vertex = top.vertex;
            int level = top.level;
            map.putIfAbsent(vertex, new ArrayList<>());
            map.get(vertex).add(top);

            if (top.treeNode.left != null) {
                q.add(new Node(top.treeNode.left, vertex - 1, level + 1));
            }

            if (top.treeNode.right != null) {
                q.add(new Node(top.treeNode.right, vertex + 1, level + 1));
            }
        }
        for (int vertex : map.keySet()) {
            List<Node> list = map.get(vertex);
            list.sort(Comparator.comparing((Node n) -> n.level).thenComparing(n -> n.treeNode.val));
            List<Integer> finalList = list.stream()
                    .map(node -> node.treeNode.val)
                    .collect(Collectors.toList());
            res.add(finalList);
        }

        return res;
    }

    public static List<List<Integer>> verticalOther(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Map<Integer, List<Node>> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(root, 0, 0));

        int min = 0;
        int max = 0;
        while (!q.isEmpty()) {
            Node top = q.poll();
            TreeNode treeNode = top.treeNode;
            int vertex = top.vertex;
            int level = top.level;
            map.putIfAbsent(vertex, new ArrayList<>());
            map.get(vertex).add(top);

            if (top.treeNode.left != null) {
                q.add(new Node(top.treeNode.left, vertex - 1, level + 1));
                min = Math.min(min, vertex - 1);
            }

            if (top.treeNode.right != null) {
                q.add(new Node(top.treeNode.right, vertex + 1, level + 1));
                max = Math.max(max, vertex + 1);
            }
        }
        for (int i = min; i <= max; i++) {
            List<Node> list = map.get(i);
            list.sort(Comparator.comparing((Node n) -> n.level).thenComparing(n -> n.treeNode.val));
            List<Integer> finalList = list.stream()
                    .map(node -> node.treeNode.val)
                    .collect(Collectors.toList());
            res.add(finalList);
        }

        return res;
    }

    static class Node {
        TreeNode treeNode;
        int vertex;
        int level;

        public Node(TreeNode treeNode, int vertex, int level) {
            this.treeNode = treeNode;
            this.vertex = vertex;
            this.level = level;
        }
    }
}

