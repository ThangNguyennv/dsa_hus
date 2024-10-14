package Hw1_23001938_NguyenVanThang.bai7;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
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
        }
        while (i < lengthOfLeftArray) {
            array[count] = leftArray[i];
            count++;
            i++;
        }
        while (j < lengthOfRightArray) {
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
            merge(array, left, mid, right);
        }
    }

    public static int firstPos(int array[], int left, int right, int x) {
       int res = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == x) {
                res = mid;
                right = mid - 1;
            } else if (array[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    public static int lastPos(int array[], int left, int right, int x) {
        int res = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == x) {
                res = mid;
                left = mid + 1;
            } else if (array[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int array[] = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        mergeSort(array, 0, n - 1);
        long count = 0;
        for (int i = 0; i < n; i++) {
            int start = firstPos(array, i + 1, n - 1, x - array[i]);
            int end = lastPos(array, i + 1, n - 1, x - array[i]);
            if (start != -1) {
                count += (end - start + 1);
            }
        }
        System.out.println(count);
    }
}
