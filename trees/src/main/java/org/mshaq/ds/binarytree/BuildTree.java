package com.ms.data.structures.trees.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BuildTree {

    public static int idx = 0;

    public static TreeNode buildTreePre(int[] A) {
        int element = A[idx++];
        if (element == -1) {
            return null;
        }
        TreeNode root = new TreeNode(element);
        root.left = buildTreePre(A);
        root.right = buildTreePre(A);
        return root;
    }

    public static TreeNode buildTreeLevel(int[] A) {
        int i = 0;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(A[i++]);
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode current = q.poll();
//            if (A.length == i) break;
            int leftNodeVal = A[i++];
            if (leftNodeVal != -1) {
                TreeNode leftTreeNode = new TreeNode(leftNodeVal);
                q.offer(leftTreeNode);
                current.left = leftTreeNode;
            }

            int rightNodeVal = A[i++];
            if (rightNodeVal != -1) {
                TreeNode rightTreeNode = new TreeNode(rightNodeVal);
                q.offer(rightTreeNode);
                current.right = rightTreeNode;
            }
        }
        return root;
    }

    public static void printLevelLn(TreeNode root) {
        if (root == null) {
            System.out.println("No tree present!!");
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        while (!q.isEmpty()) {
            TreeNode current = q.poll();
            if (current == null) {
                if (q.isEmpty()) {
                    break;
                }
                q.offer(null);
                System.out.println();
            } else {
                print(current.val);
                TreeNode left = current.left;
                if (left != null) {
                    q.offer(left);
                }

                TreeNode right = current.right;
                if (right != null) {
                    q.offer(right);
                }
            }
        }
        System.out.println();
        System.out.println("~~~~~~~~~~~~~~");
    }

    public static void printLevel(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        print(root.val);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            TreeNode left = curr.left;
            if (left != null) {
                print(left.val);
                q.offer(left);
            }

            TreeNode right = curr.right;
            if (right != null) {
                print(right.val);
                q.offer(right);
            }
        }

    }

    private static void print(int val) {
        System.out.print(val + " ");
    }
}
