package Hw3_23001938_NguyenVanThang.practice_nine;

import java.util.ArrayList;

class MyCircularQueue {
    class Node {
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    private int[] queue;
    private int size;
    private int front;
    private int rear;
    private int count;

    public MyCircularQueue(int k) { // Khởi tạo đối tượng có kích thước của hàng đợi là k
        size = k;
        queue = new int[size];
        front = rear = -1;
        count = 0;
    }

    public boolean enQueue(int value) { // Chèn một phần tử vào cuối hàng đợi vòng tròn
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

    public boolean deQueue() { // Xóa một phần tử khỏi đầu hàng đợi vòng tròn
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

    public int Front() { // Lấy phần tử đầu tiên từ hàng đợi
        if (isEmpty()) {
            return -1;
        }
        return queue[front];
    }

    public int Rear() { // Lấy phần tử cuối cùng từ hàng đợi
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
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        System.out.println(myCircularQueue.enQueue(1));;  // return True
        System.out.println(myCircularQueue.enQueue(2));;  // return True
        System.out.println(myCircularQueue.enQueue(3));;  // return True
        System.out.println(myCircularQueue.enQueue(4));;  // return False
        System.out.println(myCircularQueue.Rear());            // return 3
        System.out.println(myCircularQueue.isFull());;          // return True
        System.out.println(myCircularQueue.deQueue());;         // return True
        System.out.println(myCircularQueue.enQueue(4));;  // return True
        System.out.println(myCircularQueue.Rear());;            // return 4
    }
}
