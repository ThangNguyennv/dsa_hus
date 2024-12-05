package Hw6_23001938_NguyenVanThang.practice.exercise5;

import java.util.ArrayList;

public class UndirectedGraph {
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[adj.size() + 1];
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                if (dfs(i, adj, -1, visited)) return true;
            }
        }
        return false;
    }

    public static boolean dfs(int v, ArrayList<ArrayList<Integer>> adj, int parent, boolean[] visited) {
        visited[v] = true;
        for (Integer neb : adj.get(v)) {
            if (!visited[neb]) {
                if (dfs(neb, adj, v, visited)) return true;
            } else if (neb != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int vertices = 4; // Số đỉnh

        // Khởi tạo danh sách kề
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }

        // Thêm các cạnh vào đồ thị
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 0);

       if (isCycle(adj)) {
           System.out.println("It has a cycle");
       } else {
           System.out.println("It hasn't a cycle");
       }
    }
}
