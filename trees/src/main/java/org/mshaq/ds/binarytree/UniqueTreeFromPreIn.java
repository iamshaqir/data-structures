package org.mshaq.ds.binarytree;

import org.mshaq.ds.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class UniqueTreeFromPreIn {

    public static TreeNode uniqueTreeFromPreIn(int[] pre, int[] in) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return buildTreePreIn(pre, 0, pre.length - 1, in, 0, in.length - 1, map);
    }

    private static TreeNode buildTreePreIn(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        int currentRootIndexInOrder = map.get(pre[preStart]);
        int numsLeft = currentRootIndexInOrder - inStart;
        root.left = buildTreePreIn(pre, preStart + 1, numsLeft + preStart, in, inStart, currentRootIndexInOrder - 1, map);
        root.right = buildTreePreIn(pre, preStart + numsLeft + 1, preEnd, in, currentRootIndexInOrder + 1, inEnd, map);
        return root;
    }
}
