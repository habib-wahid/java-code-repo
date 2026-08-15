package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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

    static int diameter = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

         level(root, 0);
         return diameter;
    }

    public static int level(TreeNode root, int currentLevel) {
        if (root == null)
            return currentLevel - 1;

        System.out.println("current level " + currentLevel + " " + root.val);
        int l = level(root.left, currentLevel + 1);
        int r = level(root.right, currentLevel + 1);

        int currentNodeDiameter = l - currentLevel + r - currentLevel;
        System.out.println("l " + l + " r " + r + " current " + currentLevel + " diameter " + currentNodeDiameter + "");
        diameter = Math.max(diameter, currentNodeDiameter);
        return Math.max(l, r);
    }

    public static void main(String[] args) {

        int a = 9;
        int b = 20;

        System.out.println((double) (a + b)/3);



        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);

        root.right.val = root.right.val + 1;

//        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(4);
//        root.right.left.left = new TreeNode(5);
       // System.out.println(diameterOfBinaryTree(root));

        List<Integer> list = new ArrayList<>();

        Math.abs(2-5);
        Queue<Integer> q = new LinkedList<>();
        q.offer(2);
        q.offer(1);
        q.offer(3);
        q.offer(null);

        int size = q.size();


       // System.out.println(q.poll());

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(null);

        System.out.println(stack.pop());
       // System.out.println(q.poll());
      //  System.out.println(deque.pollFirst());
       /// System.out.println(deque.size());

    }
}
