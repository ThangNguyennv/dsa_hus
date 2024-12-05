package Hw6_23001938_NguyenVanThang.exercise.exercise4;

import java.util.ArrayList;
import java.util.List;

public class EulerCycle {
    // Kiểm tra có chu trình euler không?
    public static boolean eulerCycle(int N, int M, ArrayList<ArrayList<Integer>> Edges) {
        // N : Số đỉnh
        // M : Số cạnh
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            int u = Edges.get(i).get(0) - 1;
            int v = Edges.get(i).get(1) - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for (int i = 0; i < N; i++) {
            if (adj.get(i).size() % 2 != 0) {
                return false;
            }
        }
        if (!isConnected(adj, N)) {
            return false;
        }
        return true;
    }

    public static boolean isConnected(ArrayList<ArrayList<Integer>> adj, int N) {
        boolean[] visited = new boolean[N];
        int startNode = -1;

        // Tìm một đỉnh bất kỳ có bậc lớn hơn 0 để bắt đầu
        for (int i = 0; i < N; i++) {
            if (adj.get(i).size() > 0) {
                startNode = i;
                break;
            }
        }

        // Nếu không có đỉnh nào có bậc lớn hơn 0, đồ thị không có cạnh, mặc định là liên thông
        if (startNode == -1) {
            return true;
        }
        dfs(startNode, adj, visited);
        // Kiểm tra xem tất cả các đỉnh có bậc lớn hơn 0 đều được thăm
        for (int i = 0; i < N; i++) {
            if (adj.get(i).size() > 0 && !visited[i]) {
                return false;
            }
        }

        return true;
    }

    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }
    }

    public static void main(String[] args) {
        int N3 = 5, M3 = 5;
        ArrayList<ArrayList<Integer>> edges3 = new ArrayList<>(N3);
        edges3.add(new ArrayList<>(List.of(1, 2)));
        edges3.add(new ArrayList<>(List.of(2, 3)));
        edges3.add(new ArrayList<>(List.of(3, 5)));
        edges3.add(new ArrayList<>(List.of(5, 4)));
        edges3.add(new ArrayList<>(List.of(4, 2)));
        if (eulerCycle(N3, M3, edges3)) {
            System.out.println("It has a euler tour");
        } else {
            System.out.println("It hasn't a euler tour");
        }
    }
}
