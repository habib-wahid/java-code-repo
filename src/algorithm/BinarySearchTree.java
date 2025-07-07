package algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Node {
    int data;
    Node left, right;
    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BinarySearchTree {

    public void traverse(Node root) {
        if (root == null) {
            return;
        }

        traverse(root.right);
        System.out.println(root.data);
        traverse(root.left);
    }
    public Node insertNode(Node root, int data) {
        if (root == null)
            return new Node(data);

        if (root.data > data) {
            root.left = insertNode(root.left, data);
        } else if (root.data < data) {
            root.right = insertNode(root.right, data);
        }
        return root;
    }

    public boolean search(Node root, int data) {
        if (root == null)
            return false;

        if (root.data == data) {
            return true;
        }

        if (root.data > data) {
            return search(root.left, data);
        }

        return search(root.right, data);
    }

    public Node deleteNode(Node root, int data) {
        if (root == null)
            return null;

        if (root.data > data) {
            root.left = deleteNode(root.left, data);
        }
        else if (root.data < data) {
            root.right = deleteNode(root.right, data);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                int minRightVal = minVal(root.right);
                root.data = minRightVal;
                root.right = deleteNode(root.right, root.data);
                return root;
            }
        }

        return root;
    }

    int minVal(Node root) {
        int minVal = root.data;

        while (root.left != null) {
            root = root.left;
            minVal = root.data;
        }

        return minVal;
    }
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(5);

        BinarySearchTree bst = new BinarySearchTree();
        root = bst.insertNode(root, 6);
        bst.traverse(root);
        System.out.println(bst.search(root, 6));
        bst.deleteNode(root, 6);
        bst.traverse(root);

        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);

        a.clear();

        a.addAll(List.of(5,6));
        a.add(3);
        System.out.println(a.get(0));

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.offer(1);;

    }
}
