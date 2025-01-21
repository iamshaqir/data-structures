package com.ms.data.playground.revision.binarytree;

import com.ms.data.structures.trees.binarytree.TreeNode;

public class CompareTwoTrees {
	
	public boolean compare(TreeNode a, TreeNode b) {
		if(a == null || b ==null) {
			return (a == b);
		}
		if(a.val != b.val) {
			return false;
		}
		
		return compare(a.left, b.left) && 
				compare(a.right, b.right);
	}
}
