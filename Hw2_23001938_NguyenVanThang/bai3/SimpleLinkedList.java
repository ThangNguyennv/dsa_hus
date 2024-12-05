package Hw2_23001938_NguyenVanThang.bai3;

import Hw2_23001938_NguyenVanThang.bai6.MyLinkedList;

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

    // addTop
    public void add(T data) {
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

    public void addBot(T val) {
        Node newNode = new Node(val);
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
                add(val);
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

    public T get(int i) {
        if (i >= 0 && i < n) {
            Node node = top;
            for (int j = 0; j < i; j++) {
                node = node.next;
            }
            return node.data;
        }
        return null;
    }

    public void set(int i, T data) {
        if (i >= 0 && i < n) {
            Node node = top;
            for (int j = 0; j < i; j++) {
                node = node.next;
            }
            node.setData(data);
        }
    }

    public boolean isContain(T data) {
        Node node = top;
        for (int i = 0; i < n; i++) {
            if (node.getData().equals(data)) {
                return true;
            } else {
                node = node.next;
            }
        }
        return false;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    // Xóa top và trả về top
    public T removeTop() {
        T head = top.data;
        if (n > 1) {
            top = top.next;
        } else {
            top = null;
            bot = null;
        }
        n--;
        return head;
    }

    // Xóa bot và trả về bot
    public T removeBot() {
        T tail = bot.data;
        Node prevTail = top;
        while (prevTail.next.next != null) {
            prevTail = prevTail.next;
        }
        prevTail.next = null;
        n--;
        return tail;
    }

    public void remove(T data) {
        if (n == 0) { // Kiểm tra danh sách rỗng?
            System.out.println("LinkedList is empty!!!");
            return;
        }
        Node temp = top;
        Node prevTemp = null;
        while (temp != null) {
            if (temp.data.equals(data)) {
                if (prevTemp == null) { // nếu phần tử cần xóa là node đầu
                    top = top.next;
                } else {
                    prevTemp.next = temp.next;
                }
                temp.data = null;
                n--;
            }
            prevTemp = temp;
            temp = temp.next;
        }
    }

    // hàm viết thêm
    public void removeOfIndex(int index) {
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

    public int indexOf(T data) {
        Node newNode = top;
        for (int i = 0; i < n; i++) {
            if (newNode.getData().equals(data)) {
                return i;
            } else {
                newNode = newNode.next;
            }
        }
        return -1;
    }

    public void printList() {
        Node node = top;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}