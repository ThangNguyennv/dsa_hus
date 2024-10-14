package Hw1_23001938_NguyenVanThang.bai1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BubbleSort {
    public static void printArray(int array[]) {
        for (int x : array) {
            System.out.print(x + " ");
        }
    }

    public static void bubbleSort(int array[]) {
        int timesCompare = 0;
        int timesSwap = 0;
        System.out.println("State of the sequence after each loop is: ");
        for (int i = 0; i < array.length; i++) {
            boolean swaped = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    timesSwap++;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swaped = false;
                }
                timesCompare++;
                printArray(array);
                System.out.println();
            }
            if (swaped) {
                break;
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
        // for (int i = 0; i < n; i++) {
        // array[i] = sc.nextInt();
        // }
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = 1 + random.nextInt(100000);
        }
        bubbleSort(array);
    }
}
