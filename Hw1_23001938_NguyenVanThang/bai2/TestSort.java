package Hw1_23001938_NguyenVanThang.bai2;

import Hw1_23001938_NguyenVanThang.bai1.MergeSort;

import java.util.*;

public class TestSort {
    public static void main(String[] args) {
        Integer[] arr = {12, 11, 13, 5, 6, 700, 1, 2};
        Sort<Integer> sort = new Sort<>(arr);
        sort.printArray();
        System.out.println();
        System.out.println("After sorting: ");
        // Tương tự với selectionSort(), insertionSort(), bubbleSort(), mergeSort().
        sort.quickSort(arr, 0, arr.length - 1);
        sort.printArray();
    }
}
