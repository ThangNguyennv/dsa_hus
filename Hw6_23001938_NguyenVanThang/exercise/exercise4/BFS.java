package Hw6_23001938_NguyenVanThang.exercise.exercise4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int s, int t) {
        adj.get(s).add(t);
        adj.get(t).add(s);
    }

    public static void bfs(ArrayList<ArrayList<Integer>> adj, int u) {
        Queue<Integer> queue = new LinkedList<>();
        int n = adj.size();
        boolean[] visited = new boolean[n];
        queue.add(u);
        visited[u] = true;
        while (!queue.isEmpty()) {
            int x = queue.peek();
            queue.remove();
            System.out.print(x + " ");
            for (int neighbor : adj.get(x)) {
               if (!visited[neighbor]) {
                   queue.add(neighbor);
                   visited[neighbor] = true;
               }
           }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(5);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 3},
                {1, 4},
                {2, 4}
        };
        for (int[] e : edges) {
            addEdge(adj, e[0], e[1]);
        }
        int source = 0;
        System.out.println("BFS from source: " + source);
        bfs(adj, source);
    }
}
