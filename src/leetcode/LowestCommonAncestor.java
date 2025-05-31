package leetcode;

import java.util.*;

public class LowestCommonAncestor {

    public static TreeNode solution(TreeNode root, TreeNode p, TreeNode q) {
        Set<TreeNode> p_set = new LinkedHashSet<>();
        inOrderTraversal(root, p, p_set);
        Set<TreeNode> q_set = new LinkedHashSet<>();
        inOrderTraversal(root, q, q_set);

        TreeNode result = null;

        for (TreeNode pt : p_set) {
            if (q_set.contains(pt)) {
                result = pt;
                return result;
            }
        }

        return result;
    }

    public static boolean inOrderTraversal(TreeNode root, TreeNode sub, Set<TreeNode> set) {
        if (root == null) {
            return false;
        }

        if (root.val == sub.val) {
            set.add(root);
            return true;
        }

        boolean left = inOrderTraversal(root.left, sub, set);
        boolean right = inOrderTraversal(root.right, sub, set);

        if (left || right) {
            set.add(root);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);

        TreeNode sub = new TreeNode(4);

        solution(root, sub, null);

    }
}
