package data.playground.revision.binarytree;


public class CheckBalancedTree {

    public boolean isBalanced(TreeNode root) {
        return isBalancedHelper(root) != -1;
    }

    private int isBalancedHelper(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int left = isBalancedHelper(root.left);
        if (left == -1) {
            return left;
        }

        int right = isBalancedHelper(root.right);
        if (right == -1) {
            return right;
        }

        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
