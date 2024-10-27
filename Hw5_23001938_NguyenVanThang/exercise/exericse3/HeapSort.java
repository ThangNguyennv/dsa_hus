package Hw5_23001938_NguyenVanThang.exercise.exericse3;

import Hw5_23001938_NguyenVanThang.exercise.exercise2.MinHeapPriorityQueue;

public class HeapSort {

    public static int quickTimesCompare = 0, quickTimesSwap = 0;
    public static int mergeTimesCompares = 0, mergeTimesSwaps = 0;

    public static void main(String[] args) {
        int[] array1 = {5, 3, 7, 1, 6, 1};
        int[] array2 = {5, 3, 7, 1, 6, 1};
        int[] array3 = {5, 3, 7, 1, 6, 1};
        int[] array4 = {5, 3, 7, 1, 6, 1};
        int[] array5 = {5, 3, 7, 1, 6, 1};
        int[] array6 = {5, 3, 7, 1, 6, 1};

        selectionSort(array1);

        System.out.println("-----------------------");

        bubbleSort(array2);

        System.out.println("-----------------------");

        insertionSort(array3);

        System.out.println("-----------------------");

        quickSort(array4, 0, array4.length - 1);
        for (int x : array4) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println("Quick times compare is : " + quickTimesCompare);
        System.out.println("Quick times swap is : " + quickTimesSwap);

        System.out.println("-----------------------");

        mergeSort(array5, 0, array5.length - 1);
        for (int x : array5) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println("Merge times compare is : " + mergeTimesCompares);
        System.out.println("Merge times swap is : " + mergeTimesSwaps);

        System.out.println("-----------------------");

        heapSort(array6);

        // QuickSort là ổn nhất!

    }


    public static void heapSort(int[] arr) {
        MinHeapPriorityQueue<Integer, Character> q = new MinHeapPriorityQueue<>();
        for (int i = 0; i < arr.length; i++)
            q.insert(arr[i], null);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = q.removeMin().getKey();
        }
        printArray(arr);
        System.out.println();
        System.out.println("Heap Times compare: " + q.timesCompare);
        System.out.println("Heap Times swap: " + q.timesSwap);
    }

    public static void printArray(int[] array) {
        for (int x : array) {
            System.out.print(x + " ");
        }
    }

    public static void bubbleSort(int[] array) {
        int timesCompare = 0;
        int timesSwap = 0;
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
            }
            if (swaped) {
                break;
            }
        }
        for (int x : array) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println("Bubble times compare is : " + timesCompare);
        System.out.println("Bubble times swap is : " + timesSwap);
    }

    public static void insertionSort(int[] array) {
        int timesCompare = 0;
        int timesSwap = 0;
        for (int i = 1; i < array.length; i++) {
            int pos = i - 1, x = array[i];
            timesCompare++;
            while ((pos >= 0) && (array[pos] > x)) {
                array[pos + 1] = array[pos];
                timesSwap++;
                pos--;
            }
            array[pos + 1] = x;
        }
        for (int x : array) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println("Insertion times compare is : " + timesCompare);
        System.out.println("Insertion times swap is : " + timesSwap);
    }

    public static void selectionSort(int[] array) {
        int timesCompare = 0;
        int timesSwap = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    timesSwap++;
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
                timesCompare++;
            }
        }
        for (int x : array) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println("Selection times compare is : " + timesCompare);
        System.out.println("Selection times swap is : " + timesSwap);
    }



    // Trộn 2 dãy con
    public static void merge(int[] array, int left, int mid, int right) {
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
            mergeTimesCompares++;
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

    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
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
                quickTimesSwap++;
            }
            quickTimesCompare++;
        }
        i++;
        int temp = array[i];
        array[i] = array[right];
        array[right] = temp;
        quickTimesSwap++;
        return i;
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int index = partition(array, left, right);
            quickSort(array, left, index - 1);
            quickSort(array, index + 1, right);
        }
    }
}
