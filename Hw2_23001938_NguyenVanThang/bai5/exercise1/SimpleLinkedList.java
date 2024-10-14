package Hw2_23001938_NguyenVanThang.bai5.exercise1;

import java.util.Scanner;

public class SimpleLinkedList {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
    private Node head = null;
    private int n = 0;

    public SimpleLinkedList() {

    }

    public void printList() {
        Node top = head;
        while (top != null) {
            System.out.print(top.data + " ");
            top = top.next;
        }
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
        }
        n++;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        SimpleLinkedList linkedList = new SimpleLinkedList();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            linkedList.add(a[i]);
        }
        linkedList.printList();
    }
} 