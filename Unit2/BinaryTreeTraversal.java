// 2.4 Write a program to implement a binary tree and display the contents using preorder, postorder, and in-order traversal techniques.
package Unit2;
import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    // Insert node in binary tree
    Node insert(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.data)
            root.left = insert(root.left, value);
        else
            root.right = insert(root.right, value);

        return root;
    }

    // Inorder Traversal (Left → Root → Right)
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    // Preorder Traversal (Root → Left → Right)
    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Postorder Traversal (Left → Right → Root)
    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }
}

public class BinaryTreeTraversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();

        int n, value;

        System.out.print("Enter number of nodes: ");
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter value: ");
            value = sc.nextInt();
            tree.root = tree.insert(tree.root, value);
        }

        System.out.println("\nInorder Traversal:");
        tree.inorder(tree.root);

        System.out.println("\nPreorder Traversal:");
        tree.preorder(tree.root);

        System.out.println("\nPostorder Traversal:");
        tree.postorder(tree.root);

        sc.close();
    }
}