package Hw1_23001938_NguyenVanThang.bai4;

import java.util.*;
public class Exercise7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int array[] = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        Map<Integer, Integer> map = new TreeMap<>();
        for (int x : array) {
            if (map.containsKey(x)) {
                int tanSuat = map.get(x);
                map.put(x, tanSuat + 1);
            } else {
                map.put(x, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print(entry.getKey() + " " + entry.getValue() + "; ");
        }
    }
}