package org.mshaq.ds.binarytree;

import org.mshaq.ds.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class UniqueTreeFromPostIn {

    public static TreeNode uniqueTreeFromPostIn(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreePostIn(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private static TreeNode buildTreePostIn(int[] postorder, int postStart, int postEnd, int[] inOrder, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int currentRootIndexIn = map.get(root.val);
        int inOrderLeftElementsCnt = currentRootIndexIn - inStart;
        root.left = buildTreePostIn(postorder, postStart, postStart + inOrderLeftElementsCnt - 1,
                inOrder, inStart, currentRootIndexIn - 1,
                map);
        root.right = buildTreePostIn(postorder, postStart + inOrderLeftElementsCnt, postEnd - 1,
                inOrder, currentRootIndexIn + 1, inEnd,
                map);
        return root;
    }
}
