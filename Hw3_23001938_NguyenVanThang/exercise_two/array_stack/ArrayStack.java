package Hw3_23001938_NguyenVanThang.exercise_two.array_stack;

import java.util.Iterator;

public class ArrayStack<E> implements StackInterface<E> {
    private E[] stack;
    private int top = -1;

    public ArrayStack(int capacity) {
        stack = (E[]) new Object[capacity];
    }
    @Override
    public void push(E element) {
        top++;
        stack[top] = element;
    }

    @Override
    public E pop() {
        if (top == -1) {
            return null;
        } else {
            E cur = stack[top];
            top--;
            return cur;
        }
    }

    @Override
    public boolean isEmpty() {
        return top < 0;
    }

    @Override
    public E top() {
        return stack[top];
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
