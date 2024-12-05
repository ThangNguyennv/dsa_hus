package Hw6_23001938_NguyenVanThang.practice.exercise12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static boolean isBipartite(ArrayList<ArrayList<Integer>> adj) {
        int colour[] = new int[adj.size()];
        Arrays.fill(colour, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        colour[0] = 0;
        while (q.size() > 0) {
            int parent = q.remove();
            int assign = colour[parent] ^ 1;
            for (int i = 0; i < adj.get(parent).size(); i++) {
                int child = adj.get(parent).get(i);
                if (colour[child] != -1) {
                    if (colour[child] != assign) return false;
                } else {
                    colour[child] = assign;
                    q.add(child);
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        // Tạo đồ thị dưới dạng danh sách kề
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

        // Kiểm tra đồ thị có phải là 2 phần không?
        if (isBipartite(adj)) {
            System.out.println("Đồ thị là 2 phần.");
        } else {
            System.out.println("Đồ thị không phải là 2 phần.");
        }
    }
}

