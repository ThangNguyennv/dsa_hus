package Hw4_23001938_NguyenVanThang.practice.exercise1;

import java.util.Scanner;

public class BinaryTree {
    static class Node {
        int data;
        Node parent;
        Node left;
        Node right;

        public Node(int data, Node parent, Node left, Node right) {
            this.data = data;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }

    public static Node insert(Node t, int x) {
        if (t == null) {
            Node temp = new Node(x, null, null, null);
            return temp;
        } else {
            if (x < t.data) {
                t.left = insert(t.left, x);
            } else {
                t.right = insert(t.right, x);
            }
        }
        return t;
    }

    public static void inorder(Node t) {
        if (t != null) {
            inorder(t.left);
            System.out.print(t.data + " ");
            inorder(t.right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        Node t = null;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            t = insert(t, arr[i]);
        }
        inorder(t);
    }
}
