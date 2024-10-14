package Hw1_23001938_NguyenVanThang.bai1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SelectionSort {
    public static void printArray(int array[]) {
        for (int x : array) {
            System.out.print(x + " ");
        }
    }

    public static void selectionSort(int array[]) {
        int timesCompare = 0;
        int timesSwap = 0;
        System.out.println("State of the sequence after each loop is: ");
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    timesSwap++;
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
                timesCompare++;
                printArray(array);
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("times compare is : " + timesCompare);
        System.out.println("times swap is : " + timesSwap);
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
        selectionSort(array);
    }
}
