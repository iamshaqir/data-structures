package org.mshaq.ds.bst;

import org.mshaq.ds.TreeNode;

import java.util.Stack;

/**
 * <aset href="https://leetcode.com/problems/validate-binary-search-tree/description/">98. Validate Binary Search Tree</aset>
 */
public class ValidBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode current = root;
        TreeNode previous = null;
        while (current != null || !s.isEmpty()) {
            while (current != null) {
                s.push(current);
                current = current.left;
            }
            current = s.pop();
            if (previous != null && previous.val >= current.val) {
                return false;
            }
            previous = current;
            current = current.right;
        }
        return true;
    }

    public boolean isValidBSTHelper(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isValidBSTHelper(root.left, min, root.val) &&
                isValidBSTHelper(root.right, root.val, max);
    }
}
