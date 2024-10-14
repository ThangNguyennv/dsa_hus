package Hw3_23001938_NguyenVanThang.exercise_four.linked_list_queue;

import java.util.Iterator;

public class LinkedListQueue<E> implements QueueInterface<E> {
    class Node {
        E element;
        Node next;

        public Node(E element) {
            this.element = element;
        }
    }

    private Node front = null;
    private Node rear = null;

    @Override
    public void enqueue(E element) { // thêm vào cuối hàng đợi
        Node newNode = new Node(element);
        newNode.next = null;
        if (rear != null) {
            rear.next = newNode;
        } else {
            front = newNode; // hàng đợi rỗng
        }
        rear = newNode;
    }

    @Override
    public E dequeue() { // xóa ở đầu hàng đợi và trả về thằng bị xóa
        if (front != null) {
            Node node = front;
            E data = node.element;
            front = front.next;
            if (node == rear) { // hàng đợi chỉ có 1 phần tử
                rear = null;
            }
            return data;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
