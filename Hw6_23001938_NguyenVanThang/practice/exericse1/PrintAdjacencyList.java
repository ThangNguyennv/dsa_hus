package Hw6_23001938_NguyenVanThang.practice.exericse1;

import java.util.ArrayList;
import java.util.List;

public class PrintAdjacencyList {
    public static List<List<Integer>> printGraph(int V, int edges[][]) {  // Đồ thị vô hướng
        List<List<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return adj;
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices
        int[][] edges = {
                {0, 1},
                {0, 4},
                {1, 2},
                {1, 3},
                {1, 4},
                {2, 3},
                {3, 4}
        };

        List<List<Integer>> adjacencyList = printGraph(V, edges);
        for (int i = 0; i < adjacencyList.size(); i++) {
            System.out.print("Vertex: " + i + " is connected to: ");
            for (int neighbor : adjacencyList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}
