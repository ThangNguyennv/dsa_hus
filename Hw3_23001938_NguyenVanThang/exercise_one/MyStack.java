package Hw3_23001938_NguyenVanThang.exercise_one;

import java.util.Stack;

public class MyStack {

    public static void main(String[] args) {
        Stack<Character> s = new Stack<>();
        String hoten = "NguyenVanThang";
        for (int i = 0; i < hoten.length(); i++) {
            if(i % 2 == 0) {
                s.push(hoten.charAt(i)) ;
            }
            if(i % 3 == 0) {
                s.pop () ;
            }
        }
        System.out.print(s.peek() + " "); // output: h
    }
}
