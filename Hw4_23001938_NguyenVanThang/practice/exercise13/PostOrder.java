package Hw4_23001938_NguyenVanThang.practice.exercise13;

import java.util.ArrayList;

public class PostOrder {
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
    ArrayList<Integer> arrayList = new ArrayList<>();
    ArrayList<Integer> postOrder(Node root)
    {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            arrayList.add(root.data);
        }
        return arrayList;
    }
}
