package org.mshaq.ds.bst;

import com.ms.data.structures.trees.binarytree.TreeNode;

public class LargestBinaryTree {

    public int largestBst(TreeNode root) {
        Node result = largestBSTHelper(root);
        return result.size;
    }

    // see bst.md readme for intuition
    private Node largestBSTHelper(TreeNode root) {
        if (root == null) {
            return new Node(0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        Node left = largestBSTHelper(root.left);
        Node right = largestBSTHelper(root.right);

        if (root.val > left.max && root.val < right.min) {
            return new Node(left.size + right.size + 1, Math.max(root.val, right.max), Math.min(root.val, left.min));
        } else {
            return new Node(Math.max(left.size, right.size), Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
    }

    static class Node {

        int size;
        int max;

        int min;

        public Node(int size, int max, int min) {
            this.size = size;
            this.max = max;
            this.min = min;
        }
    }
}
