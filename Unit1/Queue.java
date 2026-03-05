package Unit1;

import java.util.Scanner;

class QueueClass {
    int SIZE = 5;
    int[] queue = new int[SIZE];
    int front = -1, rear = -1;

    void enqueue(int value) {
        if (rear == SIZE - 1) {
            System.out.println("Queue Overflow");
            return;
        }

        if (front == -1)
            front = 0;

        queue[++rear] = value;
        System.out.println("Inserted: " + value);
    }

    void dequeue() {
        if (front == -1 || front > rear) {
            System.out.println("Queue Underflow");
            return;
        }

        System.out.println("Deleted: " + queue[front]);
        front++;
    }

    void display() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue elements: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
}

public class Queue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueClass q = new QueueClass();
        int choice, value;

        do {
            System.out.println("\n1.Insert (Enqueue)");
            System.out.println("2.Delete (Dequeue)");
            System.out.println("3.Display");
            System.out.println("4.Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    value = sc.nextInt();
                    q.enqueue(value);
                    break;

                case 2:
                    q.dequeue();
                    break;

                case 3:
                    q.display();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 4);

        sc.close();
    }
}
