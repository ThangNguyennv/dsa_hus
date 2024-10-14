package Hw1_23001938_NguyenVanThang.bai4;

import java.util.*;
public class Exercise5 {
    public static int partition(int array[], int left, int right) {
        int pivot = array[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        i++;
        int temp = array[i];
        array[i] = array[right];
        array[right] = temp;
        return i;
    }

    public static void quickSort(int array[], int left, int right) {
        if (left < right) {
            int index = partition(array, left, right);
            quickSort(array, left, index - 1);
            quickSort(array, index + 1, right);

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int array[] = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        quickSort(array, 0, n - 1);
        for (int x : array) {
            System.out.print(x + " ");
        }
    }
}