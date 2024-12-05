package Hw6_23001938_NguyenVanThang.exercise.exericse2_3;

import java.util.*;

public class WeightGraph implements GraphInterface { // Đồ thị có hướng có trọng số
    private int v;
    private double[][] adj;

    public WeightGraph(int v) {
        this.v = v;
        adj = new double[v][v];
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                adj[i][j] = 0;
            }
        }
    }

    @Override
    public int numVertices() {
        return v;
    }

    @Override
    public int numEdge() {
        int result = 0;
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (adj[i][j] != 0) {
                    result++;
                }
            }
        }
        return result;
    }

    @Override
    public int degreeGraph() {
        int degree = 0;
        for (int i = 0; i < v; i++) {
            int temp = 0;
            for (int j = 0; j < v; j++) {
                if (adj[i][j] != 0) {
                    temp++;
                }
            }
            if (temp > degree) {
                degree = temp;
            }
        }
        return degree;
    }

    @Override
    public boolean isEdge(int u, int v) {
        return adj[u][v] != 0;
    }

    @Override
    public List<Integer> adjVertices(int u) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            if (adj[u][i] != 0) {
                list.add(i);
            }
        }
        return list;
    }

    @Override
    public void addEdge(int u, int v, int w) {
        adj[u][v] = w;
    }

    @Override
    public void BFS(int u) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[v];
        queue.add(u);
        visited[u] = true;
        while (!queue.isEmpty()) {
            int x = queue.peek();
            queue.remove();
            System.out.print(x + " ");
            List<Integer> list = adjVertices(x);
            for (int neighbor : list) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }

    public void DFSRec(int u, boolean visited[]) {
        visited[u] = true;
        System.out.print(u + " ");
        List<Integer> list = adjVertices(u);
        for (int neighbor : list) {
            if (!visited[neighbor]) {
                DFSRec(neighbor, visited);
            }
        }
    }

    @Override
    public void DFS(int u) {
        boolean[] visited = new boolean[v];
        DFSRec(u, visited);
    }
}
