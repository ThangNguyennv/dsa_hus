package Hw1_23001938_NguyenVanThang.bai4;

import java.util.*;
public class Exercise2 {
    public static void insertionSort(int array[]) {
        for (int i = 1; i < array.length; i++) {
            int pos = i - 1, x = array[i];
            while ((pos >= 0) && (array[pos] > x)) {
                array[pos + 1] = array[pos];
                pos--;
            }
            array[pos + 1] = x;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int array[] = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        insertionSort(array);
        for (int x : array) {
            System.out.print(x + " ");
        }
    }
}