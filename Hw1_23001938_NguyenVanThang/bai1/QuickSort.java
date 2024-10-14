package Hw1_23001938_NguyenVanThang.bai1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class QuickSort {
    public static int timesSwap = 0, timesCompare = 0;
    public static void printArray(int array[]) {
        for (int x : array) {
            System.out.print(x + " ");
        }
    }

    public static int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                timesSwap++;
            }
            timesCompare++;
            printArray(array);
            System.out.println();
        }
        i++;
        int temp = array[i];
        array[i] = array[right];
        array[right] = temp;
        timesSwap++;
        printArray(array);
        System.out.println();
        System.out.println("times compare is : " + timesCompare);
        System.out.println("times swap is : " + timesSwap);
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
//        for (int i = 0; i < n; i++) {
//            array[i] = sc.nextInt();
//        }
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = 1 + random.nextInt(100000);
        }
        quickSort(array, 0, n - 1);
    }
}
