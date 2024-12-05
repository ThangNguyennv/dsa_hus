package Hw6_23001938_NguyenVanThang.exercise.exericse2_3;

import java.util.List;

public interface GraphInterface {
    int numVertices(); // Số đỉnh của đồ thị
    int numEdge(); // Số cạnh của đồ thị
    int degreeGraph(); // Bậc lớn nhất trong đồ thị
    boolean isEdge(int u, int v); // Có cạnh nối giữa 2 đỉnh u và v khong?
    List<Integer> adjVertices(int u); // Danh sách các đỉnh kề của đỉnh u
    void addEdge(int u, int v, int w); // Thêm cạnh và trọng số
    void BFS(int u); // Thuật toán BFS - Duyệt theo chiêu rộng
    void DFS(int u); // Thuật toán DFS - Duyệt theo chiều sâu
}
