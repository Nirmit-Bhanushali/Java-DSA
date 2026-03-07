// 5.2 Write a program to sort a given set of elements using Selection sort and hence find the time required to sort elements. Repeat the experiment for different values of n, the number of elements in the list to be sorted, and plot a graph of the time taken versus n.
package Unit5;

import java.util.Scanner;

public class SelectionSort {

    void selectionSort(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements (n): ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        SelectionSort obj = new SelectionSort();

        long startTime = System.nanoTime();

        obj.selectionSort(arr, n);

        long endTime = System.nanoTime();

        long timeTaken = endTime - startTime;

        System.out.println("Sorted elements:");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        System.out.println("\nTime taken (nanoseconds): " + timeTaken);

        sc.close();
    }
}