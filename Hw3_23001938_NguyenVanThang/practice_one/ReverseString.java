package Hw3_23001938_NguyenVanThang.practice_one;

import java.util.Stack;
import java.util.Scanner;

public class ReverseString {
    public static String stack(String s) {
        Stack<Character> stacks = new Stack<>();
        String result = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            stacks.push(s.charAt(i));
            result += stacks.pop();
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(stack(s));
    }
}
