package Hw4_23001938_NguyenVanThang.exercise.exercise2;

public class Test {
    public static void main(String[] args) {
        ExpressionTree<Character> express = new ExpressionTree<>();
        express.addRoot('*');

        express.addLeft(express.root(), '+');
        express.addRight(express.root(), '-');

        express.addLeft(express.left(express.root()),'/');
        express.addRight(express.left(express.root()), '2');

        express.addLeft(express.left(express.left(express.root())), '6');
        express.addRight(express.left(express.left(express.root())), '3');

        express.addLeft(express.right(express.root()), '7');
        express.addRight(express.right(express.root()), '4');

        // Biểu thức tiền tố
        System.out.print("Biểu thức tiền tố: ");
        express.preorderPrint(express.root());

        System.out.println();

        // Biểu thức trung tố
        System.out.print("Biểu thức trung tố: ");
        express.inorderPrint(express.root());

        System.out.println();

        // Biểu thức hậu tố
        System.out.print("Biểu thức hậu tố: ");
        express.postorderPrint(express.root());

        System.out.println();
        System.out.print("Kết quả biểu thức là: ");
        System.out.println(express.evaluateOfTree(express.root()));
    }
}
