package Hw4_23001938_NguyenVanThang.practice.exercise20;

import java.util.LinkedList;
import java.util.Queue;

public class BuildBinaryTree {
    class Tree {
        int data;
        Tree left;
        Tree right;

        Tree(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public Tree convert(Node head, Tree node) {
        if (head == null) {
            return null;
        }
        Queue<Tree> q = new LinkedList<>();
        Tree root = new Tree(head.data);
        q.add(root);

        head = head.next;

        while (head != null) {
            Tree parent = q.poll();

            Tree leftChild = null, rightChild = null;
            if (head != null) {
                leftChild = new Tree(head.data);
                q.add(leftChild);
                head = head.next;
            }
            if (head != null) {
                rightChild = new Tree(head.data);
                q.add(rightChild);
                head = head.next;
            }
            parent.left = leftChild;
            parent.right = rightChild;
        }
        return root;
    }
}
