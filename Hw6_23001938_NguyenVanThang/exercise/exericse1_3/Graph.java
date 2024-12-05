package Hw6_23001938_NguyenVanThang.exercise.exericse1_3;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph implements GraphInterface{ // Đồ thị vô hướng không trọng số
    private int v; // Đỉnh v
    private int[][] adj; // Ma trận kề

    public Graph(int v) {
        this.v = v;
        adj = new int[v][v];
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
                if (adj[i][j] == 1) {
                    result++;
                }
            }
        }
        return result / 2;
    }

    @Override
    public int degreeGraph() {
        int result = 0;
        for (int i = 0; i < v; i++) {
            int temp = 0;
            for (int j = 0; j < v; j++) {
                if (adj[i][j] == 1) {
                    temp++;
                }
            }
            if (temp > result) {
                result = temp;
            }
        }
        return result;
    }

    @Override
    public boolean isEdge(int u, int v) {
        return adj[u][v] == 1;
    }

    @Override
    public List<Integer> adjVertices(int u) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (adj[u][i] == 1) {
                list.add(i);
            }
        }
        return list;
    }

    @Override
    public void addEdge(int u, int v) {
        adj[u][v] = 1;
        adj[v][u] = 1;
    }

    @Override
    public void BFS(int u) {
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[v];
        queue.add(u);
        visited[u] = true;
        while (!queue.isEmpty()) {
            int x = queue.peek();
            queue.remove();
            System.out.print(x + " ");
            List<Integer> adjV = adjVertices(x);
            for (int neighbor : adjV) {
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
        List<Integer> adjV = adjVertices(u);
        for (int neighbor : adjV) {
            if (!visited[neighbor]) {
                DFSRec(neighbor, visited);
            }
        }
    }

    @Override
    public void DFS(int u) {
        boolean visited[] = new boolean[v];
        DFSRec(u, visited);
    }
}
