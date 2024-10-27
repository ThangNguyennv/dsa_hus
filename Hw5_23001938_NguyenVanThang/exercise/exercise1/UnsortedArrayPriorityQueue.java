package Hw5_23001938_NguyenVanThang.exercise.exercise1;

public class UnsortedArrayPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {

    protected class ArrEntry<K, E> implements Entry<K, E> {
        K key;
        E element;
        public ArrEntry(K k, E e) {
            key = k;
            element = e;
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

    ArrEntry<K, E> [] array;
    int n = 0;
    int index = -1;
    int defaultsize = 1000;

    public UnsortedArrayPriorityQueue(int size) {
        array = new UnsortedArrayPriorityQueue.ArrEntry[size];
    }

    public UnsortedArrayPriorityQueue() {
        array = new UnsortedArrayPriorityQueue.ArrEntry[defaultsize];
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
        index++;
        array[index] = new ArrEntry<>(k, e);
        n++;
    }

    @Override
    public Entry<K, E> removeMin() {
        ArrEntry<K, E> min = (ArrEntry<K, E>) min();
        if (isEmpty()) {
            return null;
        } else {
            for (int i = 0; i < n; i++) {
                if (array[i].getKey().compareTo(min.getKey()) == 0) {
                    for (int j = i; j < n - 1; j++) {
                        array[j] = array[j + 1];
                    }
                    n--;
                    break;
                }
            }
            return min;
        }
    }

    @Override
    public Entry<K, E> min() {
        if (!isEmpty()) {
            ArrEntry<K, E> min = array[0];
            for (int i = 1; i < n; i++) {
                if (array[i].getKey().compareTo(min.getKey()) < 0) {
                    min = array[i];
                }
            }
            return min;
        }
        return null;
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

    public ArrEntry<K, E> createEntry(K key, E element) {
        return new ArrEntry<>(key, element);
    }
}
