// 2.2 Write a program to implement Linear Linked List and show the following operations: creation, display, insertion, deletion and searching.
package Unit2;
import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head = null;

    // Creation (Insert at end)
    void create(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Display
    void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        System.out.print("Linked List: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Insertion at beginning
    void insert(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    // Deletion
    void delete(int key) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.data == key) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data != key) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Element not found");
        } else {
            temp.next = temp.next.next;
        }
    }

    // Searching
    void search(int key) {
        Node temp = head;
        int pos = 1;

        while (temp != null) {
            if (temp.data == key) {
                System.out.println("Element found at position " + pos);
                return;
            }
            temp = temp.next;
            pos++;
        }

        System.out.println("Element not found");
    }
}

public class LinearLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        int choice, value;

        do {
            System.out.println("\n1.Create");
            System.out.println("2.Display");
            System.out.println("3.Insert");
            System.out.println("4.Delete");
            System.out.println("5.Search");
            System.out.println("6.Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    value = sc.nextInt();
                    list.create(value);
                    break;

                case 2:
                    list.display();
                    break;

                case 3:
                    System.out.print("Enter value: ");
                    value = sc.nextInt();
                    list.insert(value);
                    break;

                case 4:
                    System.out.print("Enter element to delete: ");
                    value = sc.nextInt();
                    list.delete(value);
                    break;

                case 5:
                    System.out.print("Enter element to search: ");
                    value = sc.nextInt();
                    list.search(value);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 6);

        sc.close();
    }
}