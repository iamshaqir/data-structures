package org.mshaq.ds.leetcode.medium;

import com.ms.data.structures.stacks.Stack;
import com.ms.data.structures.trees.binarytree.TreeNode;

public class BSTGreaterSumTree {


    private int sum = 0;

    public TreeNode bstToGstV2(TreeNode root) {
        reverseInOrderTraversal(root);
        return root;
    }

    private void reverseInOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        reverseInOrderTraversal(node.right);
        sum += node.val;
        node.val = sum;
        reverseInOrderTraversal(node.left);
    }

    public TreeNode bstToGst(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        int sum = 0;
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.right;
            }

            current = stack.pop();
            sum += current.val;
            current.val = sum;
            current = current.left;
        }

        return root;
    }
}
