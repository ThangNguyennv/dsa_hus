package Hw3_23001938_NguyenVanThang.practice_five;

import java.util.Scanner;
import java.util.Stack;

class InfixToPostFix {
    public static int precedence(char c) { // độ ưu tiên
        if (c == '^') {
            return 3;
        } else if (c == '/' || c == '*') {
            return 2;
        } else if (c == '+' || c == '-') {
            return 1;
        } else {
            return -1;
        }
    }

    public static char associativity(char c) {
        if (c == '^') { // nếu c == '^' ta tính kết hợp các số từ phải sang trái
            return 'R';
        }
        return 'L'; // nếu c != '^' ta tính kết hợp các số từ trái sang phải
    }

    public static String infixToPostfix(String exp) {
        String result = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c >= '0' && c <= '9') {
                result += c;
            } else if (c == '('){
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop(); // đã bị xóa khỏi stack
                }
                stack.pop(); // xóa dấu '(' ra khỏi stack
            } else {
                while (!stack.isEmpty() &&
                        ((precedence(c) < precedence(stack.peek()) ||
                                precedence(c) == precedence(stack.peek())) && associativity(c) == 'L')) {
                    result += stack.pop();
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine(); //  input: "a+b*(c^d-e)^(f+g*h)-i"
        System.out.println(infixToPostfix(s)); // output: abcd^e-fgh*+^*+i-
    }
}