package com.ms.data.structures.trees.binarytree;

/**
 * <a href="https://leetcode.com/problems/diameter-of-binary-tree/description/">Diameter of Binary Tree</a>
 */
public class DiameterOfTree {
    public static int diameter(TreeNode root) {
        int[] max = new int[1];
        diameterHelper(root, max);
        return max[0];

    }

    public static int diameterHelper(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = diameterHelper(root.left, max);
        int right = diameterHelper(root.right, max);
        max[0] = Math.max(max[0], left + right);
        return Math.max(left, right) + 1;
    }

    public static int diameterOther(TreeNode root) {
        Diameter diameter = diameterOtherHelper(root);
        return diameter.diameter;
    }

    private static Diameter diameterOtherHelper(TreeNode root) {
        if (root == null) {
            Diameter diameter = new Diameter(0, 0);
            return diameter;
        }

        Diameter left = diameterOtherHelper(root.left);
        Diameter right = diameterOtherHelper(root.right);
        int rootDiameter = left.height + right.height;
        int maxDiameter = Math.max(rootDiameter, Math.max(left.diameter, right.diameter));
        int height = Math.max(left.height, right.height) + 1;
        Diameter diameter = new Diameter(height, maxDiameter);
        return diameter;
    }

    static class Diameter {
        int height;
        int diameter;

        public Diameter(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }
}
