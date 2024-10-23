package Hw4_23001938_NguyenVanThang.exercise.exercise1;

import java.io.FileWriter;

public class LinkedBinaryTree<E, T> implements BinaryTreeInterface<LinkedBinaryTree.Node<E>> {
    protected static class Node<E> {
        private E element; // an element stored at this node
        private Node<E> parent; // a reference to the parent node (if any)
        private Node<E> left; // a reference to the left child
        private Node<E> right; // a reference to the right child

        public E getElement() {
            return element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public Node<E> getRight() {
            return right;
        }

        // Constructs a node with the given element and neighbors.
        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }
    }

    private int size = 0;
    private Node<E> root = null;

    public Node<E> addRoot(E element) {
        // Add element to root of an empty tree
        if (root == null) {
            root = new Node<>(element, null, null, null);
            size++;
        } else {
            System.out.println("Đã tồn tại root!");
        }
        return root;
    }

    public Node<E> addLeft(Node p, E element) {
        // Add element to left child node of p if empty
        if (p.left == null) {
            p.left = new Node<>(element, p, null, null);
            size++;
        } else {
            System.out.println("Đã tồn tại node con trái!");
        }
        return p.left;
    }

    public Node<E> addRight(Node p, E element) {
        // Add element to right child node of p if empty
        if (p.right == null) {
            p.right = new Node<>(element, p, null, null);
            size++;
        } else {
            System.out.println("Đã tồn tại node con phải!");
        }
        return p.right;
    }

    public void set(Node p, E element) {
        // set element to node p
        p.element = element;
    }

    @Override
    public Node<E> root() {
        return root;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int numChildren(Node<E> p) {
        if (p.left != null && p.right != null) {
            return 2;
        } else if (p.left != null || p.right != null) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public Node<E> parent(Node<E> p) {
        return p.parent;
    }

    @Override
    public Node<E> left(Node<E> p) {
        return p.left;
    }

    @Override
    public Node<E> right(Node<E> p) {
        return p.right;
    }

    @Override
    public Node<E> sibling(Node<E> p) {
        if (p.parent.left == p) {
            return p.right;
        } else if (p.parent.right == p) {
            return p.left;
        } else {
            return null;
        }
    }

    static final int count = 2;

    public void printTree(Node<E> p, int space, FileWriter fw) {
        if (p == null)
            return;
        space += count;
        printTree(p.right, space, fw);

        for (int i = count; i < space; i++) {
            try {
                fw.write(" ");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        try {
            fw.write(p.element.toString()+"\n");
        } catch (Exception e) {
            System.out.println(e);
        }
        printTree(p.left, space, fw);
    }

    public void printTreeToFile(Node<E> p, int space) {
        try {
            FileWriter fw = new FileWriter("G:\\My Drive\\CTDL_GT_SCHOOL\\src\\Hw4_23001938_NguyenVanThang\\exercise\\exercise_one\\output.txt");
            printTree(p, space, fw);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
