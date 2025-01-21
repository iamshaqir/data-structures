package org.mshaq.ds.leetcode.easy;

import com.ms.data.structures.trees.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MergeBinaryTrees {


    public TreeNode mergeTreesDFS(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }

        if (root1 == null) {
            return root2;
        }

        if (root2 == null) {
            return root1;
        }
        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = mergeTreesDFS(root1.left, root2.left);
        root.right = mergeTreesDFS(root1.right, root2.right);
        return root;
    }

    public TreeNode mergeTreesBFS(TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 == null) return null;
        if (t1 == null || t2 == null) return t1 != null ? t1 : t2;

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(t1);
        q2.add(t2);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode c1 = q1.poll();
            TreeNode c2 = q2.poll();

            c1.val += c2.val;

            if (c1.left == null && c2.left != null) c1.left = c2.left;
            else if (c1.left != null && c2.left != null) {
                q1.add(c1.left);
                q2.add(c2.left);
            }

            if (c1.right == null && c2.right != null) c1.right = c2.right;
            else if (c1.right != null && c2.right != null) {
                q1.add(c1.right);
                q2.add(c2.right);
            }
        }
        return t1;
    }
}
