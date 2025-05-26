package leetcode;

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
