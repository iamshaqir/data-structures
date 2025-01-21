package org.mshaq.ds.bst;

import com.ms.data.structures.trees.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InOrderSuccPred {

    int predecessor = -1;
    int successor = Integer.MAX_VALUE;

    public List<Integer> succPredBSTOptimal(TreeNode root, int key) {
        return null;
    }

    public void traverse(TreeNode root) {

    }

    public List<Integer> succPredBSTBetter(TreeNode root, int key) {

        if (root == null) {
            return null;
        }
        TreeNode current = root;
        TreeNode succ = null;
        TreeNode pred = null;
        // if we CURR VAL == KEY get MAX from LEFT(predecessor) and MIN from RIGHT(successor)
        while (current != null) {
            if (current.val == key) {
                if (current.left != null) {
                    pred = findMax(current.left);
                }
                if (current.right != null) {
                    succ = findMin(current.right);
                }
                break;
            }

            if (current.val > key) {
                succ = current;
                current = current.left;
            } else {
                pred = current;
                current = current.right;
            }
        }
        List<Integer> answer = new ArrayList<>();
        int predecessor = (pred != null) ? pred.val : -1;
        int successor = (succ != null) ? succ.val : -1;
        answer.add(predecessor);
        answer.add(successor);
        return answer;
    }

    // Helper function to find the minimum value node in a subtree
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // Helper function to find the maximum value node in a subtree
    private TreeNode findMax(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public TreeNode inOrderSucc(TreeNode root, int key) {
        TreeNode ans = null;
        TreeNode current = root;

        // If  CURR VAL > KEY, it's a possible answer(next successor), others answers may exist(if key is too small)
        // on LEFT but cannot on RIGHT because they will be greater than the answer I found. I just need one greater answer
        // If not just search on RIGHT subtree

        if (current.val > key) {
            ans = current;
            current = current.left;
        } else {
            current = current.right;
        }
        return ans;
    }

    public TreeNode inOrderPred(TreeNode root, int key) {
        TreeNode ans = null;
        TreeNode current = root;

        // Predecessor, smaller than KEY
        // If  CURR VAL < KEY, it's a possible answer(Predecessor), others answers may exist(if key is too small)
        // on RIGHT but cannot on LEFT because they will be smaller than the answer I found. I just need one small answer
        // which I already found if other exist they will be on right
        // If not just search on RIGHT subtree

        if (current.val < key) {
            ans = current;
            current = current.right;
        } else {
            current = current.left;
        }

        return ans;
    }
}
