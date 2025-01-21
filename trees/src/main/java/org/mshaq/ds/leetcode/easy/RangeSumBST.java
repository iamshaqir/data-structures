package org.mshaq.ds.leetcode.easy;

import com.ms.data.structures.trees.binarytree.TreeNode;

/*
 * Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].
 * 
 * https://leetcode.com/problems/range-sum-of-bst/description/
 * 
 */
public class RangeSumBST {

	/*
	 * If it BST you should definitely compare the left and right node.
	 * In this case if Low and High range exits on only one side of tree, there is no means of going to other side
	 * so make sure to validate the BST condition
	 */
	public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) {
			return 0;
		}
        int sum = 0;
		if(root.val >= low && root.val <= high) {
			sum = sum + root.val;
		}
        if(root.val > low) {
            sum = sum + rangeSumBST(root.left, low, high);
        }
		
		if(root.val < high) {
            sum = sum + rangeSumBST(root.right, low, high);;
        }
        return sum;
    }
}
