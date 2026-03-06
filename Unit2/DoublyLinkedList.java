package Unit2;

import java.util.Scanner;

class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        prev = next = null;
    }
}

class DoublyLinkedListClass {
    Node head = null;

    // Creation (Insert at end)
    void create(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
    }

    // Display
    void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        System.out.print("List: ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Insertion at beginning
    void insert(int value) {
        Node newNode = new Node(value);

        if (head != null) {
            head.prev = newNode;
            newNode.next = head;
        }

        head = newNode;
    }

    // Deletion
    void delete(int key) {
        Node temp = head;

        while (temp != null && temp.data != key) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Element not found");
            return;
        }

        if (temp.prev != null)
            temp.prev.next = temp.next;
        else
            head = temp.next;

        if (temp.next != null)
            temp.next.prev = temp.prev;
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

public class DoublyLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoublyLinkedListClass list = new DoublyLinkedListClass();
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