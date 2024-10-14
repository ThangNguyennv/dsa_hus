package Hw3_23001938_NguyenVanThang.practice_one;

import java.util.Scanner;
import java.util.Stack;

public class StackBinary {
    public static String stackBin(int n) {
        Stack<String> stacks = new Stack<>();
        String result = "";
        while (n != 0) {
            stacks.push(String.valueOf(n % 2));
            n /= 2;
        }
       for (int i = stacks.size() - 1; i >= 0; i--) {
           result += stacks.get(i);
       }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(stackBin(n));
    }
}
