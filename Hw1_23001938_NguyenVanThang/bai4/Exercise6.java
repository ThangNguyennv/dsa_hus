package Hw1_23001938_NguyenVanThang.bai4;

import java.util.*;
public class Exercise6 {
    public static void selectionSort(int array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length ; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static int search(int array[]) {
        selectionSort(array);
        if (array[0] > 0) {
            return 0;
        }
        for (int i = 1; i < array.length; i++) {
            if (Math.abs(array[i] - array[i - 1]) > 1) {
                return array[i - 1] + 1;
            }
        }
        return array[array.length - 1] + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int array[] = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println(search(array));
    }
}