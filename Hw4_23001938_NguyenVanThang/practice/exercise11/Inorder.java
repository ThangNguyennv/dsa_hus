package Hw4_23001938_NguyenVanThang.practice.exercise11;

import java.util.ArrayList;

public class Inorder {
    class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    ArrayList<Integer> arrayList = new ArrayList<>();
    ArrayList<Integer> inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            arrayList.add(root.data);
            inOrder(root.right);
        }
        return arrayList;
    }
}
