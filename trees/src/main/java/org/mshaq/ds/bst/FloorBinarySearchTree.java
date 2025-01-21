package org.mshaq.ds.bst;


import org.mshaq.ds.TreeNode;

public class FloorBinarySearchTree {

    public static int findFloor(TreeNode root, int key) {

        // Floor less than or equal to KEY
        // if CURR VAL  <= KEY, it could be a possible answer, I may find answer in RIGHT(may be greater than this)
        // but not on left because everything will be smaller than curr and I already found one small
        int res = -1;
        TreeNode current = root;
        while (current != null) {
            if (current.val <= key) {
                res = current.val;
                current = current.right;
            } else {
                current = current.left;
            }

        }
        return res;
    }
}
