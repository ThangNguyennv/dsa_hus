package Hw2_23001938_NguyenVanThang.bai5.exercise2;

import Hw2_23001938_NguyenVanThang.bai6.MyLinkedList;

import java.util.*;
public class SimpleLinkedList<T> {
    class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node top = null; // node đầu tiên
    private Node bot = null; // node cuối cùng
    private int n = 0;

    public void addTop(T data) {
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode;
            bot = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        n++;
    }

    public void addBot(T data) {
        Node newNode = new Node(data);
        if (n == 0) {
            top = newNode;
            bot = newNode;
        } else {
            bot.next = newNode;
            bot = newNode;
        }
        n++;
    }

    public void addAtIndex(int index, T val) {
        Node newNode = new Node(val);
        if (index >= 0 && index <= n) {
            if (index == 0) {
                addTop(val);
            } else if (index == n) {
                addBot(val);
            } else {
                Node cur = top;
                Node prev = null;
                for (int i = 0; i < index; i++) {
                    prev = cur;
                    cur = cur.next;
                }
                newNode.next = cur;
                prev.next = newNode;
                n++;
            }
        } else {
            try {
                throw new Exception("Invalid position");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void printList() {
        Node node = top;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        SimpleLinkedList<Integer> linkedList = new SimpleLinkedList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            linkedList.addBot(a[i]);
        }
        int position = sc.nextInt();
        int data = sc.nextInt();
        linkedList.addAtIndex(position, data);
        linkedList.printList();
    }
}