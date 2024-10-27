package Hw5_23001938_NguyenVanThang.exercise.exercise1;

public class SortedLinkedPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {

    protected class NodeEntry<K, E> implements Entry<K, E> {
        private K key;
        private E element;
        private NodeEntry<K, E> next;

        private NodeEntry (K k, E e) {
            key = k;
            element = e;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public E getElement() {
            return element;
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

    private NodeEntry<K, E> head = null;
    private NodeEntry<K, E> tail = null;
    int n = 0;

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

    // cho danh sách tăng dần
    @Override
    public void insert(K k, E e) {
        NodeEntry<K, E> newNode = new NodeEntry<>(k, e);
        NodeEntry<K, E> node = head;
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            while (node.next != null) {
                node = node.next;
            }
            node.next = newNode;
            tail = newNode;
        }
        NodeEntry<K, E> cur = head;
        while (cur.next != null) {
            if (cur.getKey().compareTo(tail.getKey()) > 0) {
                K keyTemp = cur.getKey();
                E valueTemp = cur.getValue();

                cur.setKey(tail.getKey());
                cur.setElement(tail.getElement());

                tail.setKey(keyTemp);
                tail.setElement(valueTemp);
            }
            cur = cur.next;
        }
        n++;
    }

    // cho danh sách tăng dần
    @Override
    public Entry<K, E> removeMin() {
        Entry<K, E> min = min();
        if (isEmpty()) {
            return null;
        } else {
            head = head.next;
            n--;
            return min;
        }
    }

    // cho danh sách tăng dần
    @Override
    public Entry<K, E> min() {
        NodeEntry<K, E> min = head;
        if (!isEmpty()) {
            return min;
        }
        return null;
    }

    // cho danh sách giảm dần
    public void insert1(K k, E e) {
        NodeEntry<K, E> newNode = new NodeEntry<>(k, e);
        NodeEntry<K, E> node = head;
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            while (node.next != null) {
                node = node.next;
            }
            node.next = newNode;
            tail = newNode;
        }
        NodeEntry<K, E> cur = head;
        while (cur.next != null) {
            if (cur.getKey().compareTo(tail.getKey()) < 0) {
                K keyTemp = cur.getKey();
                E valueTemp = cur.getValue();

                cur.setKey(tail.getKey());
                cur.setElement(tail.getElement());

                tail.setKey(keyTemp);
                tail.setElement(valueTemp);
            }
            cur = cur.next;
        }
        n++;
    }

    // cho danh sách giảm dần
    public Entry<K, E> removeMin1() {
        Entry<K, E> min = min();
        NodeEntry<K, E> node = head;
        if (isEmpty()) {
            return null;
        } else {
            while (node.next.next != null) {
                node = node.next;
            }
            node.next = null;
            tail = node;
            n--;
            return min;
        }
    }

    // cho danh sách giảm dần
    public Entry<K, E> min1() {
        NodeEntry<K, E> min = tail;
        if (!isEmpty()) {
            return min;
        }
        return null;
    }

    public void print() {
        if (!isEmpty()) {
            NodeEntry<K, E> node = head;
            while (node != null) {
                System.out.println(node.getKey() + " " + node.getValue());
                node = node.next;
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
