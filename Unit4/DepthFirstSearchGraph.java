// 4.1 Write a program to implement Depth First Search using linked representation of graph.
package Unit4;

import java.util.LinkedList;
import java.util.Scanner;

class Graph {
    int vertices;
    LinkedList<Integer>[] adjList;

    @SuppressWarnings("unchecked")
    Graph(int v) {
        vertices = v;
        adjList = new LinkedList[v];

        for (int i = 0; i < v; i++)
            adjList[i] = new LinkedList<>();
    }

    void addEdge(int src, int dest) {
        adjList[src].add(dest);
    }

    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int n : adjList[v]) {
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    void DFS(int start) {
        boolean visited[] = new boolean[vertices];
        DFSUtil(start, visited);
    }
}

public class DepthFirstSearchGraph {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int v = sc.nextInt();

        Graph g = new Graph(v);

        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        for (int i = 0; i < e; i++) {
            System.out.print("Enter source and destination: ");
            int src = sc.nextInt();
            int dest = sc.nextInt();
            g.addEdge(src, dest);
        }

        System.out.print("Enter starting vertex: ");
        int start = sc.nextInt();

        System.out.println("DFS Traversal:");
        g.DFS(start);

        sc.close();
    }
}