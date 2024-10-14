package Hw1_23001938_NguyenVanThang.bai4;

import java.util.*;
public class Exercise4 {
    public static void merge(int array[],int mid, int left, int right) {
        int lengthOfLeftArray = mid - left + 1;
        int lengthOfRightArray = right - (mid + 1) + 1;
        int[] leftArray = new int[lengthOfLeftArray];
        int[] rightArray = new int[lengthOfRightArray];
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
                count++;
                i++;
            } else {
                array[count] = rightArray[j];
                count++;
                j++;
            }
        }
        while(i < lengthOfLeftArray) {
            array[count] = leftArray[i];
            count++;
            i++;
        }
        while(i < lengthOfRightArray) {
            array[count] = rightArray[j];
            count++;
            j++;
        }
    }
    public static void mergeSort(int array[], int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, mid, left, right);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int array[] = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        mergeSort(array, 0, n - 1);
        for (int x : array) {
            System.out.print(x + " ");
        }
    }
}