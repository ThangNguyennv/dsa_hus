package Hw6_23001938_NguyenVanThang.exercise.exercise4;

import java.util.ArrayList;
import java.util.List;

public class HamiltonPath {

    // Kiểm tra có đường đi hamilton không?
    public static boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) {
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

        int count = 0;
        int[] visited = new int[N];
        for (int i = 0; i < N; i++) {
            if (dfs(i, adj, visited, count, N)) {
                return true;
            }
        }
        return false;
    }

    public static boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] visited, int count, int n) {
        visited[node] = 1;
        count++;

        if (count == n) {
            return true;
        }

        for (int x : adj.get(node)) {
            if (visited[x] != 1) {
                if (dfs(x, adj, visited, count, n)) {
                    return true;
                }
            }
        }

        visited[node] = 0;
        count--;

        return false;
    }

    // Kiểm tra có chu trình hamilton không?


    public static void main(String[] args) {
        int N1 = 4, M1 = 4;
        ArrayList<ArrayList<Integer>> edges1 = new ArrayList<>(N1);
        edges1.add(new ArrayList<>(List.of(1, 2)));
        edges1.add(new ArrayList<>(List.of(2, 3)));
        edges1.add(new ArrayList<>(List.of(3, 4)));
        edges1.add(new ArrayList<>(List.of(2, 4)));
        if (check(N1, M1, edges1)) {
            System.out.println("It has a hamiltonian path!");
        } else {
            System.out.println("It hasn't a hamiltonian path!");
        }

        int N2 = 4, M2 = 3;
        ArrayList<ArrayList<Integer>> edges2 = new ArrayList<>(N2);
        edges2.add(new ArrayList<>(List.of(1, 2)));
        edges2.add(new ArrayList<>(List.of(2, 3)));
        edges2.add(new ArrayList<>(List.of(2, 4)));
        if (check(N2, M2, edges2)) {
            System.out.println("It has a hamiltonian path!");
        } else {
            System.out.println("It hasn't a hamiltonian path!");
        }
    }
}
