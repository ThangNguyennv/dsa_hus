package Hw4_23001938_NguyenVanThang.practice.exercise15;

import Hw4_23001938_NguyenVanThang.practice.exercise14.LevelOrder;

import java.util.ArrayList;
import java.util.Stack;

public class ZigZagTraversal {
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
    static ArrayList<Integer> zigZagTraversal(Node root)
    {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null) {
            return arrayList;
        }
        Stack<Node> currentLevel = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();
        currentLevel.push(root);
        boolean leftToRight = true;
        while (!currentLevel.isEmpty()) {
            int size = currentLevel.size();
            while (size != 0) {
                Node curr = currentLevel.pop();
                arrayList.add(curr.data);
                if (leftToRight == true) {
                    if (curr.left != null) {
                        nextLevel.push(curr.left);
                    }
                    if (curr.right != null) {
                        nextLevel.push(curr.right);
                    }
                } else {
                    if (curr.right != null) {
                        nextLevel.push(curr.right);
                    }
                    if (curr.left != null) {
                        nextLevel.push(curr.left);
                    }
                }
                size--;
            }
            leftToRight = !leftToRight;
            Stack<Node> temp = currentLevel;
            currentLevel = nextLevel;
            nextLevel = temp;
        }
        return arrayList;
    }
}
