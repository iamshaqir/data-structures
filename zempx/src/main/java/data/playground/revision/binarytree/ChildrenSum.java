package data.playground.revision.binarytree;


public class ChildrenSum {

    public int childrenSum(TreeNode root) {
        return helper(root) ? 1 : 0;
    }

    private boolean helper(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        int sum = 0;
        if (root.left != null) {
            sum += root.left.val;
        }

        if (root.right != null) {
            sum += root.right.val;
        }

        if (sum != root.val) {
            return false;
        }

        return helper(root.left) &&
                helper(root.right);
    }
}
