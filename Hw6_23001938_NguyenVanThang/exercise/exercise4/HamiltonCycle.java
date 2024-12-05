package Hw6_23001938_NguyenVanThang.exercise.exercise4;

import java.util.*;

public class HamiltonCycle {
    private int numVertices; // Số đỉnh trong đồ thị
    private int[][] graph;   // Ma trận kề biểu diễn đồ thị
    private int[] path;      // Đường đi thử

    public HamiltonCycle(int[][] graph) {
        this.numVertices = graph.length;
        this.graph = graph;
        this.path = new int[numVertices];
        Arrays.fill(path, -1); // Khởi tạo đường đi
    }

    // Kiểm tra xem việc thêm đỉnh 'v' vào vị trí 'pos' có hợp lệ không?
    private boolean isSafe(int v, int pos) {
        // Đỉnh v phải kề với đỉnh trước đó trong đường đi
        if (graph[path[pos - 1]][v] == 0) {
            return false;
        }

        // Đỉnh v chưa được thêm vào đường đi
        for (int i = 0; i < pos; i++) {
            if (path[i] == v) {
                return false;
            }
        }

        return true;
    }

    // Hàm đệ quy để tìm chu trình Hamilton bắt đầu từ vị trí 'pos'
    private boolean hamiltonianCycleUtil(int pos) {
        // Nếu tất cả các đỉnh đã được thêm vào đường đi
        if (pos == numVertices) {
            // Kiểm tra xem đỉnh cuối có kề với đỉnh đầu để tạo chu trình không
            return graph[path[pos - 1]][path[0]] == 1;
        }

        // Thử các đỉnh khác nhau làm đỉnh tiếp theo trong đường đi
        for (int v = 1; v < numVertices; v++) { // Bắt đầu từ 1 vì đỉnh đầu đã được chọn
            if (isSafe(v, pos)) {
                path[pos] = v;

                if (hamiltonianCycleUtil(pos + 1)) {
                    return true;
                }

                // Nếu không tìm thấy, quay lui
                path[pos] = -1;
            }
        }

        return false;
    }

    public boolean findHamiltonianCycle() {
        // Bắt đầu từ đỉnh 0
        path[0] = 0;

        // Gọi hàm đệ quy để tìm chu trình Hamilton
        if (!hamiltonianCycleUtil(1)) {
            System.out.println("It hasn't a hamilton cycle");
            return false;
        } else {
            System.out.println("It has a hamilton cycle");
            printCycle();
            return true;
        }
    }

    private void printCycle() {
        System.out.println("Chu trình Hamilton:");
        for (int i = 0; i < numVertices; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println(path[0]); // Quay lại đỉnh đầu để tạo chu trình
    }

    public static void main(String[] args) {
        int[][] graph = { // Ma trận kề
                {0, 1, 1, 1, 0},
                {1, 0, 1, 0, 1},
                {1, 1, 0, 1, 1},
                {1, 0, 1, 0, 1},
                {0, 1, 1, 1, 0}
        };

        HamiltonCycle hc = new HamiltonCycle(graph);
        hc.findHamiltonianCycle();
    }
}

