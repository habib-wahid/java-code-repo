package leetcode;

public class SumRootToLeaf {

    int sum = 0;
    public int sol(TreeNode root) {
        calculateSum(root, 0, 10);
        return sum;
    }

    public void calculateSum(TreeNode root, int prevRoot, int factor) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            sum += root.val + prevRoot * factor;
            return;
        }

        prevRoot = root.val + prevRoot * factor;

        calculateSum(root.left, prevRoot, factor );
        calculateSum(root.right, prevRoot, factor );
    }



    public static void main(String[] args) {
        SumRootToLeaf solution = new SumRootToLeaf();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);
        System.out.println(solution.sol(root));
    }
}

//       3
//   1         5
//0     2    4     6