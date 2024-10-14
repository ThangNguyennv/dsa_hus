package Hw2_23001938_NguyenVanThang.bai5.exercise3;

import Hw2_23001938_NguyenVanThang.bai6.MyLinkedList;

import java.util.Scanner;

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

    private Node top = null;
    private Node bot = null;
    private int n = 0;

    public void removeTop() {
        if (n > 1) {
            top = top.next;
        } else {
            top = null;
            bot = null;
        }
        n--;
    }

    public void removeBot() {
        Node prev = top;
        while (prev.next.next != null) {
            prev = prev.next;
        }
        prev.next = null;
        n--;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= n) {
            System.out.println("Index is invalid");
            return;
        }
        if (index == 0) {
            top = top.next;
            if (n == 1) {  // Nếu chỉ có 1 phần tử, cập nhật lại bot
                bot = null;
            }
        } else {
            Node prev = null;
            Node cur = top;
            for (int i = 0; i < index; i++) {
                prev = cur;
                cur = cur.next;
            }
            prev.next = cur.next;
            if (cur == bot) {
                bot = prev;
            }
        }
        n--;
    }

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

    public void printList() {
        Node node = top;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        SimpleLinkedList list = new SimpleLinkedList();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();;
        }
        for (int i = 0; i < n; i++) {
            list.addBot(a[i]);
        }
        int k = sc.nextInt();;
        list.deleteAtIndex(k);
        list.printList();
    }
}
