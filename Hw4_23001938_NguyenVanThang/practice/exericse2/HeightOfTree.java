package Hw4_23001938_NguyenVanThang.practice.exericse2;

public class HeightOfTree {
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

    public static boolean isLeafNode(Node node) {
        return node.left == null && node.right == null;
    }

    public static int height(Node node) {
        if (node == null) {
            return 0;
        }
        if (isLeafNode(node)) {
            return 1;
        } else {
            return 1 + Math.max(height(node.left), height(node.right));
        }
    }
}
