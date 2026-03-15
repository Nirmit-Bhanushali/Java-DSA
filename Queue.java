

public class Queue {
    int SIZE = 5;
    int[] queue = new int[SIZE];
    int front = -1, rear = -1;

    void enqueue(int value) {
        // Check overflow
        if ((rear + 1) % SIZE == front) {
            System.out.println("Queue Overflow");
            return;
        }

        // First insertion
        if (front == -1) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % SIZE;
        }

        queue[rear] = value;
        System.out.println("Inserted " + value);
    }

    void dequeue() {
        // Check underflow
        if (front == -1) {
            System.out.println("Queue Underflow");
            return;
        }

        System.out.println("Deleted " + queue[front]);

        // Only one element
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
        while (i != rear) {
            System.out.print(queue[i] + " ");
            i = (i + 1) % SIZE;
        }
        System.out.println(queue[rear]);
    }
}