

public class Main {
    public static void main(String[] args) {
        CQ cq = new CQ();

        // Enqueue elements
        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);
        cq.enqueue(50); // Queue becomes full here
        cq.enqueue(60); // This should show Queue Overflow

        // Display queue
        cq.display();

        // Dequeue elements
        cq.dequeue();
        cq.dequeue();

        // Display queue after deletions
        cq.display();

        // Enqueue again to test circular nature
        cq.enqueue(60);
        cq.enqueue(70);

        // Final display
        cq.display();

        // Remove all elements
        cq.dequeue();
        cq.dequeue();
        cq.dequeue();
        cq.dequeue();
        cq.dequeue(); // This should show Queue Underflow
    }
}