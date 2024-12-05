package Hw3_23001938_NguyenVanThang.exercise_four.array_queue;

import java.util.Iterator;

public class ArrayQueue<E> implements QueueInterface<E> {
    private E[] queue;
    private int n = 0;
    private int top = 0;
    private int count = 0;
    private int default_size = 100;

    public ArrayQueue(int capacitty) {
        n = capacitty;
        queue = (E[]) new Object[default_size];
    }

    public ArrayQueue() {
        n = default_size;
        queue = (E[]) new Object[n];
    }

    @Override
    public void enqueue(E element) { // thêm phần tử vào cuối hàng đợi
        // TODO Auto-generated method stub
        if (count < n) { // queue chưa full
            queue[(top + count) % n] = element;
            count++;
        }
    }

    @Override
    public E dequeue() { // xóa phần tử ở đầu hàng đợi
        // TODO Auto-generated method stub
        if (count > 0) { // queue không rỗng
            E data = queue[top];
            count--;
            top++; // chuyển con trỏ top sang thằng bên phải
            if (top == n) { // kiểm soát hàng đợi tuan hoàn. Khi top đạt chỉ số bằng kích thước mảng,
                top = 0;    // nó sẽ đc đặt về 0 để tiếp tục từ đầu, giúp hàng đợi ko bị lãng phí ko gian
            }
            return data;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return count <= 0;
    }

    public boolean isFull() {
        return count >= n;
    }

    // su dung duyet phan tu thay vie viet ham printLint()
    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return new ArrayQueueIterator();
    }

    class ArrayQueueIterator implements Iterator<E> {
        private int current = top;
        private int num = 0;

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return num < count;
        }

        @Override
        public E next() {
            // TODO Auto-generated method stub
            E data = queue[(current + num) % n];
            num++;
            return data;
        }
    }
}
