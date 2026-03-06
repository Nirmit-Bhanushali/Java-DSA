// 1.3 Write a program to evaluate a postfix expression.
package Unit1;
import java.util.Scanner;

class PostfixEvaluation {
    int SIZE = 20;
    int[] stack = new int[SIZE];
    int top = -1;

    void push(int value) {
        stack[++top] = value;
    }

    int pop() {
        return stack[top--];
    }

    int evaluate(String postfix) {
        for (int i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);

            if (Character.isDigit(ch)) {
                push(ch - '0'); // convert char to int
            } 
            else {
                int b = pop();
                int a = pop();
                int result = 0;

                switch (ch) {
                    case '+':
                        result = a + b;
                        break;
                    case '-':
                        result = a - b;
                        break;
                    case '*':
                        result = a * b;
                        break;
                    case '/':
                        result = a / b;
                        break;
                }

                push(result);
            }
        }
        return pop();
    }
}

public class PostfixExpr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PostfixEvaluation obj = new PostfixEvaluation();

        System.out.print("Enter postfix expression: ");
        String postfix = sc.next();

        int result = obj.evaluate(postfix);

        System.out.println("Result = " + result);
        sc.close();
    }
}