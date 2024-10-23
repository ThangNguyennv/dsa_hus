package Hw4_23001938_NguyenVanThang.practice.exercise1;

import java.util.Scanner;

public class CountLeaf {
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

    public static Node insert(Node t, int element) {
        if (t == null) {
            Node temp = new Node(element, t, null, null);
            return temp;
        } else {
            if (element < t.data) {
                t.left = insert(t.left, element);
            } else {
                t.right = insert(t.right, element);
            }
        }
        return t;
    }

    public static boolean isLeafNode(Node t) {
        return t.left == null && t.right == null;
    }

    public static int countLeafNode(Node t) {
        if (t == null) {
            return 0;
        }
        if (isLeafNode(t)) {
            return 1;
        }
        return countLeafNode(t.left) + countLeafNode(t.right);
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
        System.out.println(countLeafNode(t));
    }
}
