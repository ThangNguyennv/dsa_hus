package Hw4_23001938_NguyenVanThang.practice.exercise12;

import Hw4_23001938_NguyenVanThang.practice.exercise13.PostOrder;

import java.util.ArrayList;

public class PreOrder {
    class Node {
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
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static ArrayList<Integer> preorder(Node root)
    {
        if (root != null) {
            arrayList.add(root.data);
            preorder(root.left);
            preorder(root.right);
        }
        return arrayList;
    }

}
