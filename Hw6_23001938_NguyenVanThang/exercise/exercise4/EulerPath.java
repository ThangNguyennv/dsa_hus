package Hw6_23001938_NguyenVanThang.exercise.exercise4;

import java.util.ArrayList;
import java.util.List;

public class EulerPath {

    // Kiểm tra có đường đi euler không ?
    public static int isPossible(int[][] paths) {
        for (int i = 0; i < paths.length; i++) {
            int count = 0;
            for (int j = 0; j < paths[i].length; j++) {
                if (paths[i][j] == 1) {
                    count++;
                }
            }
            if (count % 2 == 1) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int[][] paths = {
                {0, 1, 1, 1, 1},
                {1, 0, 0, 1, 0},
                {1, 0, 0, 1, 0},
                {1, 1, 1, 0, 1},
                {1, 0, 0, 1, 0}
        };
        if (isPossible(paths) == 1) {
            System.out.println("It has a euler path");
        } else {
            System.out.println("It hasn't a euler path");
        }
    }
}
