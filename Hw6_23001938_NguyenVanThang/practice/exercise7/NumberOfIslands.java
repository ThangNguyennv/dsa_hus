package Hw6_23001938_NguyenVanThang.practice.exercise7;

import java.util.*;

public class NumberOfIslands {

    public static int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid, vis);
                }
            }
        }
        return count;
    }

    public static void dfs(int row, int col, char[][] grid, int[][] vis) {

        int n = grid.length;
        int m = grid[0].length;
        vis[row][col] = 1;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nrow = row + i;
                int ncol = col + j;

                if (nrow < 0 || ncol < 0 || nrow >= n || ncol >= m || grid[nrow][ncol] == '0' || vis[nrow][ncol] == 1) {
                    continue;
                }
                dfs(nrow, ncol, grid, vis);
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'0', '1', '1', '1', '0', '0', '0'},
                {'0', '0', '1', '1', '0', '1', '0'}
        };
        System.out.println(numIslands(grid));
    }
}
