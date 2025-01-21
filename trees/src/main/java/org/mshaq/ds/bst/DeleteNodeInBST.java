
package org.mshaq.ds.bst;


import org.mshaq.ds.TreeNode;

/**
 * <a href="https://leetcode.com/problems/delete-node-in-a-bst/description/">450. Delete Node in a BST</a>
 */
public class DeleteNodeInBST {


    /**
     * 1. Move left if val is smaller than root val
     * 2. Move right if val is greater than root val
     * 3. If not, we found the Node which is equal
     * - If root's left is null return root's right
     * - If root's right is null return root's left
     * - Find the minimum for key in right as that's where we can find it, on its left will be less than minimum
     * so, we cannot make it as roots value
     * - Replace root's val with minimum node's val
     * - Delete the minimum node
     */
    public TreeNode deleteNodeRec(TreeNode root, int key) {

        if (root == null) {
            return root;
        }

        if (root.val > key) {
            root.left = deleteNodeRec(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNodeRec(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            TreeNode minimumNode = getMinimum(root.right);
            root.val = minimumNode.val;
            // Delete minimum node
            root.right = deleteNodeRec(root.right, minimumNode.val);
        }
        return root;
    }

    // Minimum will be only on right
    private TreeNode getMinimum(TreeNode root) {
        if (root.left == null) {
            return root;
        }
        return getMinimum(root.left);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (root.val == key) {
            return remove(root);
        }
        TreeNode curr = root;
        while (curr != null) {
            if (curr.val > key) {
                if (curr.left != null && curr.left.val == key) {
                    curr.left = remove(curr.left);
                    break;
                } else {
                    curr = curr.left;
                }
            } else {
                if (curr.right != null && curr.right.val == key) {
                    curr.right = remove(curr.right);
                    break;
                } else {
                    curr = curr.right;
                }
            }
        }
        return root;
    }

    private TreeNode remove(TreeNode root) {
        if (root.left == null) {
            return root.right;
        }

        if (root.right == null) {
            return root.left;
        }

        TreeNode right = root.right;
        TreeNode lastRight = findLastRight(root.left);
        lastRight.right = right;
        return root.left;
    }

    private TreeNode findLastRight(TreeNode root) {
        if (root.right == null) {
            return root;
        }
        return findLastRight(root.right);
    }
}
