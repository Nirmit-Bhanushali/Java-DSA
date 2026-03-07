// 5.1 a) Write a program to create a minimum spanning tree using Kruskal's algorithm.
package Unit5;

import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    Edge(int s, int d, int w) {
        src = s;
        dest = d;
        weight = w;
    }

    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }
}

class MinSpanningTreeKruskal {

    int find(int parent[], int i) {
        if (parent[i] != i)
            parent[i] = find(parent, parent[i]);
        return parent[i];
    }

    void union(int parent[], int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

    void kruskal(int V, List<Edge> edges) {
        Collections.sort(edges);

        int parent[] = new int[V];
        for (int i = 0; i < V; i++)
            parent[i] = i;

        System.out.println("Edges in MST:");

        int count = 0;
        for (Edge e : edges) {
            int x = find(parent, e.src);
            int y = find(parent, e.dest);

            if (x != y) {
                System.out.println(e.src + " - " + e.dest + " : " + e.weight);
                union(parent, x, y);
                count++;

                if (count == V - 1)
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter edges: ");
        int E = sc.nextInt();

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            System.out.print("Enter src dest weight: ");
            edges.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        MinSpanningTreeKruskal obj = new MinSpanningTreeKruskal();
        obj.kruskal(V, edges);
        sc.close();
    }
}