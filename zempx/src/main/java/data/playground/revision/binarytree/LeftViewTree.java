package data.playground.revision.binarytree;

import java.util.ArrayList;
import java.util.List;

public class LeftViewTree {

    public List<Integer> left(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        leftHelper(root, 0, result);
        return result;
    }

    private void leftHelper(TreeNode root, int level, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (result.size() == level) {
            result.add(root.val);
        }
        leftHelper(root.left, level + 1, result);
        leftHelper(root.right, level + 1, result);
    }
}
