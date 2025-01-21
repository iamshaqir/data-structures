package org.mshaq.ds.bst;

import com.ms.data.structures.stacks.Stack;
import com.ms.data.structures.trees.binarytree.TreeNode;

public class TwoSumBST {


    public static boolean twoSumOther(TreeNode root, int k) {

        TreeNode start = root;
        TreeNode end = root;

        while (start != null) {
            start = start.left;
        }
        while (end != null) {
            end = end.right;
        }

        while (start != end) {
            int sum = start.val + end.val;
            if (sum == k) {
                return true;
            }

            if (sum < start.val) {
                start = getSuccessor(root, start);
            } else {
                end = getPredecessor(root, end);
            }
        }
        return false;
    }

    private static TreeNode getPredecessor(TreeNode root, TreeNode k) {
        TreeNode current = root;
        TreeNode predecessor = null;
        while (current != null) {

            if (current.val < k.val) {
                predecessor = current;
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return predecessor;
    }

    private static TreeNode getSuccessor(TreeNode root, TreeNode k) {
        TreeNode current = root;
        TreeNode successor = null;
        while (current != null) {

            if (current.val > k.val) {
                successor = current;
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return successor;
    }

    public static boolean twoSum(TreeNode root, int k) {

        //  Create ASC & DESC order list using BST Iterator
        BSTIterator l = new BSTIterator(root, true);
        BSTIterator r = new BSTIterator(root, false);

        // Get FIRST and LAST, notice here int end = r.next() acts as previous, we passed flag as false
        int start = l.next();
        int end = r.next(); // Acts as previous

        // While START < END, find for TARGET == K ===> TRUE,
        // if SUM < START get NEXT, i.e., i++ or start++
        // else get PREV, by get next you'll get prev, remember flag as false(INORDER in desc, RIGHT ROOT LEFT) i.e., j-- or end--
        while (start < end) {
            int sum = start + end;
            if (sum == k) {
                return true;
            }

            if (sum < start) {
                start = l.next();
            } else {
                end = r.next();
            }
        }
        return false;
    }

    public static class BSTIterator {

        private Stack<TreeNode> stack;

        private boolean isNext;

        public BSTIterator(TreeNode root, boolean isNext) {
            this.stack = new Stack<>();
            this.isNext = isNext;
            pushAll(root);
        }

        public int next() {
            TreeNode top = stack.pop();
            if (isNext) {
                pushAll(top.right);
            } else {
                pushAll(top.left);
            }
            return top.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        private void pushAll(TreeNode root) {
            TreeNode current = root;
            while (current != null) {
                stack.push(current);
                if (isNext) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
        }
    }
}


