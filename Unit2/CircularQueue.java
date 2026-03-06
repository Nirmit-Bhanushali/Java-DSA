package Unit2;

import java.util.Scanner;

class CircularQueueClass {
    int SIZE = 5;
    int[] queue = new int[SIZE];
    int front = -1, rear = -1;

    void enqueue(int value) {
        if ((rear + 1) % SIZE == front) {
            System.out.println("Queue Overflow");
            return;
        }

        if (front == -1) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % SIZE;
        }

        queue[rear] = value;
        System.out.println("Inserted: " + value);
    }

    void dequeue() {
        if (front == -1) {
            System.out.println("Queue Underflow");
            return;
        }

        System.out.println("Deleted: " + queue[front]);

        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % SIZE;
        }
    }

    void display() {
        if (front == -1) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue elements: ");
        int i = front;

        while (true) {
            System.out.print(queue[i] + " ");
            if (i == rear)
                break;
            i = (i + 1) % SIZE;
        }

        System.out.println();
    }
}

public class CircularQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularQueueClass cq = new CircularQueueClass();
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
                    cq.enqueue(value);
                    break;

                case 2:
                    cq.dequeue();
                    break;

                case 3:
                    cq.display();
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