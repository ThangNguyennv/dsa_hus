package degiuaki_so1.bai2;

import java.util.LinkedList;
import java.util.Queue;

public class Tree<T> {
    class Node{
        T data;
        Node left;
        Node right;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }
    }
    void travel(Node tree)
    {
        if (tree == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp + " ");
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }


}