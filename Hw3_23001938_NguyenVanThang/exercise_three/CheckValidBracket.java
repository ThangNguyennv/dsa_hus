package Hw3_23001938_NguyenVanThang.exercise_three;

import java.util.Stack;

public class CheckValidBracket {
    public static boolean isValid(String strings) {
        Stack<Character> stack1 = new Stack<>();
        for (int i = 0; i < strings.length(); i++) {
            if (strings.charAt(i) == '(') {
                stack1.push(strings.charAt(i));
            } else {
                if (strings.charAt(i) == ')') {
                    stack1.pop();
                }
            }
        }
        if (stack1.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = " (10 +8 )/(( 5−2 )∗ 17 ) ";
        System.out.println(isValid(s));
    }
}

