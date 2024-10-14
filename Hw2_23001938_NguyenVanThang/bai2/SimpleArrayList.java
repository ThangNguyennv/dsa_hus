package Hw2_23001938_NguyenVanThang.bai2;

import java.util.Iterator;

public class SimpleArrayList<T> implements ListInterface<T> {
    private T[] array;
    private int n = 0;
    private int index = -1;
    private int defaultSize = 100;

    public SimpleArrayList() {
        array = (T[]) new Object[defaultSize];
    }

    public SimpleArrayList(int capacity) {
        array = (T[]) new Object[capacity];
    }

    // Hiểu ban đầu mảng chưa có gì và add vào cuối mảng
    public void add(T data) {
        index++;
        array[index] = data;
        n++;
    }

    public T get(int i) {
        return array[i];
    }

    public void set(int i, T data) {
        array[i] = data;
    }

    public void remove(T data) {
        for (int i = n - 1; i >= 0; i--) {
            if (array[i].equals(data)) {
                for (int j = i; j < n - 1; j++) {
                    array[j] = array[j + 1];
                }
                n--;
            }
        }
    }

    public boolean isContain(T data) {
        for (int i = 0; i < n; i++) {
            if (array[i].equals(data)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int indexOf(T data) {
        for (int i = 0; i < n; i++) {
            if (array[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return (currentIndex < size()) && (array[currentIndex] != null);
            }

            @Override
            public T next() {
                return array[currentIndex++];
            }
        };
        return iterator;
    }

    public void printList() {
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
    }
}