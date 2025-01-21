package com.ms.data.structures.trees.binarytree;

import java.util.*;

public class NodesAtDistanceK {


    public static List<Integer> nodesAtDistanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentLinkMap = new HashMap<>();
        linkChildWithParent(root, parentLinkMap);
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        visited.add(target);
        int count = 0;
        while (!q.isEmpty()) {
            if (count == k) break;
            count++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode top = q.poll();
                //LEFT
                if (top.left != null && !visited.contains(top.left)) {
                    q.add(top.left);
                    visited.add(top.left);
                }
                //RIGHT
                if (top.right != null && !visited.contains(top.right)) {
                    q.add(top.right);
                    visited.add(top.right);
                }
                //UP/PARENT
                TreeNode parent = parentLinkMap.get(top);
                if (parent != null && !visited.contains(parent)) {
                    q.add(parent);
                    visited.add(parent);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            res.add(q.poll().val);
        }

        return res;

    }

    private static void linkChildWithParent(TreeNode root, Map<TreeNode, TreeNode> parentLinkMap) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode top = q.poll();
            if (top.left != null) {
                parentLinkMap.put(top.left, top);
                q.add(top.left);
            }

            if (top.right != null) {
                parentLinkMap.put(top.right, top);
                q.add(top.right);
            }
        }
    }

    // USING DFS
    private void set_Parent_by_dfs(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parentLinkMap) {
        if (node != null) {
            parentLinkMap.put(node, parent);
            set_Parent_by_dfs(node.left, node, parentLinkMap);
            set_Parent_by_dfs(node.right, node, parentLinkMap);
        }
    }
}
