package Hw1_23001938_NguyenVanThang.bai1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class InsertionSort {
    public static void printArray(int array[]) {
        for (int x : array) {
            System.out.print(x + " ");
        }
    }

    public static void insertionSort(int array[]) {
        int timesCompare = 0;
        int timesSwap = 0;
        System.out.println("State of the sequence after each loop is: ");
        for (int i = 1; i < array.length; i++) {
            int pos = i - 1, x = array[i];
            // System.out.println("i = " + i);
            timesCompare++;
            while ((pos >= 0) && (array[pos] > x)) {
                array[pos + 1] = array[pos];
                timesSwap++;
                printArray(array);
                pos--;
                System.out.println();
            }
            timesCompare++;
            array[pos + 1] = x;
            printArray(array);
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
        //     array[i] = sc.nextInt();
        // }
       Random random = new Random();
       for (int i = 0; i < n; i++) {
           array[i] = 1 + random.nextInt(100000);
       }
       insertionSort(array);
    }
}
