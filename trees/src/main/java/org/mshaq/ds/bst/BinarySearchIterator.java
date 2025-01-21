package org.mshaq.ds.bst;


import org.mshaq.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class BinarySearchIterator {

    // PUSH all the elements on LEFT to STACK, as question is for INORDER
    // when asked for NEXT, POP stack's TOP and add make sure to ADD RIGHT'S LEFT elements
    // RETURN TOP element
    // If stack is not EMPTY, it hasnext()
    private Stack<TreeNode> stack = new Stack<>();

    public BinarySearchIterator(TreeNode root) {
        pushAll(root);
    }

    public int next() {
        TreeNode top = stack.pop();
        pushAll(top.right);
        return top.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAll(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
    }

    public static class BinarySearchIteratorOther {

        private static int pointer;
        private List<Integer> list = null;

        public BinarySearchIteratorOther(TreeNode root) {
            pointer = 0;
            list = new ArrayList<>();
            addInorder(root);
        }

        public int next() {
            return list.get(pointer++);
        }

        public boolean hasNext() {
            return pointer < list.size();
        }

        private void addInorder(TreeNode root) {
            if (root == null) {
                return;
            }
            addInorder(root.left);
            list.add(root.val);
            addInorder(root.right);
        }
    }
}

