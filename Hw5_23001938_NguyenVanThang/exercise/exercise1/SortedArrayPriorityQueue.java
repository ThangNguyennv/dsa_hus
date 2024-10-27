package Hw5_23001938_NguyenVanThang.exercise.exercise1;

public class SortedArrayPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {

    protected class ArrEntry<K, E> implements Entry<K, E> {
        K key;
        E element;
        public ArrEntry(K k, E e) {
            key = k;
            element = e;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setElement(E element) {
            this.element = element;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public E getValue() {
            return element;
        }

        @Override
        public String toString() {
            return "ArrEntry {" + "key = " + key + ", element = " + element + '}';
        }
    }

    protected ArrEntry<K, E>[] array;
    protected int n = 0;
    protected int index = -1;
    protected int defaultsize = 1000;

    public SortedArrayPriorityQueue(int size) {
        array = new SortedArrayPriorityQueue.ArrEntry[size];
    }

    public SortedArrayPriorityQueue() {
        array = new SortedArrayPriorityQueue.ArrEntry[defaultsize];
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void insert(Entry<K, E> entry) {
        insert(entry.getKey(), entry.getValue());
    }

    @Override
    public void insert(K k, E e) {
        ArrEntry<K, E> x = new ArrEntry<>(k, e);
        n++;
        array[n - 1] = x;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[i].getKey().compareTo(array[j].getKey()) < 0) {
                    K tempKey = array[i].getKey() ;
                    array[i].setKey(array[j].getKey());
                    array[j].setKey(tempKey);

                    E tempValue = array[i].getValue() ;
                    array[i].setElement(array[j].getValue());
                    array[j].setElement(tempValue);
                }
            }
        }
    }

    @Override
    public Entry<K, E> removeMin() {
        Entry<K, E> min = min();
        if (isEmpty()) {
            return null;
        }
        n--;
        return min;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) {
            return null;
        }
        return array[n - 1];
    }

    public void print() {
        if (!isEmpty()) {
            for (int i = 0; i < n; i++) {
                System.out.println(array[i].getKey() + " " + array[i].getValue());
            }
        } else {
            System.out.println("PriorityQueue now is null!!!");
            return;
        }
    }

    public void printEntry(Entry<K, E> entry) {
        if (!isEmpty()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        } else {
            System.out.println("PriorityQueue now is null!!!");
            return;
        }
    }
}
