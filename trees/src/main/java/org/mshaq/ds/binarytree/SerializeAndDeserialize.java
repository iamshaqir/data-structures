package org.mshaq.ds.binarytree;

import org.mshaq.ds.TreeNode;

import java.util.*;

public class SerializeAndDeserialize {

    private static final String SPLIT_EXP = ",";
    private static final String EXPRESSION = "#";

    public static String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode top = q.poll();
            if (top == null) {
                sb.append(EXPRESSION).append(SPLIT_EXP);
                continue;
            }
            sb.append(top.val).append(SPLIT_EXP);
            q.add(top.left);
            q.add(top.right);

        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    public static TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] A = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        int index = 0;
        TreeNode root = new TreeNode(Integer.parseInt(A[0]));
        q.add(root);
        for (int i = 1; i < A.length; i++) {
            TreeNode top = q.poll();
            if (!A[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(A[i]));
                top.left = left;
                q.add(left);
            }
            i++;
            if (!A[i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(A[i]));
                top.right = right;
                q.add(right);
            }
        }
        return root;
    }

    public static String serializeOth(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    public static TreeNode deSerializeOth(String data) {
        if (data.isEmpty()) {
            return null;
        }
        Deque<String> nodes = new ArrayDeque<>(Arrays.asList(data.split(SPLIT_EXP)));
        return DeserializeHelper(nodes);
    }

    private static TreeNode DeserializeHelper(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(EXPRESSION)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = DeserializeHelper(nodes);
        node.right = DeserializeHelper(nodes);
        return node;
    }

    private static void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(EXPRESSION).append(SPLIT_EXP);
            return;
        }
        sb.append(root.val).append(SPLIT_EXP);
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }
}
