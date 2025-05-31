package leetcode;

public class MinimumDifferenceBST {

    public static TreeNode prev;
    public static Integer min = Integer.MAX_VALUE;

    public static int solution(TreeNode root) {
        inOrder(root);
        return min;
    }

    public static void inOrder(TreeNode root) {
        if (root == null)
            return;

        inOrder(root.left);

        if (prev != null) {
            min = Math.min(min, Math.abs(root.val - prev.val));
        }

        prev = root;

        inOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(solution(root));
    }
}
