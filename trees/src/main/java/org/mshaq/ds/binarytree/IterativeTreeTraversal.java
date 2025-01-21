package com.ms.data.structures.trees.binarytree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class IterativeTreeTraversal {

    public static void preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            System.out.print(curr.val + " ");
            TreeNode right = curr.right;
            if (right != null) {
                stack.push(right);
            }
            TreeNode left = curr.left;
            if (left != null) {
                stack.push(left);
            }

        }
        System.out.println();
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            if (treeNode != null) {
                result.add(treeNode.val);
                stack.push(treeNode.right);
                stack.push(treeNode.left);
            }
        }
        return result;
    }

    public static void inOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (true) {

            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                temp = stack.pop();
                System.out.print(temp.val + " ");
                temp = temp.right;
            }
        }
        System.out.println();
    }

    public static List<Integer> inOrderOther(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new LinkedList<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }
}
