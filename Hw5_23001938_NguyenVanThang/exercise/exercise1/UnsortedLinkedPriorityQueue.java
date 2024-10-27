package Hw5_23001938_NguyenVanThang.exercise.exercise1;

import org.w3c.dom.Node;

public class UnsortedLinkedPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {

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
        n++;
    }

    @Override
    public Entry<K, E> removeMin() {
        Entry<K, E> min = min();
        if (isEmpty()) {
            return null;
        } else {
            if (min == head) {
                head = head.next;
            } else {
                NodeEntry<K, E> node = head;
                while (node.next != null) {
                    if (node.next == min) {
                        node.next = node.next.next;
                        break;
                    }
                    node = node.next;
                }
            }
            n--;
            return min;
        }
    }

    @Override
    public Entry<K, E> min() {
        if (!isEmpty()) {
            NodeEntry<K, E> min = head;
            NodeEntry<K, E> cur = head.next;
            while (cur != null) {
                if (min.getKey().compareTo(cur.getKey()) > 0) {
                    min = cur;
                }
                cur = cur.next;
            }
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
