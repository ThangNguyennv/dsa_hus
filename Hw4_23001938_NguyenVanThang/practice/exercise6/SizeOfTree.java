package Hw4_23001938_NguyenVanThang.practice.exercise6;

public class SizeOfTree {
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
    public static int getSize(Node node) {
        // code here
        if (node == null) {
            return 0;
        }
        int size = getSize(node.left) + getSize(node.right) + 1;
        return size;
    }
}
