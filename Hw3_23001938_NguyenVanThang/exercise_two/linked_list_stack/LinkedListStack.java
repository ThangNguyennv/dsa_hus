package Hw3_23001938_NguyenVanThang.exercise_two.linked_list_stack;

import java.util.Iterator;

public class LinkedListStack<E> implements StackInterface<E> {
    class Node {
        E element;
        Node next;

        public Node(E element) {
            this.element = element;
        }
    }

    private Node stack = null;
    private int size = 0;
    @Override
    public void push(E element) {
        Node newNode = new Node(element);
        if (stack == null) {
            stack = newNode;
        } else {
            newNode.next = stack;
            stack = newNode;
        }
        size++;
    }

    @Override
    public E pop() { // trả về phần tử bị xóa
        if (stack == null) {
            return null;
        } else {
            E node = stack.element;
            if (size > 1) {
                stack = stack.next;
            } else {
                stack = null;
            }
            size--;
            return node;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E top() {
        E top = stack.element;
        return top;
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }

    class StackIterator implements Iterator<E> {
        private Node currentNode = stack;


        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public E next() {
            E data = currentNode.element;
            currentNode = currentNode.next;
            return data;
        }
    }
}
