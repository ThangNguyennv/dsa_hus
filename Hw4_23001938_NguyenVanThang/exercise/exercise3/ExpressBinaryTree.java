package Hw4_23001938_NguyenVanThang.exercise.exercise3;

import java.util.Stack;

public class ExpressBinaryTree {
    public static int precedence(String c) { // độ ưu tiên
        if (c.equals("^")) {
            return 3;
        } else if (c.equals("*")|| c.equals("/")) {
            return 2;
        } else if (c.equals("+")|| c.equals("-")) {
            return 1;
        }
        return -1;
    }

    public static char associativity(String c) {
        if (c.equals("^")) { // nếu c == '^' ta tính kết hợp các số từ phải sang trái
            return 'R';
        }
        return 'L'; // nếu c != '^' ta tính kết hợp các số từ trái sang phải
    }

//    public static String infixToPostfix(String exp) {
//        String result = "";
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < exp.length(); i++) {
//            char c = exp.charAt(i);
//            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c >= '0' && c <= '9') {
//                result += c;
//            } else if (c == '(') {
//                stack.push(c);
//            } else if (c == ')') {
//                while (!stack.isEmpty() && stack.peek() != '(') {
//                    result += stack.pop(); // đã bị xóa khỏi stack
//                }
//                stack.pop(); // xóa dấu '(' ra khỏi stack
//            } else {
//                while (!stack.isEmpty() &&
//                        ((precedence(stack.peek()) >= precedence(c)) && associativity(c) == 'L')) {
//                    result += stack.pop();
//                }
//                stack.push(c);
//            }
//        }
//        while (!stack.isEmpty()) {
//            result += stack.pop();
//        }
//        return result;
//    }

    public static String[] infixToPostfix(String[] s) {
        Stack<String> stacks = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            String c = s[i];
            if (isNumber(c)) {
                sb.append(c).append(" ");
            } else if (c.equals("(")) {
                stacks.push(c);
            } else if (c.equals(")")) {
                while (!stacks.isEmpty() && stacks.peek() != "(") {
                    sb.append(stacks.pop()).append(" ");
                }
                stacks.pop();
            } else {
                while (!stacks.isEmpty()
                        && (precedence(stacks.peek()) >= precedence(c)
                        && associativity(c) == 'L')) {
                    sb.append(stacks.pop()).append(" ");
                }
                stacks.push(c);
            }
        }
        while (!stacks.isEmpty()) {
            sb.append(stacks.pop()).append(" ");
        }
        String res[] = sb.toString().split(" ");
        return res;
    }

    public static boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }
    }

//    public static void expressBinaryTree(String tokens) {
//
//        Stack<BinaryTreeNode<Character>> stacks = new Stack<>();
//        for (int i = 0; i < tokens.length(); i++) {
//            char c = tokens.charAt(i);
//            BinaryTreeNode<Character> node = new BinaryTreeNode<>(c);
//            if (c == '+' || c == '-' || c == '*' || c == '/') {
//                BinaryTreeNode<Character> rightChild = stacks.pop();
//                BinaryTreeNode<Character> leftChild = stacks.pop();
//                System.out.println("Node con trái: " + leftChild.data +
//                        ", Node con phải: " + rightChild.data +
//                        ", Node cha: " + node.data);
//            }
//            stacks.push(node);
//        }
//
//        while (!stacks.isEmpty()) {
//            System.out.println("Node gốc: " + stacks.pop().data);
//        }
//    }

    public static void expressBinaryTree(String[] tokens) {

        Stack<BinaryTreeNode<String>> stacks = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String c = tokens[i];
            BinaryTreeNode<String> node = new BinaryTreeNode<>(c);
            if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) {
                BinaryTreeNode<String> rightChild = stacks.pop();
                BinaryTreeNode<String> leftChild = stacks.pop();
                System.out.println("Node con trái: " + leftChild.data +
                        ", Node con phải: " + rightChild.data +
                        ", Node cha: " + node.data);
            }
            stacks.push(node);
        }

        while (!stacks.isEmpty()) {
            System.out.println("Node gốc: " + stacks.pop().data);
        }
    }

    public static void main(String[] args) {
        String[] tokens = {"(","6", "/", "300","+","2",")", "*", "(", "711", "-", "4",")"};
        String res[] = infixToPostfix(tokens); // 6300/2+7114-*
        expressBinaryTree(res);
    }
}
