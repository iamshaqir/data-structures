package org.mshaq.ds.leetcode.easy;

import com.ms.data.structures.trees.binarytree.TreeNode;

/**
 * Given two binary trees original and cloned and given a reference to a node target in the original tree.
 * The cloned tree is a copy of the original tree.
 * 
 * Return a reference to the same node in the cloned tree.
 * Note that you are not allowed to change any of the two trees or the target node and the answer must be a reference to a node in the cloned tree.
 * 
 * https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/description/
 * 
 */
public class GetTargetCopy {
	
	
	public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == null || cloned == null) {
            return null;
        }
        if(original.val == cloned.val && original.equals(target)) {
            return cloned;
        }
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        if(left != null) {
            return left;
        }

        return getTargetCopy(original.right, cloned.right, target);
        
    }
	
	private TreeNode ans = null;
    public final TreeNode getTargetCopyV2(final TreeNode original, final TreeNode cloned, final TreeNode target) {
       dfs(original,cloned,target);
       return ans; 
    }
    private void dfs(TreeNode original, TreeNode cloned, TreeNode target){
        if(ans != null)
            return;
        if(original == null)
            return;
        if(original == target){
            ans = cloned;
            return;
        }
        dfs(original.left,cloned.left,target);
        dfs(original.right,cloned.right,target);
    }
}
