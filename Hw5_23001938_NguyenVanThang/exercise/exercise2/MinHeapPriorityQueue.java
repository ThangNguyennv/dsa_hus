package Hw5_23001938_NguyenVanThang.exercise.exercise2;

import Hw5_23001938_NguyenVanThang.exercise.exercise1.Entry;
import Hw5_23001938_NguyenVanThang.exercise.exercise1.SortedArrayPriorityQueue;

public class MinHeapPriorityQueue<K extends Comparable<K>, E> extends SortedArrayPriorityQueue<K, E> {
    ArrEntry<K, E> heapPQ[] = array;

    public MinHeapPriorityQueue() {
        super();
    }

    public void swap(int i, int j) {
        ArrEntry<K, E> temp = heapPQ[i];
        heapPQ[i] = heapPQ[j];
        heapPQ[j] = temp;
    }

    @Override
    public void insert(K k, E e) {
        heapPQ[n] = new ArrEntry<K, E>(k, e);
        n++;
        upHead();
    }

    @Override
    public Entry<K, E> min() {
        return heapPQ[0];
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) {
            return null;
        }
        Entry<K, E> min = min();
        swap(0, n - 1);
        heapPQ[n - 1] = null;
        n--;
        downHeap();
        return min;
    }

    protected void upHead() { // Di chuyển phần tử từ dưới lên trên
        int i = n - 1;
        // i la con, i / 2 la cha
        while (i > 0 && heapPQ[i / 2].getKey().compareTo(heapPQ[i].getKey()) > 0) {
            swap(i / 2, i);
            i /= 2;
        }
    }

    public int timesSwap = 0;
    public int timesCompare = 0;

    protected void downHeap() { // Di chuyển phần tử từ trên xuống dưới
        int i = 0;
        while (i < n) {
            if (2 * i + 2 < n) { // node có cả con trái và phải
                timesCompare++;
                int largest = i;
                if (heapPQ[largest].getKey().compareTo(heapPQ[2 * i + 1].getKey()) >= 0) {
                    largest = 2 * i + 1; // lưu chỉ số con trái
                    timesCompare++;
                }
                if (heapPQ[largest].getKey().compareTo(heapPQ[2 * i + 2].getKey()) >= 0)
                    largest = 2 * i + 2; // lưu chỉ số con phải
                timesCompare++;
                if (largest != i) {
                    swap(i, largest);
                    i = largest;
                    timesCompare++;
                    timesSwap++;
                } else {
                    break;
                }
            } else if (2 * i + 1 < n) {
                timesCompare++;
                if(heapPQ[i].getKey().compareTo(heapPQ[2 * i + 1].getKey()) >= 0) {
                    swap(i, 2 * i + 1);
                    timesCompare++;
                    timesSwap++;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
    }
}
