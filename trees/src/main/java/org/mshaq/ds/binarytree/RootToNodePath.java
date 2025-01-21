package org.mshaq.ds.binarytree;

import org.mshaq.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePath {

    public static List<Integer> rootToNodePath(TreeNode root, int val) {
        List<Integer> path = new ArrayList<>();
        rootToNodePathHelper(root, val, path);
        return path;
    }

    private static boolean rootToNodePathHelper(TreeNode root, int val, List<Integer> path) {
        if (root == null) {
            return false;
        }
        path.add(root.val);

        if (root.val == val) {
            return true;
        }
        boolean left = rootToNodePathHelper(root.left, val, path);
        boolean right = rootToNodePathHelper(root.right, val, path);

        if (left || right) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    public static int isSumProperty(TreeNode root) {
        if (root == null) return 1;
        if (root.left == null && root.right == null) return 1;
        int sum = 0;
        if (root.left != null) sum += root.left.val;
        if (root.right != null) sum += root.right.val;
        if (root.val == sum) return (isSumProperty(root.left) & isSumProperty(root.right));
        return 0;
    }
}
