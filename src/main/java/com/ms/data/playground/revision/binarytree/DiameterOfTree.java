package com.ms.data.playground.revision.binarytree;

import com.ms.data.structures.trees.binarytree.TreeNode;

public class DiameterOfTree {


    public int diameterV2(TreeNode root) {
        int[] diameter = new int[1];
        getDiameterV2(root, diameter);
        return diameter[0];
    }

    private int getDiameterV2(TreeNode root, int[] diameter) {
        if (root == null) {
            return 0;
        }

        int left = getDiameterV2(root.left, diameter);
        int right = getDiameterV2(root.right, diameter);
        diameter[0] = Math.max(diameter[0], left + right);
        return Math.max(left, right) + 1;
    }

    public int diameter(TreeNode root) {
        Node node = getDiameter(root);
        return node.diameter;
    }

    private Node getDiameter(TreeNode root) {
        if (root == null) {
            return new Node(0, 0);
        }
        Node left = getDiameter(root.left);
        Node right = getDiameter(root.right);
        int currentDiameter = left.height + right.height;
        int diameter = Math.max(currentDiameter, Math.max(left.diameter, right.diameter));
        int height = Math.max(left.height, right.height) + 1;
        return new Node(height, diameter);
    }

    static class Node {
        int height;
        int diameter;

        public Node(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }
}
