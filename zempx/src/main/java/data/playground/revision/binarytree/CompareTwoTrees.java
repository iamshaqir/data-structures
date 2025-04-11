package data.playground.revision.binarytree;


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
