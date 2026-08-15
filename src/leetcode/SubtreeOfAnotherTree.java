package leetcode;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class SubtreeOfAnotherTree {

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null)
            return false;

        if (isSameTree(root,subRoot))
            return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null)
            return true;

        if ((root == null && subRoot != null) || (root != null && subRoot == null))
            return false;

        if (root.val != subRoot.val)
            return false;

        return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int pLen = preorder.length;
        int iLen = inorder.length;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < iLen; i++) {
            map.put(inorder[i], i);
        }

        return construct(preorder, 0, pLen - 1, inorder, 0, iLen - 1, map);

    }

    public TreeNode construct(int[] preorder, int pl, int pr, int[] inorder, int il, int ir, Map<Integer, Integer> map) {

        if (pl > pr || il > ir)
            return null;

        TreeNode root = new TreeNode(preorder[pl]);
        int pos = map.get(root.val);

        int leftNodes = pos - il;
        int rightNodes = ir - pos;

        root.left = construct(preorder, pl + 1, pl + leftNodes, inorder, il, pos - 1, map);
        root.right = construct(preorder, pl + leftNodes + 1, pr, inorder, pos + 1, ir, map);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(5);


        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(5);

        System.out.println(isSubtree(root, subRoot));

    }
}
