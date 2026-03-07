// 3.1 Write a program to construct a Binary Search tree and perform the following operations: Insertion and Deletion of anode
package Unit3;

import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

class BST {
    Node root;

    // Insertion
    Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }

        if (value < root.data)
            root.left = insert(root.left, value);
        else if (value > root.data)
            root.right = insert(root.right, value);

        return root;
    }

    // Find minimum value node
    Node minValue(Node root) {
        while (root.left != null)
            root = root.left;
        return root;
    }

    // Deletion
    Node delete(Node root, int key) {
        if (root == null)
            return root;

        if (key < root.data)
            root.left = delete(root.left, key);
        else if (key > root.data)
            root.right = delete(root.right, key);
        else {
            // Node with one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Node with two children
            Node temp = minValue(root.right);
            root.data = temp.data;
            root.right = delete(root.right, temp.data);
        }

        return root;
    }

    // Inorder Traversal
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
}

public class BinarySearchTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BST tree = new BST();

        int n, value;

        System.out.print("Enter number of nodes: ");
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter value: ");
            value = sc.nextInt();
            tree.root = tree.insert(tree.root, value);
        }

        System.out.print("\nInorder Traversal: ");
        tree.inorder(tree.root);

        System.out.print("\nEnter element to delete: ");
        value = sc.nextInt();
        tree.root = tree.delete(tree.root, value);

        System.out.print("Inorder after deletion: ");
        tree.inorder(tree.root);

        sc.close();
    }
}