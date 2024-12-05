package Hw6_23001938_NguyenVanThang.practice.exercise14;

public class LargestRegion {
    public int findMaxArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int area = dfs(grid, visited, i, j);
                    if (area > maxArea) maxArea = area;
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, boolean[][] visited, int r, int c) {
        int m = grid.length, n = grid[0].length;
        visited[r][c] = true;
        int count = 1;
        int[] xdir = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] ydir = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < 8; i++) {
            int x = r + xdir[i];
            int y = c + ydir[i];
            if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && grid[x][y] == 1) {
                count += dfs(grid, visited, x, y);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };

        LargestRegion test = new LargestRegion();

        int maxArea = test.findMaxArea(grid);
        System.out.println("Diện tích lớn nhất của vùng liên thông: " + maxArea);
    }
}
