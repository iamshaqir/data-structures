package org.mshaq.ds.bst;

import com.ms.data.structures.trees.binarytree.TreeNode;

public class LowestCommonAncestor {

	public static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
		int min= Math.min(p.val, q.val);
		int max= Math.max(p.val, q.val);
		TreeNode current = root;
		while(current != null) {
			
			// Now that all node nodes smaller than root will be on left
			// I have MAX and MIN of two node
			
			// if current.val > max it means both the nodes are on left as I am comparing with max, 
			// roots left will have all smaller nodes now that MAX is there MIN will also be there

			// While comparing on roots right, it will have all larger nodes
			// we have to use MIN i.e., if current.val < MIN, MAX will also be there as MIN is the least on right 
			if(current.val > max) {
				current = current.left; 
            } else if(current.val < min)  {
            	current = current.right;
            } else {
                return current;
            }
		}
		return null;
	}
}
