package Hw4_23001938_NguyenVanThang.exercise.exercise1;

public class Test {
    public static void main(String[] args) {
//        ArrayBinaryTree<Integer, Integer> arrayBinaryTree = new ArrayBinaryTree<Integer, Integer>();
//        arrayBinaryTree.setRoot(1);
//        arrayBinaryTree.setLeft(1, 4);
//        arrayBinaryTree.setRight(1, 5);
//        arrayBinaryTree.setLeft(1, 6);
//        arrayBinaryTree.setRight(1, 9);

        LinkedBinaryTree<Integer, Integer> linkedBinaryTree = new LinkedBinaryTree<Integer, Integer>();
        linkedBinaryTree.addRoot(1);
        linkedBinaryTree.addLeft(linkedBinaryTree.root(), 5);
        linkedBinaryTree.addRight(linkedBinaryTree.root(), 3);

        linkedBinaryTree.addLeft(linkedBinaryTree.left(linkedBinaryTree.root()), 8);
        linkedBinaryTree.addRight(linkedBinaryTree.left(linkedBinaryTree.root()), 6);
        linkedBinaryTree.addLeft(linkedBinaryTree.right(linkedBinaryTree.root()), 2);
        linkedBinaryTree.addRight(linkedBinaryTree.right(linkedBinaryTree.root()), 7);

        linkedBinaryTree.printTreeToFile(linkedBinaryTree.root(), 0);
    }
}
