package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {

    public List<Integer> solution(TreeNode root) {

        int[] min = new int[] {Integer.MAX_VALUE};
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();

        List<TreeNode> current_level = new ArrayList<>();
        List<TreeNode> next_level = new ArrayList<>();

        current_level.add(root);

        while (!current_level.isEmpty()) {

            result.add(current_level.getFirst().val);

            for (int i = 0; i <= current_level.size() - 1; i++) {
                TreeNode node = current_level.get(i);
                if (node.right != null) {
                    next_level.add(node.right);
                }

                if (node.left != null) {
                    next_level.add(node.left);
                }
            }

            current_level = next_level;
            next_level = new ArrayList<>();
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
