// 1.2 Write a program to implement a Stack, show overflow and underflow while performing push and pop operations respectively.
package Unit1;
import java.util.Scanner;

class StackClass {
    int SIZE = 5;
    int[] stack = new int[SIZE];
    int top = -1;

    void push(int value) {
        if (top == SIZE - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        stack[++top] = value;
        System.out.println("Pushed: " + value);
    }

    void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return;
        }
        System.out.println("Popped: " + stack[top--]);
    }

    void display() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return;
        }

        System.out.print("Stack elements: ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
}

public class Stack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackClass s = new StackClass();
        int choice, value;

        do {
            System.out.println("\n1.Push\n2.Pop\n3.Display\n4.Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    value = sc.nextInt();
                    s.push(value);
                    break;

                case 2:
                    s.pop();
                    break;

                case 3:
                    s.display();
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