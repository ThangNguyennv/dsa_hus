package Hw1_23001938_NguyenVanThang.bai2;

import java.util.*;

public class Sort<T extends Comparable<T>> implements ComparableInterface<T> {

    private T[] array;

    public Sort(T[] array) {
        this.array = array;
    }

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    @Override
    public void printArray() {
        for (T x : array) {
            System.out.print(x + " ");
        }
    }

    @Override
    public void selectionSort() {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length ; j++) {
                if (array[i].compareTo(array[j]) > 0) {
                    T temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    @Override
    public void bubbleSort() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public void insertionSort() {
        for (int i = 1; i < array.length; i++) {
            int pos = i - 1;
            T x = array[i];
            while ((pos >= 0) && (array[pos].compareTo(x) > 0))  {
                array[pos + 1] = array[pos];
                pos--;
            }
            array[pos + 1] = x;
        }
    }

    public void merge(T[] array, int left, int mid, int right) {
        int lengthOfLeftArray = mid - left + 1,
                lengthOfRightArray = right - (mid + 1) + 1;
        T[] leftArray = Arrays.copyOfRange(array, left, mid + 1);
        T[] rightArray = Arrays.copyOfRange(array, mid + 1, right + 1);
        // Chia ra làm 2 mảng
        for (int i = left; i <= mid; i++) {
            leftArray[i - left] = array[i];
        }
        for (int i = mid + 1; i <= right; i++) {
            rightArray[i - (mid + 1)] = array[i];
        }

        int i = 0, j = 0, count = left;
        while ((i < lengthOfLeftArray) && (j < lengthOfRightArray)) {
            if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                array[count] = leftArray[i];
                i++;
            } else {
                array[count] = rightArray[j];
                j++;
            }
            count++;
        }
        while (i < lengthOfLeftArray ) {
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

    @Override
    public void mergeSort(T[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    public int partition(T[] array, int left, int right) {
        T pivot = array[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        i++;
        T temp = array[i];
        array[i] = array[right];
        array[right] = temp;
        return i;
    }

    @Override
    public void quickSort(T[] array, int left, int right) {
        if (left < right) {
            int pivot = partition(array, left, right);
            quickSort(array, left, pivot - 1);
            quickSort(array, pivot + 1, right);
        }
    }
}
