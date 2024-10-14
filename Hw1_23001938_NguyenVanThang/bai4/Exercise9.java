package Hw1_23001938_NguyenVanThang.bai4;

import java.util.*;
public class Exercise9 {
    public static boolean soChinhPhuong(int n) {
        int canN = (int) Math.sqrt(n);
        return canN * canN == n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int array[] = new int[n];
        Set<Integer> set = new TreeSet<>();
        Set<Integer> set1 = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
            set.add(array[i]);
        }
        for (int x : set) {
            if (soChinhPhuong(x)) {
                set1.add(x);
            }
        }
        if (set1.isEmpty()) {
            System.out.print("NULL");
            return;
        } else {
            for (int x : set1) {
                System.out.print(x + " ");
            }
        }
    }
}