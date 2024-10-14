package Hw1_23001938_NguyenVanThang.bai1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MergeSort {
    public static int timesCompare = 0, timesSwap = 0;
    public static void printArray(int array[]) {
        for (int x : array) {
            System.out.print(x + " ");
        }
    }

    // Trộn 2 dãy con
    public static void merge(int array[], int left, int mid, int right) {
        int lengthOfLeftArray = mid - left + 1, 
            lengthOfRightArray = right - (mid + 1) + 1;
        int leftArray[] = new int[lengthOfLeftArray];
        int rightArray[] = new int[lengthOfRightArray];
        // Chia ra làm 2 mảng
        for (int i = left; i <= mid; i++) {
            leftArray[i - left] = array[i];
        }
        for (int i = mid + 1; i <= right; i++) {
            rightArray[i - (mid + 1)] = array[i];
        }
       
        int i = 0, j = 0, count = left;
        while ((i < lengthOfLeftArray) && (j < lengthOfRightArray)) {
            if (leftArray[i] <= rightArray[j]) {
                array[count] = leftArray[i];
                i++;
            } else {
                array[count] = rightArray[j];
                j++;
            }
            count++;
            timesCompare++;
            timesSwap++;
            printArray(array);
            System.out.println();
        }
        while (i < lengthOfLeftArray) {
            array[count] = leftArray[i];
            count++;
            i++;
            timesSwap++;
        }
        while (j < lengthOfRightArray) {
            array[count] = rightArray[j];
            count++;
            j++;
            timesSwap++;
        }
        printArray(array);
        System.out.println();
        System.out.println("times compare is : " + timesCompare);
        System.out.println("times swap is : " + timesSwap);
    }

    public static void mergeSort(int array[], int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
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
        mergeSort(array, 0, n - 1);
    }
}
