package Hw6_23001938_NguyenVanThang.exercise.exercise4;

import java.util.*;

public class Dijkstra {
    static class Node {
        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    public static int[] dijkstra(int[][] adj, int x, int y) {
        int n = adj.length;
        x--;
        y--;
        int[] dist = new int[n]; // lưu trọng số
        int[] prev = new int[n]; // lưu đường đi
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < n; i++) {
            prev[i] = -1;
        }
        dist[0] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.distance, o2.distance);
            }
        });
        queue.add(new Node(x, 0));
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            int u = curr.vertex;
            visited[u] = true;

            for (int i = 0; i < n; i++) {
                if (!visited[i] && adj[u][i] != 0 && dist[u] + adj[u][i] < dist[i]) {
                    dist[i] = (int) (dist[u] + adj[u][i]);
                    prev[i] = u;
                    queue.add(new Node(i, dist[i]));
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        print(prev, y, list);
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i) + 1;
        }
        return result;
    }

    private static void print(int[] prev, int y, List<Integer> list) {
        if (y == -1) {
            return;
        }
        print(prev, prev[y], list);
        list.add(y);
    }

    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
                {0, 2, 4, 0, 0},
                {2, 0, 1, 7, 0},
                {4, 1, 0, 3, 5},
                {0, 7, 3, 0, 1},
                {0, 0, 5, 1, 0}
        };
        int start = 3, end = 4;

        int[] shortestPath = dijkstra(adjacencyMatrix, start, end);
        System.out.println(Arrays.toString(shortestPath));
    }
}
