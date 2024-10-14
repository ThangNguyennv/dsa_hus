package Hw3_23001938_NguyenVanThang.practice_five;

import java.util.Scanner;
import java.util.Stack;

class EvaluatePostFix {
    public static int evaluatePostFix(String S) {
        Stack<Integer> stack1 = new Stack<>(); // stack lưu toán hạng
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (Character.isDigit(c)) {
                stack1.push(Integer.parseInt(String.valueOf(c)));
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                int number1 = stack1.pop();
                int number2 = stack1.pop();
                int result = 0;
                if (c == '+') {
                    result = number1 + number2;
                } else if (c == '-') {
                    result = number2 - number1;
                } else if (c == '*') {
                    result = number1 * number2;
                } else if (c == '/') {
                    result = number2 / number1;
                }
                stack1.push(result);
            }
        }
        return stack1.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine(); //  input: "231*+9-"
        System.out.println(evaluatePostFix(s)); // output: -4
    }
}