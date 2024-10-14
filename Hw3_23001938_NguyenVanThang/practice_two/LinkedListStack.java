package Hw3_23001938_NguyenVanThang.practice_two;

class LinkedListStack {
     class Node {
         int data;
         Node next;
         Node(int a) {
             data = a;
             next = null;
         }
     }
    Node top;
    int size = 0;
    public void push(int a) { // thêm vào đỉnh stack
        Node newNode = new Node(a);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        size++;
    }

    public int pop() { // xóa bỏ đỉnh stack và trả về giá trị cần xóa
        if (top == null) {
            return -1;
        } else {
            int node = top.data;
            if (size > 1) {
                top = top.next;
            } else {
                top = null;
            }
            size--;
            return node;
        }
    }

    public static void main(String[] args) {
        LinkedListStack linkedListStack = new LinkedListStack();
        linkedListStack.push(1);
        linkedListStack.push(2);
        linkedListStack.push(6);
        linkedListStack.push(32);
        System.out.println(linkedListStack.pop());
    }
}