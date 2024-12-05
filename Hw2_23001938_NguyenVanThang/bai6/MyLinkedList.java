package Hw2_23001938_NguyenVanThang.bai6;

public class MyLinkedList {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
    private Node top;
    private Node bot;
    private int n = 0;
    public MyLinkedList() {
        top = null;
        bot = null;
    }
    public int get(int index) {
        if (index >= 0 && index < n) {
            Node node = top;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node.data;
        }
        return -1;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if (top == null) {
            top = newNode;
            bot = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        n++;
    }

    public void addAtTail(int val) {
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

    public void addAtIndex(int index, int val) {
        Node newNode = new Node(val);
        if (index >= 0 && index <= n) {
            if (index == 0) {
                addAtHead(val);
            } else if (index == n) {
                addAtTail(val);
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

    public void printList() {
        Node node = top;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */