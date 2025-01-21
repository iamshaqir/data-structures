package org.mshaq.ds.bst;


import org.mshaq.ds.TreeNode;

import java.util.Stack;

public class KthSpecificElement {

    public static void kthSmallestElementRec(TreeNode root, int k, int[] counter, int[] result) {
        if (root == null) {
            return;
        }
        kthSmallestElementRec(root.left, k, counter, result);
        counter[0]++;
        if (counter[0] == k) {
            result[0] = root.val;
            return;
        }
        kthSmallestElementRec(root.right, k, counter, result);
    }

    public static int kthSmallestElementIte(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        int counter = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            counter += 1;
            if (counter == k) {
                return curr.val;
            }
            curr = curr.right;
        }
        return -1;
    }

    public static int kthSmallestElementMorris(TreeNode root, int k) {

        int counter = 0;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                counter += 1;
                if (counter == k) {
                    return curr.val;
                }
                curr = curr.right;
            } else {

                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    counter += 1;
                    if (counter == k) {
                        return curr.val;
                    }
                    curr = curr.right;
                }
            }
        }
        return counter;
    }
}
