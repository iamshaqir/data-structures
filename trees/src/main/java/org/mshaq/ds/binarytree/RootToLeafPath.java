package org.mshaq.ds.binarytree;

import org.mshaq.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPath {

    public static List<List<Integer>> rootToLeafPath(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        rootToLeafHelper(root, path, res);
        return res;
    }

    private static void rootToLeafHelper(TreeNode root, List<Integer> path, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        } else {
            rootToLeafHelper(root.left, path, res);
            rootToLeafHelper(root.right, path, res);
        }

        path.remove(path.size() - 1);
    }
}
