package org.mshaq.ds.binarytree;

import org.mshaq.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MorrisInOrderTraversal {


    public static List<Integer> morris(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {
                res.add(current.val);
                current = current.right;
            } else {
                TreeNode prev = current.left;
                while (prev.right != null && prev.right != current) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = current;
                    current = current.left;
                } else {
                    prev.right = null;
                    res.add(current.val);
                    current = current.right;
                }
            }
        }
        return res;
    }
}
