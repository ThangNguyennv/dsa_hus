package Hw3_23001938_NguyenVanThang.practice_ten;

public class MyCircularDeque {

    private int[] queue;
    private int size;
    private int front;
    private int rear;
    private int count;

    public MyCircularDeque(int k) {
        size = k;
        queue = new int[size];
        front = rear = -1;
        count = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        } else {
            front--;
            if (isEmpty()) {
                front = rear = size - 1;
            } else {
                if (front == -1) {
                    front = size - 1;
                }
            }
            queue[front] = value;
            count++;
            return true;
        }
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        } else {
            rear++;
            if (isEmpty()) {
                front = rear;
            } else {
                if (rear == size) {
                    rear = 0;
                }
            }
            queue[rear] = value;
            count++;
            return true;
        }
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        } else {
            front++;
            if (count == 1) {
                front = rear = -1;
            } else {
                if (front == size) {
                    front = 0; // quay đầu
                }
            }
            count--;
            return true;
        }
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        } else {
            rear--;
            if (count == 1) {
                front = rear = -1;
            } else {
                if (rear == -1) {
                    rear = size - 1; // quay đầu
                }
            }
            count--;
            return true;
        }
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return queue[front];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[rear];
    }

    public boolean isEmpty() {
        return count <= 0;
    }

    public boolean isFull() {
        return count >= size;
    }

    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        System.out.println(myCircularDeque.insertLast(1));; // trả về True
        System.out.println(myCircularDeque.insertLast(2));; // trả về True
        System.out.println(myCircularDeque.insertFront(3));; // trả về True
        System.out.println(myCircularDeque.insertFront(4));; // trả về False, hàng đợi đã đầy.
        System.out.println(myCircularDeque.getRear());; // trả về 2
        System.out.println(myCircularDeque.isFull());; // trả về True
        System.out.println(myCircularDeque.deleteLast());; // trả về True
        System.out.println(myCircularDeque.insertFront(4));; // trả về True
        System.out.println(myCircularDeque.getFront());; // trả về 4
    }
}
