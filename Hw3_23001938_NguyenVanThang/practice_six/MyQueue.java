package Hw3_23001938_NguyenVanThang.practice_six;

public class MyQueue {
    class Node {
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node front = null;
    private Node rear = null;

    public void push(int a) { // thêm vào cuối queue(enqueue)
        Node newNode = new Node(a);
        newNode.next = null;
        if (rear != null) {
            rear.next = newNode;
        } else {
            front = newNode;
        }
        rear = newNode;
    }

    public int pop() { // lấy ra phần tử bị xóa ở đầu queue(dequeue)
        if (front != null) {
            Node node = front;
            int data = node.data;
            front = front.next;
            if (node == rear) {
                rear = null;
            }
            return data;
        }
        return -1;
    }

    public int front() {
        return front.data;
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(2);
        myQueue.push(12);
        myQueue.push(13);
        myQueue.push(15);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.front());
    }
}

