package org.mshaq.ds.bst;


import org.mshaq.ds.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PreOrderToBST {

    static int indexPosition = 0;

    public static TreeNode buildOpt(int[] A) {

        // Following the approach used to Check if tree is BST
        // Here will be using only a single bound
        return buildOptHelper(A, Integer.MAX_VALUE);
    }

    private static TreeNode buildOptHelper(int[] A, int max) {
        if (indexPosition == A.length || A[indexPosition] > max) {
            return null;
        }
        TreeNode root = new TreeNode(A[indexPosition++]);
        root.left = buildOptHelper(A, root.val);
        root.right = buildOptHelper(A, max);
        return root;
    }

    public static TreeNode build(int[] A) {
        // Applying the approach of constructing BT using PRE and IN
        // Sorting BST will give us IN
        int[] preOrder = A.clone();
        Arrays.sort(A);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], i);
        }
        TreeNode root = buildHelper(preOrder, 0, A.length - 1, A, 0, A.length - 1, map);
        return root;
    }

    private static TreeNode buildHelper(int[] P, int preStart, int preEnd, int[] I, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode node = new TreeNode(P[preStart]);
        int inOrderPos = map.get(P[preStart]);
        int possibleLeftEle = inOrderPos - inStart;
        node.left = buildHelper(P, preStart + 1, possibleLeftEle + preStart, I, inStart, inOrderPos - 1, map);
        node.right = buildHelper(P, possibleLeftEle + preStart + 1, preEnd, I, inOrderPos + 1, inEnd, map);
        return node;
    }
}
