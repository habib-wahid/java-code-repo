package leetcode;

import java.util.ArrayDeque;

public class SerializeDeserializeBinaryTree {

    public String serialize(TreeNode root) {
        if (root == null)
            return "";

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            if (node.val == Integer.MIN_VALUE) {
                sb.append("#,");
                continue;
            }

            sb.append(node.val).append(",");
            if (node.left != null) {
                queue.addLast(node.left);
            }

            if (node.left == null) {
                queue.addLast(new TreeNode(Integer.MIN_VALUE));
            }

            if (node.right != null) {
                queue.addLast(node.right);
            }



            if (node.right == null) {
                queue.addLast(new TreeNode(Integer.MIN_VALUE));
            }
        }

        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty())
            return null;

        String[] split = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        int i = 1;
        int len = split.length;

        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            if (i < len && !split[i].equals("#")) {
                node.left = new TreeNode(Integer.parseInt(split[i]));
                queue.addLast(node.left);
            }
            i++;

            if (i < len && !split[i].equals("#")) {
                node.right = new TreeNode(Integer.parseInt(split[i]));
                queue.addLast(node.right);
            }
            i++;
        }

        return root;
    }

    public String traverse(TreeNode root) {
        if (root == null)
            return "null";

        return root.val + "," + traverse(root.left) + "," + traverse(root.right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);

        SerializeDeserializeBinaryTree serializeDeserializeBinaryTree = new SerializeDeserializeBinaryTree();
        //System.out.println(solution.serialize(root));

        String[] s = serializeDeserializeBinaryTree.serialize(root).split(",");
        for (String str : s) {
            System.out.println(str);
        }
    }
}
