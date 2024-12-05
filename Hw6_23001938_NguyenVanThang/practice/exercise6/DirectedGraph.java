package Hw6_23001938_NguyenVanThang.practice.exercise6;

import java.util.ArrayList;

public class DirectedGraph {
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }
    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        int[] pathVisited = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (dfs(i, vis, pathVisited, adj) == true) return true;
            }
        }
        return false;
    }

    private static boolean dfs(int node, int[] vis, int[] pathVisited, ArrayList<ArrayList<Integer>> adj) {

        vis[node] = 1;
        pathVisited[node] = 1;

        for (int it : adj.get(node)) {
            if (vis[it] == 0) {
                if (dfs(it, vis, pathVisited, adj) == true) {
                    return true;
                }
            } else if (pathVisited[it] == 1) {
                return true;
            }
        }
        pathVisited[node] = 0;
        return false;
    }

    public static void main(String[] args) {
        int V = 5; // Số đỉnh

        // Tạo danh sách kề
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Thêm các cạnh vào đồ thị có hướng
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 1);
        addEdge(adj, 3, 4);

        DirectedGraph test = new DirectedGraph();

        // Kiểm tra chu trình
        if (test.isCyclic(V, adj)) {
            System.out.println("It has a cycle");
        } else {
            System.out.println("It hasn't a cycle.");
        }
    }
}
