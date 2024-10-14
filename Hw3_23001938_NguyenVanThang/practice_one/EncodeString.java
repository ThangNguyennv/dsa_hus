package Hw3_23001938_NguyenVanThang.practice_one;

import java.util.Scanner;
import java.util.Stack;

public class EncodeString { // chưa xong
    public static String encodeString(String s) {
        Stack<Character> stack1 = new Stack<>();
        s = s + "!";
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack1.isEmpty() || (stack1.peek() == c)) {
                stack1.push(c);
            } else {
                int count = 0;
                result = result + stack1.peek();
                while (!stack1.isEmpty()) {
                    count++;
                    stack1.pop();
                }
                result = result + Integer.toString(count);
                stack1.push(c);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(encodeString(s));
    }
}
