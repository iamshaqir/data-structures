package org.mshaq.ds.bst;

import com.ms.data.structures.trees.binarytree.TreeNode;

public class RecoverBST {

    private TreeNode first = null, last = null, previous = null;

    /**
     * - There are two cases here,
     * 1. Recovery Nodes may be ADJACENT from each other
     * 2. Recovery Nodes may be APART from each other
     * - Do an INORDER traversal and keep track of PREVIOUS as ROOT, meanwhile check for BST condition
     * - if PREV.VAl > ROOT.VAL it means it does not satisfy BST condition
     * - Check if FIRST is null, if so, make FIRST as PREV
     * - LAST as ROOT(To keep track of LAST)
     * NOTE: Keep updating PREVIOUS node.
     * - After the iteration you will have your RECOVERY NODES to swa
     */
    public TreeNode recoverTree(TreeNode root) {
        traverseInorder(root);
        swap(first, last);
        return root;
    }

    private void swap(TreeNode A, TreeNode B) {
        int temp = A.val;
        A.val = B.val;
        B.val = temp;
    }

    private void traverseInorder(TreeNode root) {
        if (root == null) {
            return;
        }
        traverseInorder(root.left);
        if (previous != null && previous.val > root.val) {
            if (first == null) {
                first = previous;
            }
            last = root;
        }
        previous = root;
        traverseInorder(root.right);
    }
}
