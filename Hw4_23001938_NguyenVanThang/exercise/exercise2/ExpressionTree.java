package Hw4_23001938_NguyenVanThang.exercise.exercise2;

import Hw4_23001938_NguyenVanThang.exercise.exercise1.LinkedBinaryTree;

public class ExpressionTree<E> extends LinkedBinaryTree<E, Integer> {
    private Node<E> p;
    public void preorderPrint(Node<E> p) { // root-left-right
        if (p == null) {
            return;
        }
        System.out.print(p.getElement());
        preorderPrint(p.getLeft());
        preorderPrint(p.getRight());
    }

    public void inorderPrint(Node<E> p) { // left-root-right
        if (p == null) {
            return;
        }
        inorderPrint(p.getLeft());
        System.out.print(p.getElement());
        inorderPrint(p.getRight());
    }

    public void postorderPrint(Node<E> p) { // left-right-root
        if (p == null) {
            return;
        }
        postorderPrint(p.getLeft());
        postorderPrint(p.getRight());
        System.out.print(p.getElement());
    }

    private double operator(Character o, double a, double b) {
        if (o == '+') {
            return a + b;
        } else if (o == '-') {
            return a - b;
        } else if (o == '*') {
            return a * b;
        } else if (o == '/') {
            if (b == 0) {
                throw new ArithmeticException();
            }
            return a / b;
        } else {
            return 0;
        }
    }

    public double evaluateOfTree(Node<E> p) {
        if (p == null) {
            return 0;
        }
        if (p.getLeft() == null || p.getRight() == null) {
            return Double.parseDouble(String.valueOf(p.getElement()));
        }
        double a = evaluateOfTree(p.getLeft());
        double b = evaluateOfTree(p.getRight());
        return operator((Character) p.getElement(), a, b);
    }
}
