package Hw3_23001938_NguyenVanThang.practice_four;

import java.util.Scanner;
import java.util.Stack;

class ValidBracket {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                int top = stack.pop();
                if ((top != '(' && s.charAt(i) == ')') ||
                        (top != '{' && s.charAt(i) == '}') ||
                        (top != '[' && s.charAt(i) == ']')) {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine(); // input: "()[]{}"
        System.out.println(isValid(s)); // output: true
    }
}
