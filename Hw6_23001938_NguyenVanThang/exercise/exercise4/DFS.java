package Hw6_23001938_NguyenVanThang.exercise.exercise4;

import java.util.ArrayList;

public class DFS {
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int s, int t) {
        adj.get(s).add(t);
        adj.get(t).add(s);
    }

    public static void dfsRec(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int s) {
        visited[s] = true;
        System.out.print(s + " ");
        for (int neighbor : adj.get(s)) {
            if (!visited[neighbor]) {
                dfsRec(adj, visited, neighbor);
            }
        }
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj, int s) {
        boolean[] visited = new boolean[adj.size()];
        dfsRec(adj, visited, s);
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(5);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        int[][] edges = {
                {1, 2},
                {1, 0},
                {2, 0},
                {2, 3},
                {2, 4}
        };
        for (int[] e : edges) {
            addEdge(adj, e[0], e[1]);
        }

        int source = 1;
        System.out.println("DFS from source: " + source);
        dfs(adj, source);
    }
}
