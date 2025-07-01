package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree {

    public Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            inorderMap.put(inorder[i], i);
        }

        return tree(preorder, 0, 0, n -1);
    }

    public TreeNode tree(int[] preorder, int preStart,  int inStart, int inEnd) {

        if (inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int valIndex = inorderMap.get(preorder[preStart]);
        int size = valIndex - inStart;

        root.left = tree(preorder, preStart + 1, inStart, valIndex - 1);
        root.right = tree(preorder, preStart + size + 1, valIndex + 1, inEnd);

        return root;
    }
    public static void main(String[] args) {

    }
}
