package Hw4_23001938_NguyenVanThang.practice.exercise3;

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
    public static boolean isLeafNode(Node node) {
        return node.left == null && node.right == null;
    }

    int countLeaves(Node node)
    {
        if (node == null) {
            return 0;
        }
        if (isLeafNode(node)) {
            return 1;
        } else {
            return countLeaves(node.left) + countLeaves(node.right);
        }
    }
}
