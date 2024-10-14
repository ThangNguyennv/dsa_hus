package Hw3_23001938_NguyenVanThang.practice_seven;

import java.util.Stack;

class StackQueue {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    public void Push(int x) {
        s1.push(x);
    }

    public int Pop() {
        if (isEmpty()) { //queue rỗng
            return -1;
        }
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public static void main(String[] args) {
        StackQueue stackQueue = new StackQueue();
        stackQueue.Push(2);
        stackQueue.Push(3);
        System.out.println(stackQueue.Pop()); // 2
        stackQueue.Push(4);
        System.out.println(stackQueue.Pop()); // 3
    }
}