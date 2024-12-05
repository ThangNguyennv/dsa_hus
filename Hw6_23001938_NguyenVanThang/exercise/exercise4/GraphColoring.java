package Hw6_23001938_NguyenVanThang.exercise.exercise4;

import java.util.Arrays;

public class GraphColoring {
    private int[][] graph; // Ma trận kề biểu diễn đồ thị
    private int numVertices; // Số đỉnh trong đồ thị

    public GraphColoring(int[][] graph) {
        this.graph = graph;
        this.numVertices = graph.length;
    }

    // Thuật toán tô màu Greedy
    public int greedyColoring() {
        int[] colors = new int[numVertices]; // Mảng lưu màu của mỗi đỉnh
        Arrays.fill(colors, -1); // -1 biểu thị đỉnh chưa được tô màu

        boolean[] availableColors = new boolean[numVertices]; // Màu khả dụng

        // Tô màu cho đỉnh đầu tiên
        colors[0] = 0;

        // Tô màu cho các đỉnh còn lại
        for (int u = 1; u < numVertices; u++) {
            // Đặt tất cả các màu khả dụng thành true
            Arrays.fill(availableColors, true);

            // Đánh dấu các màu đã được sử dụng bởi các đỉnh kề
            for (int v = 0; v < numVertices; v++) {
                if (graph[u][v] == 1 && colors[v] != -1) {
                    availableColors[colors[v]] = false; // Màu này không khả dụng
                }
            }

            // Tìm màu đầu tiên khả dụng
            int color;
            for (color = 0; color < numVertices; color++) {
                if (availableColors[color]) {
                    break;
                }
            }

            // Gán màu cho đỉnh u
            colors[u] = color;
        }

        // Tìm sắc số (số màu tối đa sử dụng)
        int chromaticNumber = 0;
        for (int color : colors) {
            chromaticNumber = Math.max(chromaticNumber, color + 1);
        }

        System.out.println("Kết quả tô màu:");
        for (int i = 0; i < numVertices; i++) {
            System.out.println("Đỉnh " + i + " được tô màu " + colors[i]);
        }
        System.out.println("Sắc số của đồ thị: " + chromaticNumber);

        return chromaticNumber;
    }

    public static void main(String[] args) {
        int[][] graph = { // Ma trận kề
                {0, 1, 1, 0},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {0, 1, 1, 0}
        };

        GraphColoring gc = new GraphColoring(graph);
        gc.greedyColoring();
    }
}
