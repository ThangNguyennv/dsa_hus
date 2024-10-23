package Hw4_23001938_NguyenVanThang.practice.exercise21;


import java.util.LinkedList;
import java.util.Queue;

public class BuildTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    public static Node buildTree(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(arr[0]);
        q.add(root);
        int index = 1;
        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (index < arr.length) {
                Node newNode = new Node(arr[index]);
                curr.left = newNode;
                index++;
                q.add(curr.left);
            }
            if (index < arr.length) {
                Node newNode = new Node(arr[index]);
                curr.right = newNode;
                index++;
                q.add(curr.right);
            }
        }
        return root;
    }

    public static void printTree(Node root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.data + " ");
            printTree(root.right);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 6, 6, 6 };
        Node root = buildTree(arr);
        printTree(root);
    }
}
