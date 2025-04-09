package com.ms.data.playground.revision.binarytree;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.ms.data.structures.trees.binarytree.TreeNode;

public class NodeToLeafNodes {

	public static List<List<Integer>> getNodeToLeaf(TreeNode root, List<Integer> path, List<List<Integer>> result) {
		if(root == null) {
			return null;
		}
		path.add(root.val);
		if(root.left == null && root.right == null) {
			result.add(new ArrayList<>(path));
		} else {
			getNodeToLeaf(root.left, path, result);
			getNodeToLeaf(root.right, path, result);
		}
		path.remove(path.size() - 1);
		return result;
		
	}
}
