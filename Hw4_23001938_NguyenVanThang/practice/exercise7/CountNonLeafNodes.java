package Hw4_23001938_NguyenVanThang.practice.exercise7;

import java.util.LinkedList;
import java.util.Queue;

public class CountNonLeafNodes {
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
    int countNonLeafNodes(Node node) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(node);
        int count = 0;
        while (!q.isEmpty()) {
            Node curr = q.peek();
            q.remove();

            boolean isInternal = false;

            if (curr.left != null) {
                isInternal = true;
                q.add(curr.left);
            }
            if (curr.right != null) {
                isInternal = true;
                q.add(curr.right);
            }
            if (isInternal == true) {
                count++;
            }
        }
        return count;
    }
}
