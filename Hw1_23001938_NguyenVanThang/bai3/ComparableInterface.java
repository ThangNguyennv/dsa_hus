package Hw1_23001938_NguyenVanThang.bai3;

public interface ComparableInterface<T> {
    void insertionSort();
    void bubbleSort();
    void selectionSort();
    void mergeSort(T[] array, int left, int right);
    void quickSort(T[] array, int left, int right);
    void printArray();
} 